package by.it.soldatenko.jd01_07;




class Vector extends Var {
    private double[] value;
    Vector(double[] value){
        this.value = value;
    }
    Vector(Vector vector){
        this.value = vector.value;
    }
    Vector(String strVector){
        String a = strVector.replaceAll("[\\{\\}\\ ]", "");
        String[] str = a.split(",");
        double[] d = new double[str.length];
        for (int i = 0; i < str.length; i++) {
            d[i] = Double.parseDouble(str[i]);
    }
        this.value =d;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        String delimiter = "";
        for (double element : value) {
            sb.append(delimiter).append(element);
            delimiter = ", ";
        }
        sb.append("}");
        return sb.toString();
    }
}
