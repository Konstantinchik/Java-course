package by.it.evstratov.calc;

public interface OperationAdd {

    Var add(Scalar scalar) throws CalcException;
    Var add(Vector vector) throws CalcException;
    Var add(Matrix matrix) throws CalcException;

}
