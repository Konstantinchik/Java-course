package by.it._khmelov_.calc;

class Scalar extends Var {

    private double value;

    public Scalar(double value) {
        this.value = value;
    }

    public Scalar(String strValue) {
        this.value = Double.parseDouble(strValue);
    }

    public Scalar(Scalar otherScalar) {
        this.value = otherScalar.value; //
    }

    public double getValue() {
        return value;
    }

    @Override
    public Var add(Var other) throws CalcException{
        if (other instanceof Scalar) {
            double otherValue = ((Scalar) other).value;
            double result = this.value + otherValue;
            return new Scalar(result);
        }
        else
            return other.add(this);
    }

    @Override
    public Var sub(Var other)  throws CalcException{
        if (other instanceof Scalar) {
            double otherValue = ((Scalar) other).value;
            double result = this.value - otherValue;
            return new Scalar(result);
        }
        else
            return other.sub(this).mul(new Scalar(-1));
    }

    @Override
    public Var mul(Var other)  throws CalcException{
        if (other instanceof Scalar) {
            double otherValue = ((Scalar) other).value;
            double result = this.value * otherValue;
            return new Scalar(result);
        }
        else
            return other.mul(this);
    }

    @Override
    public Var div(Var other) throws CalcException{
        if (other instanceof Scalar) {
            double otherValue = ((Scalar) other).value;
            if (otherValue==0){
                throw new CalcException("Division by zero");
            }
            double result = this.value / otherValue;
            return new Scalar(result);
        }
        else
            return super.div(other);
    }





    @Override
    public String toString() {
        return Double.toString(value);
    }
}
