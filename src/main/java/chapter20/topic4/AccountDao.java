/**
 * 
 */
package chapter20.topic4;

/**
 * @author matsusita
 *
 */
public interface AccountDao {
	
	/**
	 * userIdを指定し、アカウント情報を取得する
	 * @param userId システムで一意であるユーザID
	 * @return 指定されたユーザIDのアカウント情報、存在しない場合はnull
	 */
	Account findOrNull(String userId);
	
}
