/**
 * 
 */
package chapter19.topic5;

/**
 * @author matsusita
 *
 */
public class ConsumptionTax {
	
	private final int	rate;
	
	
	public ConsumptionTax(int rate) {
		this.rate = rate;
	}
	
	public int apply(int price) {
		return price + (price * rate / 100);
	}
	
}
