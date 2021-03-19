package by.it.plehanova.jd02_04;

import java.util.Arrays;

class Matrix extends Var {

    private double[][] matrix;

    Matrix(double[][] value) {
        this.matrix = copyArray(value);
    }

    Matrix(String strMatrix) {
        this.matrix = copyArray(numberOfString(strMatrix));
    }

    Matrix(Matrix matrix) {
        this.matrix = copyArray(matrix.matrix);
    }

    public double[][] getMatrix() {
        return matrix;
    }

    @Override
    public Var add(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[][] arr = copyArray(this.matrix);
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[0].length; j++) {
                    arr[i][j] += ((Scalar) other).getValue();
                }
            }
            return new Matrix(arr);

        } else if (other instanceof Matrix) {
            if (this.matrix.length != ((Matrix) other).matrix.length
                    || this.matrix[0].length != ((Matrix) other).matrix[0].length) {
                return super.add(other);
            }
            double[][] arr = new double[this.matrix.length][((Matrix) other).matrix[0].length];
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[0].length; j++) {
                    arr[i][j]= this.matrix[i][j] + ((Matrix) other).matrix[i][j];
                }
            }
            return new Matrix(arr);

        } else {
            return super.add(other);
        }
    }

    @Override
    public Var sub(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[][] arr = copyArray(this.matrix);
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[0].length; j++) {
                    arr[i][j] -= ((Scalar) other).getValue();
                }
            }
            return new Matrix(arr);

        } else if (other instanceof Matrix) {
            if (this.matrix.length != ((Matrix) other).matrix.length
                    || this.matrix[0].length != ((Matrix) other).matrix[0].length) {
                return super.add(other);
            }
            double[][] arr = copyArray(matrix);
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[0].length; j++) {
                    arr[i][j] -= ((Matrix) other).matrix[i][j];
                }
            }
            return new Matrix(arr);

        } else {
            return super.sub(other);
        }
    }

    @Override
    public Var mul(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[][] arr = copyArray(this.matrix);
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[0].length; j++) {
                    arr[i][j] *= ((Scalar) other).getValue();
                }
            }
            return new Matrix(arr);

        } else if (other instanceof Vector) {

            if (((Vector) other).getArray().length != matrix[0].length) {
                return super.add(other);
            }
            double[] result = new double[matrix.length];
            double[] vector = Arrays.copyOf(((Vector) other).getArray(), ((Vector) other).getArray().length);
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    result[i] = result[i] + matrix[i][j] * vector[j];
                }
            }
            return new Vector(result);

        } else if (other instanceof Matrix) {
            if (this.matrix[0].length != ((Matrix) other).matrix.length) {
                return super.add(other);
            }
            double[][] result = new double[matrix.length][((Matrix) other).matrix[0].length];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < ((Matrix) other).matrix[0].length; j++) {
                    for (int k = 0; k <((Matrix) other).matrix.length ; k++) {
                        result[i][j] += matrix[i][k]*((Matrix) other).matrix[k][j];
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
                System.out.println("Division by zero");
                return null;
            }
            double[][] result = copyArray(matrix);
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[0].length; j++) {
                    result[i][j] /=((Scalar) other).getValue();
                }
            }
            return new Matrix(result);
        }else {
            return super.div(other);
        }
    }

    private double[][] numberOfString(String str) {

        str = str.replace("[{]+|[}]$", "");
        String[] number = str.split("},");

        String[][] multiNumber = new String[number.length][];

        for (int i = 0; i < number.length; i++) {
            multiNumber[i] = number[i].replaceAll("[^0-9.]+", " ").trim().split(" ");
        }

        double[][] matrix = new double[multiNumber.length][multiNumber[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < multiNumber[i].length; j++) {
                matrix[i][j] = Double.parseDouble(multiNumber[i][j]);
            }
        }
        return matrix;
    }

    private double[][] copyArray(double[][] array) {
        double[][] copy = new double[array.length][];
        for (int i = 0; i < array.length; i++) {
            copy[i] = Arrays.copyOf(array[i], array[i].length);
        }
        return copy;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        String delimiter = "";
        for (double[] element : matrix) {
            sb.append(delimiter).append("{");
            delimiter = "";
            for (double v : element) {
                sb.append(delimiter).append(v);
                delimiter = ", ";
            }
            sb.append("}");
        }
        sb.append("}");

        return sb.toString();
    }
}
