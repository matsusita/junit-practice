/**
 * 
 */
package chapter20.topic4;

/**
 * @author matsusita
 *
 */
public class Authentication {
	
	AccountDao	dao	= null;
	
	
	public Account authenticate(String userId, String password) {
		assert dao != null;
		Account account = dao.findOrNull(userId);
		if (account == null) {
			return null;
		}
		return account.getPassword().equals(password) ? account : null;
	}
	
}
