/**
 * 
 */
package chapter18.topic6;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

/**
 * @author matsusita
 *
 */
public class BackgroundTaskTest {
	
	@Rule
	public Timeout	timeout	= new Timeout(1000);
	
	
	@Test
	public void invokeメソッドによりRunnableオブジェクトのrunメソッドが別スレッドで実行される() throws Exception {
		// SetUp
		final AtomicReference<String> backgroundThreadName = new AtomicReference<String>();
		final CountDownLatch latch = new CountDownLatch(1);
		Runnable task = new Runnable() {
			
			@Override
			public void run() {
				backgroundThreadName.set(Thread.currentThread().getName());
				latch.countDown();
			}
			
		};
		BackgroundTask systemUnderTest = new BackgroundTask(task);
		systemUnderTest.invoke();
		latch.await();
		// Verify
		assertThat(backgroundThreadName.get(), is(not(Thread.currentThread().getName())));
	}
	
}
