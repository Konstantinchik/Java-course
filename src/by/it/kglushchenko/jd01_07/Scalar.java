package by.it.kglushchenko.jd01_07;

public class Scalar extends Var{
    private double value;

    /* Constructors */
    public Scalar(double value){
        this.value=value;
    }

    public Scalar(String strValue){
        this.value = Double.parseDouble(strValue);
    }

    public Scalar(Scalar otherScalar) {
        this.value= otherScalar.value;
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

}
