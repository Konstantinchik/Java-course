package by.it.evstratov.calc;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ParserTestScalar {

    private Parser parser;

    @Before
    public void setUp() throws Exception {
        parser = new Parser();
    }

    @Test
    public void addTest() throws CalcException {
        Var actualScalar = parser.calc("2+2+7+8");
        double actual = Double.parseDouble(actualScalar.toString());
        double expected = 19.0;
        assertEquals(expected, actual, 1e-5);
    }

    @Test
    public void divTest() throws CalcException {
        Var actualScalar = parser.calc("10/5");
        double actual = Double.parseDouble(actualScalar.toString());
        double expected = 2;
        assertEquals(expected, actual, 1e-5);
        actualScalar = parser.calc("18/3");
        actual = Double.parseDouble(actualScalar.toString());
        expected = 6;
        assertEquals(expected, actual, 1e-5);
    }

    @Test
    public void subTest() throws CalcException {
        Var actualScalar = parser.calc("20-4");
        double actual = Double.parseDouble(actualScalar.toString());
        double expected = 16;
        assertEquals(expected, actual, 1e-5);
        actualScalar = parser.calc("18-13");
        actual = Double.parseDouble(actualScalar.toString());
        expected = 5;
        assertEquals(expected, actual, 1e-5);
    }

    @Test
    public void mulTest() throws CalcException {
        Var actualScalar = parser.calc("20*4");
        double actual = Double.parseDouble(actualScalar.toString());
        double expected = 80;
        assertEquals(expected, actual, 1e-5);
        actualScalar = parser.calc("5*2");
        actual = Double.parseDouble(actualScalar.toString());
        expected = 10;
        assertEquals(expected, actual, 1e-5);
    }

    @Test
    public void expression() throws CalcException {
        double actual = Double.parseDouble(parser.calc("A=2+5.3").toString());
        assertEquals(7.3, actual, 1e-5);
        actual = Double.parseDouble(parser.calc("B=A*3.5").toString());
        assertEquals(25.55, actual, 1e-5);
        actual = Double.parseDouble(parser.calc("B1=B+0.11*-5").toString());
        assertEquals(25, actual, 1e-5);
        actual = Double.parseDouble(parser.calc("B2=A/2-1").toString());
        assertEquals(2.65, actual, 1e-5);
        actual = Double.parseDouble(parser.calc("C=B+(A*2)").toString());
        assertEquals(40.15, actual, 1e-5);
        actual = Double.parseDouble(parser.calc("D=((C-0.15)-20)/(7-5)").toString());
        assertEquals(10, actual, 1e-5);
    }

    @After
    public void tearDown() throws Exception {
    }
}