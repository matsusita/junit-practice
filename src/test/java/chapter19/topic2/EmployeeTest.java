/**
 * 
 */
package chapter19.topic2;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.io.InputStream;
import java.util.List;

import org.junit.Test;

/**
 * @author matsusita
 *
 */
public class EmployeeTest {
	
	@Test
	public void loadでEmployeeの一覧を取得できる() {
		InputStream input = getClass().getResourceAsStream("Employee.txt");
		List<Employee> actual = Employee.load(input);
		assertThat(actual, is(notNullValue()));
		assertThat(actual.size(), is(1));
		Employee actualEmployee = actual.get(0);
		assertThat(actualEmployee.getFirstName(), is("Ichiro"));
		assertThat(actualEmployee.getLastName(), is("Tanaka"));
		assertThat(actualEmployee.getEmail(), is("ichiro@example.com"));
	}
	
}
