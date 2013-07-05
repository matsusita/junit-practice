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
		assertThat(StringUtils.toSnakeCase("aaa"), is("aaa"));
	}
	
	@Test
	public void HelloWorldを入力するとhello_worldが取得できる() throws Exception {
		assertThat(StringUtils.toSnakeCase("HelloWorld"), is("hello_world"));
	}
	
}
