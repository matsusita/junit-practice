/**
 * 
 */
package chapter18.topic5;

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
public class ItemStockTest {
	
	public static class 初期状態 {
		
		Item		item;
		ItemStock	systemUnderTest;
		
		
		@Before
		public void setUp() {
			item = new Item("name", 0);
			systemUnderTest = new ItemStock();
		}
		
		@Test
		public void getNumで0が取得できる() {
			assertThat(systemUnderTest.getNum(item), is(0));
		}
		
		@Test
		public void addでItemを追加するとgetNumで1が取得できる() {
			systemUnderTest.add(item);
			assertThat(systemUnderTest.getNum(item), is(1));
		}
		
	}
	
	public static class Itemが1つ追加されている状態 {
		
		Item		item;
		ItemStock	systemUnderTest;
		
		
		@Before
		public void setUp() {
			item = new Item("name", 0);
			systemUnderTest = new ItemStock();
			systemUnderTest.add(item);
		}
		
		@Test
		public void getNumで1が取得できる() {
			assertThat(systemUnderTest.getNum(item), is(1));
		}
		
		@Test
		public void addで同じItemオブジェクトを追加するとgetNumで2が取得できる() {
			systemUnderTest.add(item);
			assertThat(systemUnderTest.getNum(item), is(2));
		}
		
		@Test
		public void addで異なるItemオブジェクトを追加するとgetNumで1が取得できる() {
			Item item2 = new Item("name2", 0);
			systemUnderTest.add(item2);
			assertThat(systemUnderTest.getNum(item), is(1));
			assertThat(systemUnderTest.getNum(item2), is(1));
		}
		
	}
	
}
