/**
 * 
 */
package net.sleepymouse.paymentcalc;

import static java.math.BigDecimal.ZERO;

import java.math.*;
import java.util.Locale;

/**
 *
 */
public class PaymentCalc
{

	/**
	 * Supply two arguments, total amount and number of payments
	 * 
	 * @param args
	 *            Total amount requested and number of payments
	 * @throws IllegalArgumentException
	 *             Must supply two arguments
	 */
	public static void main(String[] args)
	{
		if (2 == args.length)
		{
			PaymentCalc paymentCalc = new PaymentCalc();
			paymentCalc.exec(args);
		}
		else
		{
			System.out.println("usage: java -jar PaymentCalc-1.0.0.jar <Total Amount> <No of payments>");
		}
	}

	/**
	 * Read in arguments, do required calculations and display results
	 * 
	 * @param args
	 *            Total amount requested and number of payments
	 */
	private void exec(String[] args)
	{
		// Get the arguments - in real world would need to do validation here
		BigDecimal totalAmount = new BigDecimal(args[0]);
		int numberOfPayments = Integer.parseInt(args[1]);
		//
		// Do the calculations
		ICalculator calculator = new Calculator(RoundingMode.HALF_UP, Locale.UK);
		PaymentResultDto dto = calculator.calcPayments(totalAmount, numberOfPayments);
		//
		// Display results
		System.out.println("Regular Amount " + calculator.format(dto.getRepaymentAmount()));
		BigDecimal remainder = dto.getRemainderAmount();
		if (0 != remainder.compareTo(ZERO))
		{
			// Non zero remainder so display last amount
			System.out.println(
					"Last Amount    " + calculator.format(dto.getRepaymentAmount().add(dto.getRemainderAmount())));
		}
	}

}
