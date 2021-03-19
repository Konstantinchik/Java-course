package by.it.plehanova.jd02_04;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class MatrixTest {
    private Parser parser;

    @Before
    public void setUp() throws Exception {
        parser = new Parser();
    }

    @Test
    public void VariableTest() {
        String strVar = "{{1,2,3},{4,5,6}}";
        Matrix matrix = new Matrix(strVar);
        String actual = matrix.toString();
        String expected = "{{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}}";
        assertEquals(expected, actual);
    }

    @Test
    public void addTest() throws CalcException {
        Matrix matrix = (Matrix) parser.calc("{{1,2,3},{1,2,3}}+{{3,2,1},{4,5,6}}");
        double[][] actual = matrix.getMatrix();
        double[][] expected = {{4, 4, 4}, {5, 7, 9}};
        for (int i = 0; i < expected.length; i++) {
            assertArrayEquals(expected[i], actual[i], 1e-5);
        }
        matrix = (Matrix) parser.calc("{{2,0,7},{3,6,9}}+{{7,5,4},{11,2,3}}");
        actual = matrix.getMatrix();
        expected = new double[][]{{9, 5, 11}, {14, 8, 12}};
        for (int i = 0; i < expected.length; i++) {
            assertArrayEquals(expected[i], actual[i], 1e-5);
        }
        matrix = (Matrix) parser.calc("{{2,0,7},{3,6,9}}+9");
        actual = matrix.getMatrix();
        expected = new double[][]{{11, 9, 16}, {12, 15, 18}};
        for (int i = 0; i < expected.length; i++) {
            assertArrayEquals(expected[i], actual[i], 1e-5);

        }


    }

    @Test
    public void subTest() throws CalcException {
        Matrix matrix = (Matrix) parser.calc("{{15,12,9},{3,17,22}}-{{7,2,9},{2,7,20}}");
        double[][] actual = matrix.getMatrix();
        double[][] expected = {{8, 10, 0}, {1, 10, 2}};
        for (int i = 0; i < expected.length; i++) {
            assertArrayEquals(expected[i], actual[i], 1e-5);

        }

        matrix = (Matrix) parser.calc("{{2,5},{11,7}}-{{1,4},{10,2}}");
        actual = matrix.getMatrix();
        expected = new double[][]{{1, 1}, {1, 5}};
        for (int i = 0; i < expected.length; i++) {
            assertArrayEquals(expected[i], actual[i], 1e-5);

        }
        matrix = (Matrix) parser.calc("{{9,14,12},{11,21,7}}-7");
        actual = matrix.getMatrix();
        expected = new double[][]{{2, 7, 5}, {4, 14, 0}};
        for (int i = 0; i < expected.length; i++) {
            assertArrayEquals(expected[i], actual[i], 1e-5);

        }
    }

    @Test
    public void mulTest() throws CalcException {
        Matrix matrix = (Matrix) parser.calc("{{1,2,3},{4,5,6}}*{{2,4,6},{3,1,0},{5,2,9}}");
        double[][] actual = matrix.getMatrix();
        double[][] expected = {{23, 12, 33}, {53, 33, 78}};
        for (int i = 0; i < expected.length; i++) {
            assertArrayEquals(expected[i], actual[i], 1e-5);

        }

        Vector vector = (Vector) parser.calc("{{5,2,0},{6,3,1}}*{2,3,4}");
        double[] actualV = vector.getArray();
        double[] expectedV = {16, 25};
        assertArrayEquals(expectedV, actualV, 1e-5);


        matrix = (Matrix) parser.calc("{{3,2,7},{4,5,6}}*2");
        actual = matrix.getMatrix();
        expected = new double[][]{{6, 4, 14}, {8, 10, 12}};
        for (int i = 0; i < expected.length; i++) {
            assertArrayEquals(expected[i], actual[i], 1e-5);

        }
    }

    @Test
    public void divTest() throws CalcException {
        Matrix matrix = (Matrix) parser.calc("{{8,4},{12,9}}/2");
        double[][] actual = matrix.getMatrix();
        double[][] expected = {{4, 2}, {6, 4.5}};
        for (int i = 0; i < expected.length; i++) {
            assertArrayEquals(expected[i], actual[i], 1e-5);

        }

        matrix = (Matrix) parser.calc("{{5,25,15},{30,10,11}}/5");
        actual = matrix.getMatrix();
        expected = new double[][]{{1, 5, 3}, {6, 2, 2.2}};
        for (int i = 0; i < expected.length; i++) {
            assertArrayEquals(expected[i], actual[i], 1e-5);
        }

    }

    @After
    public void tearDown() throws Exception {
    }
}