package by.it.zavoiskikh.jd01_08;

class Vector extends Var {
    private double [] value;

    public Vector(double[] value) {
        this.value = value;
    }

    public Vector(Vector vector) {
        this.value = vector.value;
    }

    Vector (String  strVector) {

    }

    @Override
    public String toString() {

        StringBuilder sb=new StringBuilder ("{");
        String delimiter = "";
        for (double element:value) {
            sb.append(delimiter).append(element);
            delimiter =", ";
        }
       sb.append ("}");
        return sb.toString();
    }
}
