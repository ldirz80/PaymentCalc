package net.sleepymouse.paymentcalc;

import static java.math.BigDecimal.ZERO;

import java.math.*;
import java.util.Locale;

import org.junit.*;

/**
 * 
 * Basic tests for the calculator components
 * 
 * Real world testing would include further test cases to cover differing rounding strategies, erroneous data and
 * varying precisions
 * 
 * This is backed up with coverage and static analysis
 *
 */
public class CalculatorTest
{
	private ICalculator calculator;

	@Before
	public void setUp() throws Exception
	{
		calculator = new Calculator(RoundingMode.HALF_UP, Locale.UK);
	}

	/**
	 * Verify correct calculation of payment and remainder amounts
	 */
	@Test
	public final void testCalcPayments()
	{
		BigDecimal value = new BigDecimal("10.00");
		PaymentResultDto dto = calculator.calcPayments(value, 4);
		Assert.assertEquals(0, dto.getRepaymentAmount().compareTo(new BigDecimal("2.5")));
		Assert.assertEquals(0, dto.getRemainderAmount().compareTo(ZERO));
		//
		// http://www.stichlberger.com/software/java-bigdecimal-gotchas/
		// Precision != Scale
		value = new BigDecimal("10");
		dto = calculator.calcPayments(value, 4);
		Assert.assertEquals(0, dto.getRepaymentAmount().compareTo(new BigDecimal("2.5")));
		Assert.assertEquals(0, dto.getRemainderAmount().compareTo(ZERO));
		//
		dto = calculator.calcPayments(value, 3);
		Assert.assertEquals(0, dto.getRepaymentAmount().compareTo(new BigDecimal("3.33")));
		Assert.assertEquals(0, dto.getRemainderAmount().compareTo(new BigDecimal("0.01")));
		//
		value = new BigDecimal("5444333222.00");
		dto = calculator.calcPayments(value, 1234);
		Assert.assertEquals(0, dto.getRepaymentAmount().compareTo(new BigDecimal("4411939.4")));
		Assert.assertEquals(0, dto.getRemainderAmount().compareTo(new BigDecimal("2.4")));
	}

	/**
	 * Verify formatter operating correctly.
	 * 
	 * Test with various fractional parts
	 */
	@Test
	public final void testFormat()
	{
		BigDecimal value = new BigDecimal("2.5");
		Assert.assertEquals(calculator.format(value), "£2.50");
		//
		value = new BigDecimal("3.33");
		Assert.assertEquals(calculator.format(value), "£3.33");
		//
		value = new BigDecimal("4.444");
		Assert.assertEquals(calculator.format(value), "£4.44");
		//
		value = new BigDecimal("5.555");
		Assert.assertEquals(calculator.format(value), "£5.56");
	}

}