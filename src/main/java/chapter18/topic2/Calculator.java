/**
 * 
 */
package chapter18.topic2;

/**
 * @author matsusita
 *
 */
public class Calculator {
	
	/**
	 * @param i
	 * @param j
	 */
	public int divide(int i, int j) {
		if (j == 0) {
			throw new IllegalArgumentException();
		}
		return i / i;
	}
	
}
