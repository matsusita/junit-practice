/**
 * 
 */
package chapter19.topic4;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * @author matsusita
 *
 */
public class RangeTest {
	
	@Test
	public void containsのテスト() {
		Range range1 = new Range(0, 10.5);
		Range range2 = new Range(-5.1, 5.1);
		assertThat(range1.contains(-0.1), is(false));
		assertThat(range1.contains(0), is(true));
		assertThat(range1.contains(10.5), is(true));
		assertThat(range1.contains(10.6), is(false));
		assertThat(range2.contains(-5.2), is(false));
		assertThat(range2.contains(-5.1), is(true));
		assertThat(range2.contains(-5.1), is(true));
		assertThat(range2.contains(-5.2), is(false));
	}
	
}
