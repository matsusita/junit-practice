/**
 * 
 */
package chapter18.topic6;

import org.junit.Test;

/**
 * @author matsusita
 *
 */
public class BackgroundTaskTest {
	
	@Test
	public void invokeメソッドによりRunnableオブジェクトのrunメソッドが別スレッドで実行される() {
		BackgroundTask systemUnderTest = new BackgroundTask();
		systemUnderTest.invoke();
	}
	
}
