/**
 * 
 */
package chapter20.topic6;

import static java.lang.System.out;
import static java.lang.System.setOut;
import static org.mockito.Mockito.verify;

import java.io.PrintStream;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;
import org.mockito.Mockito;

/**
 * @author matsusita
 *
 */
public class HelloWorldTest extends HelloWorld {
	
	@Rule
	public SysoutSpy	sysoutSpy	= new SysoutSpy();
	
	
	@Test
	public void outputにHelloWorldが出力される() {
		HelloWorld sut = new HelloWorld();
		sut.say();
		verify(sysoutSpy.spy).println("Hello World");
	}
	
	
	class SysoutSpy implements TestRule {
		
		PrintStream	spy;
		
		
		@Override
		public Statement apply(final Statement base, Description description) {
			return new Statement() {
				
				@Override
				public void evaluate() throws Throwable {
					spy = Mockito.spy(out);
					setOut(spy);
					base.evaluate();
				}
			};
		}
		
	}
	
}
