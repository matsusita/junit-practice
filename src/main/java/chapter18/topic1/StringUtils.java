/**
 * 
 */
package chapter18.topic1;

/**
 * @author matsusita
 *
 */
public class StringUtils {
	
	/**
	 * @param string
	 * @return
	 */
	public static String toSnakeCase(String string) {
		return string.replaceAll("([A-Z]+)([A-Z][a-z])", "$1_$2").replaceAll("([a-z])([A-Z])", "$1_$2").toLowerCase();
	}
	
}
