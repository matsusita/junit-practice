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
		StringBuffer sb = new StringBuffer();
		String[] stringArray = string.split("(?=[A-Z])");
		for (String str : stringArray) {
			if (!sb.toString().isEmpty()) {
				sb.append("_");
			}
			sb.append(str.toLowerCase());
		}
		return sb.toString();
	}
	
}
