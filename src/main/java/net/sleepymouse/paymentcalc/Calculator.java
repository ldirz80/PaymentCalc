/**
 * 
 */
package net.sleepymouse.paymentcalc;

import java.math.*;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * Service for performing payment calculations and value formatting
 *
 */
public class Calculator implements ICalculator
{
	private final RoundingMode	mode;
	private final NumberFormat	nf;

	/**
	 * Fix accuracy and rounding for this instance
	 * 
	 * @param mode
	 *            Rounding mode to use in calculation
	 * @param inLocale
	 *            Currency locale for formatting
	 */
	public Calculator(RoundingMode mode, Locale inLocale)
	{
		this.mode = mode;
		this.nf = NumberFormat.getCurrencyInstance(inLocale);
	}

	/**
	 * Calculate the repayments amounts and final amount
	 * 
	 * @param totalAmount
	 *            Total amount requested
	 * @param numberOfPayments
	 *            Number of payments
	 * @return Payment result (repayment and final payment values)
	 * 
	 */
	public PaymentResultDto calcPayments(BigDecimal totalAmount, int numberOfPayments)
	{
		BigDecimal payments = new BigDecimal(numberOfPayments);
		BigDecimal payment = totalAmount.divide(payments, mode);
		BigDecimal remainder = totalAmount.subtract(payment.multiply(payments));
		return new PaymentResultDto(payment, remainder);
	}

	/**
	 * Format a currency value as per the locale constraints
	 * 
	 * @param value
	 *            Value to format
	 * @return Formatted value string
	 */
	public String format(BigDecimal value)
	{
		return nf.format(value);
	}

}
