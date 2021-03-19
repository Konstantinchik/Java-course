package by.it.plehanova.jd02_04;

class Scalar extends Var {

    private double value;

    public double getValue() {
        return value;
    }

    Scalar(double value) {
        this.value = value;
    }

    Scalar(String str) {
        this.value = Double.parseDouble(str);
    }

    Scalar(Scalar scalar) {
        this.value = scalar.value;
    }


    @Override
    public Var add(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double otherValue = ((Scalar) other).value;
            double result = this.value + otherValue;
            return new Scalar(result);
        } else {
            return other.add(this);
        }
    }

    @Override
    public Var sub(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double otherValue = ((Scalar) other).value;
            double result = this.value - otherValue;
            return new Scalar(result);
        } else {
            return new Scalar(-1).mul(other).add(this);
        }
    }

    @Override
    public Var mul(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double otherValue = ((Scalar) other).value;
            double result = this.value * otherValue;
            return new Scalar(result);
        } else {
            return other.mul(this);
        }
    }

    @Override
    public Var div(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double otherValue = ((Scalar) other).value;

            if (otherValue == 0) {
                throw new CalcException("Division by zero");
            }
            double result = this.value / otherValue;
            return new Scalar(result);
        } else {
            return super.div(other);
        }
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }
}
