/**
 * 
 */
package chapter18.topic2;

import org.junit.Test;

/**
 * @author matsusita
 *
 */
public class CalculatorTest {
	
	@Test(expected = IllegalArgumentException.class)
	public void 第2引数に0を指定してdivideを呼び出すとIllegalArgumentExceptionが発生する() {
		Calculator systemUnderTest = new Calculator();
		systemUnderTest.divide(1, 0);
	}
}
