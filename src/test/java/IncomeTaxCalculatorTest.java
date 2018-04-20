import org.junit.Test;

import java.text.ParseException;
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

    @Test(expected = ParseException.class)
    public void shouldReturnZeroAsThereIsNoTaxPay() throws ParseException {
        assertThat(taxCalculator.calculateTax(555555, new Date("20/03/1980")), is(0.0d));
    }

    @Test
    public void testCalcTaxEersteSchijf() {
        //test eerste schijf:
        assertThat(37.00d, is(taxCalculator.calculateTax(100, new Date("01/01/53"))));
    }

    @Test
    public void testCalcTaxTweedeSchijf() {
        assertThat( 8228.00d, is(taxCalculator.calculateTax(20143, new Date("01/01/53"))));
    }

    @Test
    public void testCalcTaxDerdeSchijf() {
        assertThat(35590.00d, is(taxCalculator.calculateTax(68508, new Date("01/01/53"))));
    }


    @Test
    public void testCalAOWTaxEersteSchijf() {
        //test eerste schijf:
        assertThat(19.00, is(taxCalculator.calculateTax(100, new Date("01/01/52"))));
    }

    @Test
    public void testCalcAOWTaxTweedeSchijf() {
        //test tweede schijf:
        assertThat(4623.00, is(taxCalculator.calculateTax(20143, new Date("01/01/52"))));
    }

    @Test
    public void testCalcAOWwTaxDerdeSchijf() {
        //test derde schijf:
        assertThat(27985.00d, is(taxCalculator.calculateTax(68507, new Date("01/01/52"))));
    }

    @Test
    public void testCalcAOWTaxVierdeSchijf() {
        //test vierde en laatste schijf:
        assertThat( 35590.00, is(taxCalculator.calculateTax(68508, new Date("01/01/52"))));
    }
    @Test
    public void AOW()
    {
        assertThat(19.00, is(taxCalculator.calculateTax(100, new Date("01/01/52"))));
        assertThat(3756.00, is(taxCalculator.calculateTax(20142, new Date("01/01/52"))));
        assertThat(4623.00, is(taxCalculator.calculateTax(20143, new Date("01/01/52"))));
        assertThat(27985.00, is(taxCalculator.calculateTax(68507, new Date("01/01/52"))));
        assertThat(35590.00, is(taxCalculator.calculateTax(68508, new Date("01/01/52"))));
    }


    @Test
    public void noAOW()
    {
        assertThat(37.00, is(taxCalculator.calculateTax(100, new Date("01/01/53"))));
        assertThat(7362.00, is(taxCalculator.calculateTax(20142, new Date("01/01/53"))));
        assertThat(8228.00, is(taxCalculator.calculateTax(20143, new Date("01/01/53"))));
        assertThat(27985.00, is(taxCalculator.calculateTax(68507, new Date("01/01/53"))));
        assertThat(35590.00, is(taxCalculator.calculateTax(68508, new Date("01/01/53"))));
    }
}