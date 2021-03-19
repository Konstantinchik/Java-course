package by.it.kglushchenko.jd01_08;

class Scalar extends Var {
    private double value;

    /* Constructors */
    Scalar(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    Scalar(String strValue) {
        this.value = Double.parseDouble(strValue);
    }

    Scalar(Scalar otherScalar) {
        this.value = otherScalar.value;
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            // Result: Scalar + Scalar
            double sum = this.value + ((Scalar) other).value;

            // Возвращаемый тип должен быть Var или его потмком
            return new Scalar(sum);
        } else
            // если other vector -> vector.add
            // если other matrix -> matrix.add
            return other.add(this);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            // Result: Scalar - Scalar
            double subs = this.value - ((Scalar) other).value;

            // Возвращаемый тип должен быть Var или его потмком
            return new Scalar(subs);
        } else
            // если other vector -> vector.add
            // если other matrix -> matrix.add
            return new Scalar(-1).mul(other).add(this); //  (-1) * Vector + Scalar

    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            // Result: Scalar * Scalar
            double mulres = this.value * ((Scalar) other).value;

            // Возвращаемый тип должен быть Var или его потмком
            return new Scalar(mulres);
        } else
            // если other vector -> vector.mul
            // если other matrix -> matrix.mul
            return other.mul(this);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar) {
            // Result: Scalar / Scalar
            double div = this.value / ((Scalar) other).value;

            // Возвращаемый тип должен быть Var или его потмком
            return new Scalar(div);
        } else
            // если other vector -> vector.div
            // если other matrix -> matrix.div
            return other.div(this);
    }

    //
    @Override
    public String toString() {
        return Double.toString(value);
    }

}
