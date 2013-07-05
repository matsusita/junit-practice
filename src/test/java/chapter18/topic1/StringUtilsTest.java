/**
 * 
 */
package chapter18.topic1;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * @author matsusita
 *
 */
public class StringUtilsTest {
	
	@Test
	public void aaaを入力するとaaaが取得できる() throws Exception {
		StringUtils sut = new StringUtils();
		assertThat(sut.toSnakeCase("aaa"), is("aaa"));
	}
	
}
