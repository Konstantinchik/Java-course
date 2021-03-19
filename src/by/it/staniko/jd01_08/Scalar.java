package by.it.staniko.jd01_08;

class Scalar extends by.it.staniko.jd01_08.Var {

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

    public double getValue() {
        return value;
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            double otherValue = ((Scalar) other).value;
            double result = this.value + otherValue;
            return new Scalar(result);
        } else
            return other.add(this);
        //System.out.println("add");
        //return null;
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            double otherValue = ((Scalar) other).value;
            double result = this.value - otherValue;
            return new Scalar(result);
        } else
            return other.sub(this).mul(new Scalar(-1));

    }

    public Var mul(Var other) {
        if (other instanceof Scalar) {
            double otherValue = ((Scalar) other).value;
            double result = this.value * otherValue;
            return new Scalar(result);
        } else
            return other.mul(this);
    }

    public Var div(Var other) {
        if (other instanceof Scalar) {
            double otherValue = ((Scalar) other).value;
            if (otherValue == 0) {
                System.out.println("Division by zero");
                return null;
            }
                double result = this.value / otherValue;
                return new Scalar(result);
            } else
                return super.div(other);
        }



    @Override
    public String toString() {
        return Double.toString(value);

    }
}
