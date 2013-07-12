/**
 * 
 */
package chapter18.topic3;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * @author matsusita
 *
 */
@RunWith(Enclosed.class)
public class CounterTest {
	
	public static class 初期状態 {
		
		Counter	systemUnderTest;
		
		
		@Before
		public void setUp() {
			systemUnderTest = new Counter();
		}
		
		@Test
		public void incrementメソッドを実行すると1が取得できる() {
			assertThat(systemUnderTest.increment(), is(1));
		}
		
	}
	
	public static class incrementメソッドを1回実行した状態 {
		
		Counter	systemUnderTest;
		
		
		@Before
		public void setUp() {
			systemUnderTest = new Counter();
			// incrementメソッドを1回実行
			systemUnderTest.increment();
		}
		
		@Test
		public void incrementメソッドを実行すると2が取得できる() {
			assertThat(systemUnderTest.increment(), is(2));
		}
		
	}
	
	public static class incrementメソッドを50回実行した状態 {
		
		Counter	systemUnderTest;
		
		
		@Before
		public void setUp() {
			systemUnderTest = new Counter();
			for (int i = 0; i < 50; i++) {
				// incrementメソッドを50回実行
				systemUnderTest.increment();
			}
		}
		
		@Test
		public void incrementメソッドを実行すると51が取得できる() {
			assertThat(systemUnderTest.increment(), is(51));
		}
		
	}
	
}
