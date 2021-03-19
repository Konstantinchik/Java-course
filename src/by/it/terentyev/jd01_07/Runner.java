package by.it.terentyev.jd01_07;

class Runner {

    public static void main(String[] args) {
        Var scalar1 = new Scalar(3.145);
        Var scalar2 = new Scalar("4.145");
        Var scalar3 = new Scalar((Scalar)scalar1);
        double[] vecValue = {1, 2, 3, 4, 5};
        Var vector1 = new Vector(vecValue);
        Var vector2 = new Vector((Vector)vector1);
        Var vector3 = new Vector("{1.0,2.0,5.0,6}");




        System.out.println(scalar1);
        System.out.println(scalar2);
        System.out.println(scalar3);
        System.out.println(vector1);
        System.out.println(vector2);
        System.out.println(vector3);
    }
}
