package by.it.plehanova.calc;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ScalarTest {
    private Parser parser;

    @Before
    public void setUp() throws Exception {
        parser = new Parser();
    }

    @Test
    public void variableTest() {
        String strVar = "9.4";
        Scalar scalar = new Scalar(strVar);
        String actual = scalar.toString();
        String expected = strVar;
        assertEquals(expected, actual);
    }

    @Test
    public void addTest() throws CalcException {
        Var actualScalar = parser.calc("3+1+2+4");
        double actual = Double.parseDouble(actualScalar.toString());
        double expected = 10.0;
        assertEquals(expected, actual, 1e-5);

        actualScalar = parser.calc("6+3+1+7");
        actual = Double.parseDouble(actualScalar.toString());
        expected = 17.0;
        assertEquals(expected, actual, 1e-5);

    }

    @Test
    public void subTest() throws CalcException {
        Var actualScalar = parser.calc("9-3-2-3");
        double actual = Double.parseDouble(actualScalar.toString());
        double expected = 1.0;
        assertEquals(expected, actual, 1e-5);

        actualScalar = parser.calc("17-3-1-7");
        actual = Double.parseDouble(actualScalar.toString());
        expected = 6.0;
        assertEquals(expected, actual, 1e-5);
    }

    @Test
    public void mulTest() throws CalcException {
        Var actualScalar = parser.calc("2*2*3*4");
        double actual = Double.parseDouble(actualScalar.toString());
        double expected = 48.0;
        assertEquals(expected, actual, 1e-5);

        actualScalar = parser.calc("3*5*2*4");
        actual = Double.parseDouble(actualScalar.toString());
        expected = 120.0;
        assertEquals(expected, actual, 1e-5);
    }

    @Test
    public void divTest() throws CalcException {
        Var actualScalar = parser.calc("12/3");
        double actual = Double.parseDouble(actualScalar.toString());
        double expected = 4.0;
        assertEquals(expected, actual, 1e-5);

        actualScalar = parser.calc("4/8");
        actual = Double.parseDouble(actualScalar.toString());
        expected = 0.5;
        assertEquals(expected, actual, 1e-5);
    }

    @Test
    public void expressionScalars() throws CalcException {
        double actual = Double.parseDouble(parser.calc("A=2+5.3").toString());
        assertEquals(7.3,actual,1e-5);

        actual = Double.parseDouble(parser.calc("B=A*3.5").toString());
        assertEquals(25.55,actual,1e-5);

        actual = Double.parseDouble(parser.calc("B1=B+0.11*-5").toString());
        assertEquals(25.0,actual,1e-5);

        actual = Double.parseDouble(parser.calc("B2=A/2-1").toString());
        assertEquals(2.65,actual,1e-5);

        actual = Double.parseDouble(parser.calc("C=B+(A*2)").toString());
        assertEquals(40.15,actual,1e-5);

        actual = Double.parseDouble(parser.calc("D=((C-0.15)-20)/(7-5)").toString());
        assertEquals(10,actual,1e-5);
    }

    @After
    public void tearDown() throws Exception {
    }
}