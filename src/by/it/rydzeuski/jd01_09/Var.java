package by.it.rydzeuski.jd01_09;


abstract class Var implements Operation {

    public static Var createVar(String strVar) {
        if (strVar.matches(Patterns.SCALAR)){
            return new Scalar(strVar);
        }else if (strVar.matches(Patterns.VECTOR)){
            return new Vector(strVar);
        }else if (strVar.matches(Patterns.MATRIX)) {
            return new Matrix(strVar);
        }else{
            return null;//excepsion
        }



    }

    @Override
     public Var add(Var other) {
         System.out.println("Операция слоения"+this+"+"+other+"невозможна");
         return null;
     }

     @Override
     public Var sub(Var other) {
         System.out.println("Операция вычетания"+this+"-"+other+"невозможна");
         return null;
     }

     @Override
     public Var mul(Var other) {
         System.out.println("Операция умножения"+this+"*"+other+"невозможна");
         return null;
     }

     @Override
     public Var div(Var other) {
         System.out.println("Операция деления"+this+"/"+other+"невозможна");
         return null;
     }
 }
