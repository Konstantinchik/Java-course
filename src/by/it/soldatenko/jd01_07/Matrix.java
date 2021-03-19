package by.it.soldatenko.jd01_07;

public class Matrix extends Var {
    private double[][] value;

    Matrix(double[][] value) {
        this.value = value;
    }

    Matrix(Matrix matrix) {
        this.value = matrix.value;
    }

    Matrix(String strMatrix) {
        String a = strMatrix.replaceAll("[\\{\\}\\ ]", "");
        String[] str = a.split(",");
        double[][] d = new double[str.length / 2][str.length / 2];
        int count = 0;
        for (int i = 0; i < str.length / 2; i++) {
            for (int j = 0; j < str.length / 2; j++) {
                d[i][j] = Double.parseDouble(str[count]);
                count++;
            }
        }
        this.value = d;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (int i = 0; i < value.length; i++) {
            sb.append("{");
            String delimiter = "";
            for (int j = 0; j < value.length; j++) {
                sb.append(delimiter).append(value[i][j]);
                delimiter = ", ";
            }
            sb.append("}");
            if( i< (value.length-1)){
            sb.append(delimiter);
            }
        }
        sb.append("}");
        return sb.toString();

    }
}
