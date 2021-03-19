package by.it.leshchenko.jd01_07;

public class Runner {
    public static void main(String[] args) {
        Var scalar1 = new Scalar(12);
        Var scalar2 = new Scalar((Scalar) scalar1);
        Var scalar3 = new Scalar("12");
        System.out.println(scalar1);
        System.out.println(scalar2);
        System.out.println(scalar3);

        Var vector1 = new Vector(new double[]{1.0, 2.0, 4.0});
        Var vector2 = new Vector((Vector) vector1);
        Var vector3 = new Vector("{1.0, 2.0, 4.0}");
        System.out.println(vector1);
        System.out.println(vector2);
        System.out.println(vector3);

        Var matrix1 = new Matrix(new double[][]{{1.0, 2.0}, {3.0, 4.0}});
        Var matrix2 = new Matrix((Matrix) matrix1);
        Var matrix3 = new Matrix("{{1.0, 2.0}, {3.0, 4.0}}");
        System.out.println(matrix1);
        System.out.println(matrix2);
        System.out.println(matrix3);
    }
}
