package by.it.evstratov.calc;

public interface OperationSub {

    Var sub(Scalar scalar) throws CalcException;
    Var sub(Vector vector) throws CalcException;
    Var sub(Matrix matrix) throws CalcException;

}
