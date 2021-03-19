package by.it.staniko.jd01_07;

class Scalar extends Var {

    private double value;

    public Scalar(double value) {
        this.value = value;
    }

    public Scalar(String strvalue) {
        this.value = Double.parseDouble(strvalue);
    }

    public Scalar(Scalar otherScalar) {

        this.value = otherScalar.value;
    }


    @Override
    public String toString() {
        return Double.toString(value);

    }
}
