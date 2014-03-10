/**
 * 
 */
package chapter20.topic4;

/**
 * @author matsusita
 *
 */
public class Account {
	
	private String	name;
	private String	password;
	
	
	public Account(String name, String password) {
		this.name = name;
		this.password = password;
	}
	
	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @param name セットする name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return password
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * @param password セットする password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
}
