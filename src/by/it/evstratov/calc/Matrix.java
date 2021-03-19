package by.it.evstratov.calc;

import by.it.evstratov.calc.language.ErrorLang;

import java.util.StringJoiner;

class Matrix extends Var {

   private final double[][] value;

   public Matrix(double[][] value) {
       this.value = value;
   }

   public Matrix(Matrix otherMatrix) {
       this.value = otherMatrix.value;
   }

    public double[][] getValue() {
        return value;
    }

   public Matrix(String strMatrix) {
       String str = strMatrix.replaceAll("},","} and");
       String[] arrayMatrixToString = str.split("and");
       this.value = new double[arrayMatrixToString.length][];
       for (int i = 0; i < value.length; i++) {
           String line = arrayMatrixToString[i].replaceAll("[{}]","");
           String[] arrayStrings = line.split(",");
           value[i] = new double[arrayStrings.length];
           for (int j = 0; j < arrayStrings.length; j++) {
               value[i][j] = Double.parseDouble(arrayStrings[j].trim());
           }
       }
   }

    @Override
    public Var add(Scalar scalar) {
        double[][] res = new double[this.value.length][];
        for (int i = 0; i < res.length; i++) {
            res[i] = new double[this.value[0].length];
        }
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < this.value[i].length; j++) {
                res[i][j] = this.value[i][j] + scalar.getValue();
            }
        }
        return new Matrix(res);
    }

    @Override
    public Var add(Vector vector) throws CalcException {
        return super.add(vector);
    }

    @Override
    public Var add(Matrix matrix) throws CalcException {
        if(this.value.length == matrix.value.length && this.value[0].length == matrix.value[0].length){
            double[][] res = new double[this.value.length][];
            for (int i = 0; i < res.length; i++) {
                res[i] = new double[this.value[0].length];
            }
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < this.value[i].length; j++) {
                    res[i][j] = this.value[i][j] + matrix.value[i][j];
                }
            }
            return new Matrix(res);
        }else{
            throw new CalcException(this+ ConsoleRunner.lang.get(ErrorLang.AND) +matrix+" " + ConsoleRunner.lang.get(ErrorLang.SIZE));
        }
    }

    @Override
    public Var div(Scalar scalar) throws CalcException {
        return super.div(scalar);
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
        double[][] res = new double[this.value.length][this.value[0].length];

        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < this.value[i].length; j++) {
                res[i][j] = this.value[i][j] * scalar.getValue();
            }
        }
        return new Matrix(res);
    }

    @Override
    public Var mul(Vector vector) throws CalcException {
        if(this.value[0].length == vector.getValue().length){
            double[] result = new double[this.value.length];
            for (int i = 0; i < this.value.length; i++) {
                for (int j = 0; j < vector.getValue().length; j++) {
                    result[i] = result[i] + this.value[i][j] * vector.getValue()[j];
                }
            }
            return new Vector(result);
        }else{
            throw new CalcException(this + ConsoleRunner.lang.get(ErrorLang.AND)  + vector+" " + ConsoleRunner.lang.get(ErrorLang.SIZE));
        }
    }

    @Override
    public Var mul(Matrix matrix) throws CalcException {
        if(this.value[0].length == matrix.value.length){
            double[][] res = new double[this.value.length][matrix.value[0].length];
            for (int i = 0; i < this.value.length; i++) {
                for (int j = 0; j < matrix.value[0].length; j++) {
                    for (int k = 0; k < matrix.value.length; k++) {
                        res[i][j] = res[i][j] + this.value[i][k] * matrix.value[k][j];
                    }
                }
            }
            return new Matrix(res);
        }else{
            throw new CalcException(this+ ConsoleRunner.lang.get(ErrorLang.AND) +matrix+" " + ConsoleRunner.lang.get(ErrorLang.SIZE));
        }
    }

    @Override
    public Var sub(Scalar scalar) {
        return this.add((Scalar) new Scalar(-1).mul(scalar));
    }

    @Override
    public Var sub(Vector vector) throws CalcException {
        return super.sub(vector);
    }

    @Override
    public Var sub(Matrix matrix) throws CalcException {
        if(this.value.length == matrix.value.length && this.value[0].length == matrix.value[0].length){
            return this.add(new Matrix((Matrix) matrix.mul(new Scalar(-1))));
        }else{
            throw new CalcException(this+ ConsoleRunner.lang.get(ErrorLang.AND) +matrix+" " + ConsoleRunner.lang.get(ErrorLang.SIZE));
        }
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
       StringBuilder sb = new StringBuilder("{");
       for (int i = 0; i < value.length; i++) {
           StringJoiner stringJoiner = new StringJoiner(", ", "{", "}");
           for (int j = 0; j < value[i].length; j++) {
               stringJoiner.add(Double.toString(value[i][j]));
           }
           sb.append(stringJoiner);
           if(i+1 != value.length){
               sb.append(", ");
           }else{
               sb.append("}");
           }
       }
       return sb.toString();
   }
}
