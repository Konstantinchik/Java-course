package by.it.kglushchenko.jd02_04;

class Scalar extends Var {

    private final double value;

    public Scalar(double value) {
        this.value = value;
    }

    public Scalar(String strValue) {
        this.value = Double.parseDouble(strValue);
    }

    public Scalar(Scalar otherScalar) {
        this.value = otherScalar.value;
    }

    public double getValue() {
        return value;
    }

    @Override
    public Var add(Var other) throws CalcException {
        if(other instanceof Scalar){
            double otherValue = ((Scalar)other).value;
            double result = this.value + otherValue;
            return new Scalar(result);
        } else
            return other.add(this);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        if(other instanceof Scalar){
            double otherValue = ((Scalar)other).value;
            double result = this.value - otherValue;
            return new Scalar(result);
        } else
            return other.sub(this).mul(new Scalar(-1));
    }

    @Override
    public Var mul(Var other) throws CalcException {
        if(other instanceof Scalar){
            double otherValue = ((Scalar)other).value;
            double result = this.value * otherValue;
            return new Scalar(result);
        } else
            return other.mul(this);
    }

    @Override
    public Var div(Var other) throws CalcException {
        if(other instanceof Scalar){
            double otherValue = ((Scalar)other).value;
            if(otherValue==0){
                throw new CalcException("Division by zero");
            }
            double result = this.value / otherValue;
            return new Scalar(result);
        } else {
            return super.div(other);
        }
    }

    /**
     * Returns a string representation of the object. In general, the
     * {@code toString} method returns a string that
     * "textually represents" this object. The result should
     * be a concise but informative representation that is easy for a
     * person to read.
     * It is recommended that all subclasses override this method.
     * <p>
     * The {@code toString} method for class {@code Object}
     * returns a string consisting of the name of the class of which the
     * object is an instance, the at-sign character `{@code @}', and
     * the unsigned hexadecimal representation of the hash code of the
     * object. In other words, this method returns a string equal to the
     * value of:
     * <blockquote>
     * <pre>
     * getClass().getName() + '@' + Integer.toHexString(hashCode())
     * </pre></blockquote>
     *
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return Double.toString(value);
    }
}
