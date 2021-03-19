package by.it.terentyev.jd01_09;

abstract class Var implements Operation {

//    public static Var createVar(String strVar) {
//        if (strVar.matches(Patterns.SCALAR)){
//            return new Scalar(strVar);
//        }
//        else if ();
//    }

    @Override
     public Var add(Var other) {
         System.out.printf("Operation %s + %s not found\n",this, other);
         return null;
     }

     @Override
     public Var sub(Var other) {
         System.out.printf("Operation %s - %s not found\n",this, other);
         return null;
     }

     @Override
     public Var mul(Var other) {
         System.out.printf("Operation %s * %s not found\n",this, other);
         return null;
     }

     @Override
     public Var div(Var other) {
         System.out.printf("Operation %s / %s not found\n",this, other);
         return null;
     }

     @Override
    public String toString() {
        return "some abstract Var{}";
    }
}
