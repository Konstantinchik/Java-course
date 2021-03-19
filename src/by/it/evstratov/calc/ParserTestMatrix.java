package by.it.evstratov.calc;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ParserTestMatrix {

    private Parser parser;

    @Before
    public void setUp() throws Exception {
        parser = new Parser();
    }

    @Test
    public void addTest() throws CalcException {
        Matrix matrix = (Matrix)parser.calc("{{1,2,3},{4,5,6}}+2");
        double[][] actual = matrix.getValue();
        double[][] expected = {{3,4,5},{6,7,8}};
        for (int i = 0; i < expected.length; i++) {
            assertArrayEquals(expected[i], actual[i], 1e-5);
        }
        matrix = (Matrix)parser.calc("{{1,2,3},{4,5,6}}+{{1,2,3},{4,5,6}}");
        actual = matrix.getValue();
        expected = new double[][]{{2, 4, 6},{8, 10, 12}};
        for (int i = 0; i < expected.length; i++) {
            assertArrayEquals(expected[i], actual[i], 1e-5);
        }
    }

    @Test
    public void subTest() throws CalcException {
        Matrix matrix = (Matrix)parser.calc("{{1,2,3},{4,5,6}}-3");
        double[][] actual = matrix.getValue();
        double[][] expected = {{-2,-1,0},{1,2,3}};
        for (int i = 0; i < expected.length; i++) {
            assertArrayEquals(expected[i], actual[i], 1e-5);
        }
        matrix = (Matrix)parser.calc("{{8,6,5},{2,6,1}}-{{2,2,2},{1,1,1}}");
        actual = matrix.getValue();
        expected = new double[][]{{6, 4, 3},{1, 5, 0}};
        for (int i = 0; i < expected.length; i++) {
            assertArrayEquals(expected[i], actual[i], 1e-5);
        }
    }

    @Test
    public void mulTest() throws CalcException {
        Matrix matrix = (Matrix)parser.calc("{{1,2,3},{4,5,6}}*3");
        double[][] actual = matrix.getValue();
        double[][] expected = {{3,6,9},{12,15,18}};
        for (int i = 0; i < expected.length; i++) {
            assertArrayEquals(expected[i], actual[i], 1e-5);
        }
        matrix = (Matrix)parser.calc("{{1,2,3},{4,5,6}}*{{1,2,3},{4,5,6},{4,5,6}}");
        actual = matrix.getValue();
        expected = new double[][]{{21.0, 27.0, 33.0}, {48.0, 63.0, 78.0}};
        for (int i = 0; i < expected.length; i++) {
            assertArrayEquals(expected[i], actual[i], 1e-5);
        }
        Vector vector = (Vector)parser.calc("{{1,2,3},{4,5,6}}*{1,2,3}");
        double[] actual1 = vector.getValue();
        double[] expected1 = new double[]{14.0, 32.0};
        assertArrayEquals(expected1, actual1, 1e-5);
    }

    @Test
    public void expression() throws CalcException {
        Matrix matrix = (Matrix)parser.calc("{{1,2,3},{4,5,6}}*2");
        double[][] actual = matrix.getValue();
        double[][] expected = {{2,4,6},{8,10,12}};
        for (int i = 0; i < expected.length; i++) {
            assertArrayEquals(expected[i], actual[i], 1e-5);
        }
        matrix = (Matrix)parser.calc("{{1,2,3},{4,5,6}}*2+4");
        actual = matrix.getValue();
        expected = new double[][]{{6, 8, 10}, {12, 14, 16}};
        for (int i = 0; i < expected.length; i++) {
            assertArrayEquals(expected[i], actual[i], 1e-5);
        }
        matrix = (Matrix)parser.calc("M={{1,2,3},{4,5,6}}+4*2");
        actual = matrix.getValue();
        expected = new double[][]{{9,10,11},{12,13,14}};
        for (int i = 0; i < expected.length; i++) {
            assertArrayEquals(expected[i], actual[i], 1e-5);
        }
        matrix = (Matrix)parser.calc("M={{1,2,3},{4,5,6}}+4*2+{{0,2,0},{2,1,3}}");
        actual = matrix.getValue();
        expected = new double[][]{{9,12,11},{14,14,17}};
        for (int i = 0; i < expected.length; i++) {
            assertArrayEquals(expected[i], actual[i], 1e-5);
        }
    }

    @After
    public void tearDown() throws Exception {
    }
}