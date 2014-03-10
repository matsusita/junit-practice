/**
 * 
 */
package chapter19.topic2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author matsusita
 *
 */
public class Employee {
	
	private String	firstName;
	private String	lastName;
	private String	email;
	
	
	/**
	 * @return firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * @param firstName セットする firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/**
	 * @return lastName
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * @param lastName セットする lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/**
	 * @return email
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * @param email セットする email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	public static List<Employee> load(InputStream input) {
		List<Employee> list = new ArrayList<Employee>();
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(input));
			while (true) {
				String line = reader.readLine();
				if (line == null) {
					break;
				}
				String[] values = line.split(",");
				Employee employee = new Employee();
				employee.setFirstName(values[0]);
				employee.setLastName(values[1]);
				employee.setEmail(values[2]);
				list.add(employee);
			}
			return list;
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
}
