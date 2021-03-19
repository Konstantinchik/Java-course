package by.it.plehanova.jd02_04;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class VectorTest {

    private Parser parser;

    @Before
    public void setUp() throws Exception {
        parser = new Parser();
    }

    @Test
    public void variableTest() {
        String strVar = "{1,2,3,4,5}";
        Vector vector = new Vector(strVar);
        String actual = vector.toString();
        String expected = "{1.0, 2.0, 3.0, 4.0, 5.0}";
        assertEquals(expected, actual);
    }

    @Test
    public void addTest() throws CalcException {

        Vector vector = (Vector) parser.calc("{1,2,3}+{4,5,6}");
        double[] actual = vector.getArray();
        double[] expected = {5, 7, 9};
        assertArrayEquals(expected, actual, 1e-5);

        vector = (Vector) parser.calc("{6,5,7}+{3,4,2}");
        actual = vector.getArray();
        expected = new double[]{9, 9, 9};
        assertArrayEquals(expected, actual, 1e-5);

        vector = (Vector) parser.calc("{6,5,7}+7");
        actual = vector.getArray();
        expected = new double[]{13, 12, 14};
        assertArrayEquals(expected, actual, 1e-5);

    }

    @Test
    public void subTest() throws CalcException {
        Vector vector = (Vector) parser.calc("{7,8,9}-{3,2,6}");
        double[] actual = vector.getArray();
        double[] expected = {4, 6, 3};
        assertArrayEquals(expected, actual, 1e-5);

        vector = (Vector) parser.calc("{12,5}-{9,0}");
        actual = vector.getArray();
        expected = new double[]{3, 5};
        assertArrayEquals(expected, actual, 1e-5);

        vector = (Vector) parser.calc("{12,5}-7");
        actual = vector.getArray();
        expected = new double[]{5, -2};
        assertArrayEquals(expected, actual, 1e-5);
    }

    @Test
    public void mulTest() throws CalcException {
        Var scalar = parser.calc("{1,2,3}*{3,2,1}");
        double actualS = Double.parseDouble(scalar.toString());
        assertEquals(10, actualS, 1e-5);

        Vector vector = (Vector) parser.calc("{3,7,11}*3");
        double[] actualD = vector.getArray();
        double[] expected = {9, 21, 33};
        assertArrayEquals(expected, actualD, 1e-5);
    }

    @Test
    public void divTest() throws CalcException {
        Vector vector = (Vector) parser.calc("{1,2,3}/2");
        double[] actual = vector.getArray();
        double[] expected = {0.5, 1, 1.5};
        assertArrayEquals(expected, actual, 1e-5);

        vector = (Vector) parser.calc("{6,9,12}/3");
        actual = vector.getArray();
        expected = new double[]{2, 3, 4};
        assertArrayEquals(expected, actual, 1e-5);
    }

    @After
    public void tearDown() throws Exception {
    }
}