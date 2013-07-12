/**
 * 
 */
package chapter18.topic3;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * @author matsusita
 *
 */
public class CounterTest {
	
	@Test
	public void 初期状態でincrementメソッドを実行すると1が取得できる() {
		Counter systemUnderTest = new Counter();
		assertThat(systemUnderTest.increment(), is(1));
	}
	
	@Test
	public void incrementメソッドを1回実行した状態でincrementメソッドを実行すると2が取得できる() {
		Counter systemUnderTest = new Counter();
		// incrementメソッドを1回実行
		systemUnderTest.increment();
		assertThat(systemUnderTest.increment(), is(2));
	}
	
	@Test
	public void incrementメソッドを50回実行した状態でincrementメソッドを実行すると51が取得できる() {
		Counter systemUnderTest = new Counter();
		for (int i = 0; i < 50; i++) {
			// incrementメソッドを50回実行
			systemUnderTest.increment();
		}
		assertThat(systemUnderTest.increment(), is(51));
	}
	
}
