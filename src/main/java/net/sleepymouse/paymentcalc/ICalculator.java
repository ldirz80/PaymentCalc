/**
 * 
 */
package net.sleepymouse.paymentcalc;

import java.math.BigDecimal;

/**
 * Service interface for performing payment calculations and value formatting
 *
 */
public interface ICalculator
{
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
	PaymentResultDto calcPayments(BigDecimal totalAmount, int numberOfPayments);

	/**
	 * Format a currency value as per the locale constraints
	 * 
	 * @param value
	 *            Value to format
	 * @return Formatted value string
	 */
	String format(final BigDecimal value);
}
