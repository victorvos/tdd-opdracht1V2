import org.junit.Test;

import java.util.Date;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class IncomeTaxCalculatorTest {

    private IncomeTaxCalculator taxCalculator;

    @org.junit.Before
    public void setUp()
    {
        taxCalculator = new IncomeTaxCalculator();
    }

    @Test
    public void AOWReached()
    {
        assertThat(19.00, is(taxCalculator.calculateTax(100, new Date("01/01/52"))));
        assertThat(3756.00, is(taxCalculator.calculateTax(20142, new Date("01/01/52"))));
        assertThat(4623.00, is(taxCalculator.calculateTax(20143, new Date("01/01/52"))));
        assertThat(27985.00, is(taxCalculator.calculateTax(68507, new Date("01/01/52"))));
        assertThat(35590.00, is(taxCalculator.calculateTax(68508, new Date("01/01/52"))));
    }

    @Test
    public void AOWNotReached()
    {
        assertThat(37.00, is(taxCalculator.calculateTax(100, new Date("01/01/53"))));
        assertThat(7362.00, is(taxCalculator.calculateTax(20142, new Date("01/01/53"))));
        assertThat(8228.00, is(taxCalculator.calculateTax(20143, new Date("01/01/53"))));
        assertThat(27985.00, is(taxCalculator.calculateTax(68507, new Date("01/01/53"))));
        assertThat(35590.00, is(taxCalculator.calculateTax(68508, new Date("01/01/53"))));
    }
}