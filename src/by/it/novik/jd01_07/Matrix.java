package by.it.novik.jd01_07;

class Matrix extends Var {
    private double[][]value;

    Matrix(double[][] value){
        this.value=value;
    }

    Matrix(Matrix matrix) { this.value=matrix.value;}


    @Override
    public String toString() {
        StringBuilder st = new StringBuilder("{");
        String delimiter = "";
        for (double[] element : value) {
            st.append(delimiter).append("{");
            delimiter = "";
            for (int j = 0; j < element.length; j++) {
                st.append(delimiter).append(element[j]);
                delimiter = ", ";
            }st.append("}");
        }st.append("}");
        return st.toString();
    }
}
