package by.it.leshchenko.calc;

import java.util.Arrays;
import java.util.StringJoiner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Matrix extends Var {
    private final double[][] value;

    public Matrix(double[][] value) {
        this.value = value;
    }

    public Matrix(Matrix matrix) {
        this.value = matrix.value;
    }

    public double[][] getValue() {
        return value;
    }

    public Matrix(String strMatrix) {
        // Получаем строки матрицы и количество столбцов
        Matcher matcher = Pattern.compile("\\{\\{(.*)}}").matcher(strMatrix);
        String[] strings;
        int col_length = 0;
        if (matcher.find()) {
            strings = matcher.group(1).split("}+,\\s?\\{+"); // Получаем массив строк
            col_length = strings[0].split(".,\\s?").length; // Считаем количество колонок
        } else {
            strings = new String[0];
        }

        // Формируем новый массив
        double[][] array = new double[strings.length][col_length];
        for (int i = 0; i < strings.length; i++) {
            String[] cols = strings[i].split(",\\s?"); // Получаем столбцы
            for (int j = 0; j < cols.length; j++) {
                array[i][j] = Double.parseDouble(cols[j]);
            }
        }
        value = Arrays.copyOf(array, array.length);
    }

    @Override
    public Var add(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[][] array = Arrays.copyOf(value, value.length);
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++) {
                    array[i][j] += ((Scalar) other).getValue();
                }
            }
            return new Matrix(array);
        } else if (other instanceof Matrix && this.value.length == ((Matrix) other).value.length && this.value[0].length == ((Matrix) other).value[0].length) {
            // Copy array
            double[][] array = new double[value.length][];
            for (int i = 0; i < array.length; i++) {
                array[i] = Arrays.copyOf(value[i], value.length);
            }
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++) {
                    array[i][j] += ((Matrix) other).value[i][j];
                }
            }
            return new Matrix(array);
        } else {
            return super.add(other);
        }
    }

    @Override
    public Var sub(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[][] array = Arrays.copyOf(value, value.length);
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++) {
                    array[i][j] -= ((Scalar) other).getValue();
                }
            }
            return new Matrix(array);
        } else if (other instanceof Matrix && this.value.length == ((Matrix) other).value.length && this.value[0].length == ((Matrix) other).value[0].length) {
            // Copy array
            double[][] array = new double[value.length][];
            for (int i = 0; i < array.length; i++) {
                array[i] = Arrays.copyOf(value[i], value.length);
            }
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++) {
                    array[i][j] -= ((Matrix) other).value[i][j];
                }
            }
            return new Matrix(array);
        } else {
            return super.sub(other);
        }
    }

    @Override
    public Var mul(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[][] array = Arrays.copyOf(value, value.length);
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++) {
                    array[i][j] *= ((Scalar) other).getValue();
                }
            }
            return new Matrix(array);
        } else if (other instanceof Vector && value[0].length == ((Vector) other).getValue().length) {
            double[] array = new double[value.length];
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < ((Vector) other).getValue().length; j++) {
                    array[i] = array[i] + value[i][j] * ((Vector) other).getValue()[j];
                }
            }
            return new Vector(array);
        } else if (other instanceof Matrix && (this.value[0].length == ((Matrix) other).value.length)) {
            // Copy array
            double[][] array = new double[value.length][];
            for (int i = 0; i < array.length; i++) {
                array[i] = Arrays.copyOf(value[i], value.length);
            }
            double[][] result = new double[value.length][((Matrix) other).value[0].length];
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < ((Matrix) other).value[i].length; j++) {
                    for (int k = 0; k < ((Matrix) other).value.length; k++) {
                        result[i][j] = result[i][j] + array[i][k] * ((Matrix) other).value[k][j];
                    }
                }
            }
            return new Matrix(result);
        } else {
            return super.mul(other);
        }
    }

    @Override
    public Var div(Var other) throws CalcException {
        if (other instanceof Scalar) {
            if (((Scalar) other).getValue() == 0) {
                System.out.println("Деление на 0 невозможно");
                return null;
            }
            double[][] array = Arrays.copyOf(value, value.length);
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++) {
                    array[i][j] /= ((Scalar) other).getValue();
                }
            }
            return new Matrix(array);
        } else {
            return super.div(other);
        }
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "{", "}");
        for (double[] row : value) {
            StringJoiner joiner2 = new StringJoiner(", ", "{", "}");
            for (double col : row) {
                joiner2.add(Double.toString(col));
            }
            joiner.add(joiner2.toString());
        }
        return joiner.toString();
    }
}
