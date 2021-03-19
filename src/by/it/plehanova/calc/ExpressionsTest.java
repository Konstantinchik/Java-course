package by.it.plehanova.calc;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ExpressionsTest {
    private Parser parser;

    @Before
    public void setUp() throws Exception {
        parser = new Parser();
    }

    @Test
    public void expressionCalc() throws CalcException {
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

        Vector vector = (Vector) parser.calc("E={2,3}*(D/2)");
        double[] actualV = vector.getArray();
        double[] expected = {10,15};
        assertArrayEquals(expected,actualV,1e-5);


    }

    @After
    public void tearDown() throws Exception {
    }
}