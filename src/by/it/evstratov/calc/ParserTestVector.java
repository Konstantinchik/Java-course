package by.it.evstratov.calc;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ParserTestVector {

    private Parser parser;

    @Before
    public void setUp() throws Exception {
        parser = new Parser();
    }

    @Test
    public void addTest() throws CalcException {
        Vector vector = (Vector)parser.calc("{1,2,3}+{4,5,6}");
        double[] actual = vector.getValue();
        double[] expected = {5,7,9};
        assertArrayEquals(expected, actual, 1e-5);
        vector = (Vector)parser.calc("{8,8}+{2,2}");
        expected = new double[]{10,10};
        actual = vector.getValue();
        assertArrayEquals(expected, actual, 1e-5);
    }

    @Test
    public void divTest() throws CalcException {
        Vector vector = (Vector)parser.calc("{2,2,6}/2");
        double[] actual = vector.getValue();
        double[] expected = {1,1,3};
        assertArrayEquals(expected, actual, 1e-5);
        vector = (Vector)parser.calc("{6,6,9}/3");
        expected = new double[]{2,2,3};
        actual = vector.getValue();
        assertArrayEquals(expected, actual, 1e-5);
    }

    @Test
    public void subTest() throws CalcException {
        Vector vector = (Vector)parser.calc("{2,6}-{0,2}");
        double[] actual = vector.getValue();
        double[] expected = {2,4};
        assertArrayEquals(expected, actual, 1e-5);
        vector = (Vector)parser.calc("{9,7}-{3,7}");
        expected = new double[]{6,0};
        actual = vector.getValue();
        assertArrayEquals(expected, actual, 1e-5);
        vector = (Vector)parser.calc("{9,7}-2");
        expected = new double[]{7,5};
        actual = vector.getValue();
        assertArrayEquals(expected, actual, 1e-5);
    }

    @Test
    public void mulTest() throws CalcException {
        Scalar scalar = (Scalar)parser.calc("{2,6}*{0,2}");
        double actual = scalar.getValue();
        assertEquals (12, actual, 1e-5);
        Vector vector = (Vector)parser.calc("{2,6}*5");
        double[] expected = {10,30};
        double[] actual2 = vector.getValue();
        assertArrayEquals (expected, actual2, 1e-5);
    }

    @Test
    public void expression() throws CalcException {
        Vector vector = (Vector)parser.calc("{1,2,3}*2+{4,5,6}");
        double[] actual = vector.getValue();
        double[] expected = {6,9,12};
        assertArrayEquals(expected, actual, 1e-5);
        vector = (Vector)parser.calc("{2,3}*(6/2)");
        expected = new double[]{6,9};
        actual = vector.getValue();
        assertArrayEquals(expected, actual, 1e-5);
    }

    @After
    public void tearDown() throws Exception {
    }
}