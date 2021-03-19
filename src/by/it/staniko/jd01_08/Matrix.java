package by.it.staniko.jd01_08;

class Matrix extends by.it.staniko.jd01_08.Var {
    public Matrix(String strMatrix) {
    }

    private double[][] value;

    public Matrix(double[][] value) {
        this.value = value;
    }


    public Matrix(Matrix otherMatrix) {

        this.value = otherMatrix.value;
    }
/*
    public Matrix(String strMatrix) {
        String matrix=strMatrix.replaceAll("[\\{\\}\\ ]", " ");
        String[][] arrayMatrix=matrix.split(",");



        this.value = otherMatrix.value;
    }

*/
/*
    @Override
    public String toString() {
            StringBuilder sb = new StringBuilder("{");
            String delimiter = "";
            for (double[] element : value) {
                sb.append(delimiter).append("{");
                delimiter = "";
                for (int j = 0; j < element.length; j++) {
                    sb.append(delimiter).append(element[j]);
                    delimiter = ", ";
                }
                sb.append("}");
            }
            sb.append("}");

            return sb.toString();
        }
*/
}
