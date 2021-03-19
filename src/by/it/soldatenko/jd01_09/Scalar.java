package by.it.soldatenko.jd01_09;

class Scalar extends Var {
    private double value;

    public double getValue() {
        return value;
    }

    Scalar(double value) {
        this.value = value;
    }
    Scalar(String strValue){
        this.value = Double.parseDouble(strValue);
    }
    Scalar(Scalar otherScalar){
        this.value = otherScalar.value;
    }



    @Override
    public Var add(Var other) {
        if(other instanceof Scalar){
            double otherValue = ((Scalar) other).value;
        double result = this.value + otherValue;
        return new Scalar(result);
        }
        else

        return other.add(this);
    }

    @Override
    public Var sub(Var other) {
        if(other instanceof Scalar){
            double otherValue = ((Scalar) other).value;
            double result = this.value - otherValue;
            return new Scalar(result);
        }
        else

            return new Scalar(-1).mul(other).add(this);
    }

    @Override
    public Var mul(Var other) {

        if(other instanceof Scalar){
            double otherValue = ((Scalar) other).value;
            double mul = this.value * otherValue;
            return new Scalar(mul);
        }
        else

            return other.mul(this);
    }

    @Override
    public Var div(Var other) {
        if(other instanceof Scalar){
            double otherValue = ((Scalar) other).value;
            double result = this.value/otherValue;
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
