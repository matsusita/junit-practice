/**
 * 
 */
package chapter18.topic4;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * @author matsusita
 *
 */
public class NumberUtilsTest {
	
	@Test
	public void 入力値に10を与えるとtrueを返す() {
		assertThat(NumberUtils.isEven(10), is(true));
	}
	
	@Test
	public void 入力値に7を与えるとfalseを返す() {
		assertThat(NumberUtils.isEven(7), is(false));
	}
	
}
