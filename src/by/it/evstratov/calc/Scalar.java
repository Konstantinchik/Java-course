package by.it.evstratov.calc;


import by.it.evstratov.calc.language.ErrorLang;

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

    @Override
    public Var add(Scalar scalar) {
        double result = scalar.value + this.value;
        return new Scalar(result);
    }

    @Override
    public Var add(Vector vector) {
        return vector.add(this);
    }

    @Override
    public Var add(Matrix matrix) {
        return matrix.add(this);
    }

    @Override
    public Var div(Scalar scalar) throws CalcException{
        double otherValue = scalar.value;
        if (otherValue==0){
            throw new CalcException(ConsoleRunner.lang.get(ErrorLang.DIV_BY_ZERO));
        }
        double result = this.value / otherValue;
        return new Scalar(result);
    }

    @Override
    public Var div(Vector vector) throws CalcException {
        return super.div(vector);
    }

    @Override
    public Var div(Matrix matrix) throws CalcException {
        return super.div(matrix);
    }

    @Override
    public Var mul(Scalar scalar) {
        double result = scalar.value * this.value;
        return new Scalar(result);
    }

    @Override
    public Var mul(Vector vector) {
        return vector.mul(this);
    }

    @Override
    public Var mul(Matrix matrix) {
        return matrix.mul(this);
    }

    @Override
    public Var sub(Scalar scalar) {
        double result = this.value - scalar.value;
        return new Scalar(result);
    }

    @Override
    public Var sub(Vector vector) throws CalcException {
        return vector.sub(this).mul(new Scalar(-1));
    }

    @Override
    public Var sub(Matrix matrix) throws CalcException {
        return matrix.sub(this).mul(new Scalar(-1));
    }

    public Var addWidth(Var var) throws CalcException {
        return var.add(this);
    }

    public Var mulWidth(Var var) throws CalcException {
        return var.mul(this);
    }

    public Var divWidth(Var var) throws CalcException {
        return var.div(this);
    }

    public Var subWidth(Var var) throws CalcException {
        return var.sub(this);
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }

    public double getValue() {
        return value;
    }
 }
