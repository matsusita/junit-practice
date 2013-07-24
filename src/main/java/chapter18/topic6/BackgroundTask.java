/**
 * 
 */
package chapter18.topic6;

import java.util.concurrent.Executors;

/**
 * @author matsusita
 *
 */
public class BackgroundTask {
	
	private final Runnable	task;
	
	
	/**
	 * @param task runnable
	 */
	public BackgroundTask(Runnable task) {
		this.task = task;
	}
	
	/**
	 * 
	 */
	public void invoke() {
		Executors.newSingleThreadExecutor().execute(task);
	}
	
}
