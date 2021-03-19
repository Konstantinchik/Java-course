package by.it.evstratov.calc;

public interface OperationMul {

    Var mul(Scalar scalar) throws CalcException;
    Var mul(Vector vector) throws CalcException;
    Var mul(Matrix matrix) throws CalcException;

}
