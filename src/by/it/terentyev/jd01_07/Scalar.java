package by.it.terentyev.jd01_07;

 class Scalar extends Var {  

     double value;

    public Scalar(double value) {
        this.value = value;
    }

    public Scalar(String str) {
        this.value = Double.parseDouble(str);
    }

    public Scalar(Scalar otherScalar) {
        this.value = otherScalar.value;
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }
}
