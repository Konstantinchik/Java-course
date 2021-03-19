package by.it.tetenkov.jd01_09;

abstract class Var implements Operation {

    public static Var createVar(String strVar) {
        if (strVar.matches(Patterns.SCALAR)) {
            return new Scalar(strVar);
        } else if (strVar.matches(Patterns.VECTOR)) {
            return new Vector(strVar);
        } else if (strVar.matches(Patterns.MATRIX)) {
            return new Matrix(strVar);
        }
        else {
            return null; // TODO return exception
        }
    }

    @Override
    public Var add(Var other) {
        System.out.printf("Operation %s + %s not found\n", this, other);
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.printf("Operation %s - %s not found\n", this, other);
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.printf("Operation %s * %s not found\n", this, other);
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.printf("Operation %s / %s not found\n", this, other);
        return null;
    }

    @Override
    public String toString() {
        return "Var{}";
    }
}
