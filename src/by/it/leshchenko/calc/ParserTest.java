package by.it.leshchenko.calc;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class ParserTest {

    private Parser parser;

    @Before
    public void setUp() {
        parser = new Parser();
    }

//    @After
//    public void tearDown() throws Exception {
//    }

    @Test
    public void addScalar() throws CalcException {
        final Scalar scalar = (Scalar) parser.calc("2+3+4+5");
        final double actual = scalar.getValue();
        final double expected = 14.0;
        assertEquals(expected, actual, 1e-5);
    }

    @Test
    public void subScalar() throws CalcException {
        final Scalar scalar = (Scalar) parser.calc("2-3-4-5");
        final double actual = scalar.getValue();
        final double expected = -10.0;
        assertEquals(expected, actual, 1e-5);
    }

    @Test
    public void mulScalar() throws CalcException {
        final Scalar scalar = (Scalar) parser.calc("2*3*-4*5");
        final double actual = scalar.getValue();
        final double expected = -120.0;
        assertEquals(expected, actual, 1e-5);
    }

    @Test
    public void divScalar() throws CalcException {
        final Scalar scalar = (Scalar) parser.calc("50/4/-4/2");
        final double actual = scalar.getValue();
        final double expected = -1.5625;
        assertEquals(expected, actual, 1e-5);
    }

    @Test
    public void addVector() throws CalcException {
        final Vector vector = (Vector) parser.calc("{-4,-3,-2}+{5,6,7}");
        final double[] actual = vector.getValue();
        final double[] expected = {1.0, 3.0, 5.0};
        assertArrayEquals(expected, actual, 1e-5);
    }

    @Test
    public void subVector() throws CalcException {
        final Vector vector = (Vector) parser.calc("{-2,3,-4}-{5,-6,7}");
        final double[] actual = vector.getValue();
        final double[] expected = {-7.0, 9.0, -11.0};
        assertArrayEquals(expected, actual, 1e-5);
    }

    @Test
    public void mulVector() throws CalcException {
        final Scalar scalar = (Scalar) parser.calc("{-2,3,-4}*{5,-6,7}");
        final double actual = scalar.getValue();
        final double expected = -56.0;
        assertEquals(expected, actual, 1e-5);
    }

    @Test
    public void divVector() throws CalcException {
        final Vector vector = (Vector) parser.calc("{-2,3,-4}/5");
        final double[] actual = vector.getValue();
        final double[] expected = {-0.4, 0.6, -0.8};
        assertArrayEquals(expected, actual, 1e-5);
    }

    @Test
    public void addMatrix() throws CalcException {
        final Matrix matrix = (Matrix) parser.calc("{{-1,2},{3,-4}}+{{5,-6},{7,-8}}");
        final double[][] actual = matrix.getValue();
        final double[][] expected = {{4.0, -4.0}, {10.0, -12.0}};
        for (int i = 0; i < expected.length; i++) {
            assertArrayEquals(actual[i], expected[i], 1e-5);
        }
    }

//    @Test
//    public void subMatrix() throws CalcException {}
//
//
//    @Test
//    public void mulMatrix() throws CalcException {}
//
//
//    @Test
//    public void divMatrix() throws CalcException {}

    @Test
    public void expressionScalar() throws CalcException {
        final double actual = Double.parseDouble(parser.calc("A=2+5.3").toString());
        final double expected = 7.3;
        assertEquals(expected, actual, 1e-5);

        final double actual2 = Double.parseDouble(parser.calc("B=A*3.5").toString());
        final double expected2 = 25.55;
        assertEquals(expected2, actual2, 1e-5);

        final double actual3 = Double.parseDouble(parser.calc("B1=B+0.11*-5").toString());
        final double expected3 = 25.00;
        assertEquals(expected3, actual3, 1e-5);

        final double actual4 = Double.parseDouble(parser.calc("B2=A/2-1").toString());
        final double expected4 = 2.65;
        assertEquals(expected4, actual4, 1e-5);

//        final double actual5 = Double.parseDouble(parser.calc("C=B+(A*2)").toString());
//        final double expected5 = 40.15;
//        assertEquals(expected5, actual5, 1e-5);
    }

    @Test
    public void expressionVector() throws CalcException {
        final Vector vector = (Vector) parser.calc("V={1,2,3}+{4,5,6}");
        final double[] actual = vector.getValue();
        final double[] expected = {5, 7, 9};
        assertArrayEquals(actual, expected, 1e-5);
    }
}