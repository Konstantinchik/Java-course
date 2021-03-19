package by.it.evstratov.jd01_07;

import java.util.StringJoiner;

 class Matrix extends Var{

    private final double[][] value;

    public Matrix(double[][] value) {
        this.value = value;
    }

    public Matrix(Matrix otherMatrix) {
        this.value = otherMatrix.value;
    }

    public Matrix(String strMatrix) {
        String str = strMatrix.replaceAll("},","} -");
        String[] arrayMatrixToString = str.split("-");
        this.value = new double[arrayMatrixToString.length][];
        for (int i = 0; i < value.length; i++) {
            String line = arrayMatrixToString[i].replaceAll("[{}]","");
            String[] arrayStrings = line.split(",");
            value[i] = new double[arrayStrings.length];
            for (int j = 0; j < arrayStrings.length; j++) {
                value[i][j] = Double.parseDouble(arrayStrings[j].trim());
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (int i = 0; i < value.length; i++) {
            StringJoiner stringJoiner = new StringJoiner(", ", "{", "}");
            for (int j = 0; j < value[i].length; j++) {
                stringJoiner.add(Double.toString(value[i][j]));
            }
            sb.append(stringJoiner);
            if(i+1 != value.length){
                sb.append(", ");
            }else{
                sb.append("}");
            }
        }
        return sb.toString();
    }
}
