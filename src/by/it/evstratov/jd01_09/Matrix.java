package by.it.evstratov.jd01_09;

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
       String str = strMatrix.replaceAll("},","} -");
       String[] arrayMatrixToString = str.split("-");
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
    public Var add(Var other) {
        if(other instanceof Scalar){
            double[][] res = new double[this.value.length][];
            for (int i = 0; i < res.length; i++) {
                res[i] = new double[this.value[0].length];
            }
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < this.value[i].length; j++) {
                    res[i][j] = this.value[i][j] + ((Scalar) other).getValue();
                }
            }
            return new Matrix(res);
        }else if(other instanceof Matrix){
            if(this.value.length == ((Matrix) other).value.length && this.value[0].length == ((Matrix) other).value[0].length){
                double[][] res = new double[this.value.length][];
                for (int i = 0; i < res.length; i++) {
                    res[i] = new double[this.value[0].length];
                }
                for (int i = 0; i < res.length; i++) {
                    for (int j = 0; j < this.value[i].length; j++) {
                        res[i][j] = this.value[i][j] + ((Matrix) other).value[i][j];
                    }
                }
                return new Matrix(res);
            }else{
                System.out.println("Матрицы разных размеров");
                return null;
            }
        }else{
            return super.add(other);
        }
    }

    @Override
    public Var sub(Var other) {
        if(other instanceof Scalar){
            return this.add(new Scalar(-1).mul(other));
        }else if(other instanceof Matrix){
            if(this.value.length == ((Matrix) other).value.length && this.value[0].length == ((Matrix) other).value[0].length){
                return this.add(new Matrix((Matrix) other.mul(new Scalar(-1))));
            }else{
                System.out.println("Матрицы разных размеров");
                return null;
            }
        }else{
            return super.sub(other);
        }
    }

    @Override
    public Var mul(Var other) {
        if(other instanceof Scalar){
            double[][] res = new double[this.value.length][this.value[0].length];

            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < this.value[i].length; j++) {
                    res[i][j] = this.value[i][j] * ((Scalar) other).getValue();
                }
            }
            return new Matrix(res);
        }else if(other instanceof Vector){
            if(this.value[0].length == ((Vector) other).getValue().length){
                double[] result = new double[this.value.length];
                for (int i = 0; i < this.value.length; i++) {
                    for (int j = 0; j < ((Vector) other).getValue().length; j++) {
                        result[i] = result[i] + this.value[i][j] * ((Vector) other).getValue()[j];
                    }
                }
                return new Vector(result);
            }else{
                System.out.println("Матрица и вектор разных размеров");
                return null;
            }
        }else {
            if(this.value[0].length == ((Matrix) other).value.length){
                double[][] res = new double[this.value.length][((Matrix) other).value[0].length];
                for (int i = 0; i < this.value.length; i++) {
                    for (int j = 0; j < ((Matrix) other).value[0].length; j++) {
                        for (int k = 0; k < ((Matrix) other).value.length; k++) {
                            res[i][j] = res[i][j] + this.value[i][k] * ((Matrix) other).value[k][j];
                        }
                    }
                }
                return new Matrix(res);
            }else{
                System.out.println("Матрицы разных размеров");
                return null;
            }
        }
    }

    @Override
    public Var div(Var other) {
        return super.div(other);
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
