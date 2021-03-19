package by.it.leshchenko.jd01_07;

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
