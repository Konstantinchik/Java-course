package by.it.plehanova.jd01_07;

public class Runner {
    public static void main(String[] args) {

        Var scalar1 = new Scalar(3.14);
        Var scalar2 = new Scalar("9.5");
        Var scalar3 = new Scalar(new Scalar(3.75));

        Var vector1 = new Vector(new double[]{6, 2.5, 9, 4.2});
        Var vector2 = new Vector("{3.14, 2.9, 7, 4.751}");
        Var vector3 = new Vector((Vector) vector1);

        Var matrix1 = new Matrix(new double[][]{{9, 8, 7}, {4, 5, 6}});
        Var matrix2 = new Matrix("{{6, 5, 4, 3},{3,2,9,8}}");
        Var matrix3 = new Matrix((Matrix) matrix1);


        System.out.println(scalar1);
        System.out.println(scalar2);
        System.out.println(scalar3);
        System.out.println();
        System.out.println(vector1);
        System.out.println(vector2);
        System.out.println(vector3);
        System.out.println();
        System.out.println(matrix1);
        System.out.println(matrix2);
        System.out.println(matrix3);


    }
}
