/**
 * 
 */
package chapter19.topic3;

import static java.lang.System.getProperty;

/**
 * @author matsusita
 *
 */
public class MultiLineString {
	
	public static String join(String... lines) {
		if (lines == null) {
			return null;
		}
		String lineSeparator = getProperty("line.separator");
		StringBuilder text = new StringBuilder();
		for (String line : lines) {
			if (line != null) {
				text.append(line);
			}
			text.append(lineSeparator);
		}
		return text.toString();
	}
	
}
