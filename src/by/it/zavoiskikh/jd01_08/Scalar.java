package by.it.zavoiskikh.jd01_08;

class Scalar extends Var {
  private double value;

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
    public Var add(Var other) {
        if (other instanceof Scalar) {
            double otherValue = ((Scalar) other).value;
            double result = this.value + otherValue;
            return new Scalar(result);
        } else
            return other.add(this);
     }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            double otherValue = ((Scalar) other).value;
            double result = this.value - otherValue;
            return new Scalar(result);
        } else
            return other.sub(this).mul (new Scalar(-1));
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            double otherValue = ((Scalar) other).value;
            double result = this.value * otherValue;
            return new Scalar(result);
        } else
            return other.mul (this);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar) {
            double otherValue = ((Scalar) other).value;
            if (otherValue == 0) {
System.out.println("Division by zero");
return null; //stub exception
            }
            double result = this.value * otherValue;
            return new Scalar(result);
        } else
            return super.div (other);
    }




    @Override
    public String toString() {
        return Double.toString(value);
    }
}
