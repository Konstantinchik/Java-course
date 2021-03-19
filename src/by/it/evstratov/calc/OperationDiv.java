package by.it.evstratov.calc;

public interface OperationDiv {

    Var div(Scalar scalar) throws CalcException;
    Var div(Vector vector) throws CalcException;
    Var div(Matrix matrix) throws CalcException;

}
