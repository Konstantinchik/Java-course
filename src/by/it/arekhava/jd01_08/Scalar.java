package by.it.arekhava.jd01_08;

class Scalar extends Var {
    private double value;

    public Scalar(double value) {
        this.value = value;
    }
    Scalar(String str) {
        this.value = Double.parseDouble(str);
    }
    Scalar (Scalar scalar){
        this.value=scalar.value;
    }

    public double getValue() {
        return value;
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            double othervalue = ((Scalar) other).value;
            double result = this.value + othervalue;
            return new Scalar(result);
        }
        else
            return other.add(this);
    }
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            double othervalue = ((Scalar) other).value;
            double result = this.value - othervalue;
            return new Scalar(result);
        }
        else
            return other.sub(this).mul(new Scalar(-1));
    }
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            double othervalue = ((Scalar) other).value;
            double result = this.value*othervalue;
            return new Scalar(result);
        }
        else
            return other.mul(this);
    }
    public Var div(Var other) {
        if (other instanceof Scalar) {
            double othervalue = ((Scalar) other).value;
            if (othervalue ==0){
                System.out.println("Divizion by zero");
                return null;//stub
            }
            double result = this.value/othervalue;
            return new Scalar(result);
        }
        else
            return super.div(other);
    }
    public String toString() {
        return Double.toString(value);
    }
}
