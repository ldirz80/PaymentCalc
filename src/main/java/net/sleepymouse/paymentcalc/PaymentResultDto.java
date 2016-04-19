/**
 * 
 */
package net.sleepymouse.paymentcalc;

import java.math.BigDecimal;

/**
 * DTO to hold repayment calculation results
 *
 */
public class PaymentResultDto
{
	private BigDecimal	repaymentAmount;
	private BigDecimal	remainderAmount;

	public PaymentResultDto(BigDecimal repaymentAmount, BigDecimal remainderAmount)
	{
		this.repaymentAmount = repaymentAmount;
		this.remainderAmount = remainderAmount;
	}

	/**
	 * @return the repaymentAmount
	 */
	public BigDecimal getRepaymentAmount()
	{
		return repaymentAmount;
	}

	/**
	 * @return the remainderAmount
	 */
	public BigDecimal getRemainderAmount()
	{
		return remainderAmount;
	}

}
