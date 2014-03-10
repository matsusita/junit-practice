/**
 * 
 */
package chapter19.topic1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author matsusita
 *
 */
public class FizzBuzz {
	
	public static List<String> createFizzBuzzList(int size) {
		List<String> list = new ArrayList<String>();
		int fizz = 3;
		int buzz = 5;
		for (int i = 1; i <= size; i++) {
			if (i % (fizz * buzz) == 0) {
				list.add("FizzBuzz");
				continue;
			} else if (i % fizz == 0) {
				list.add("Fizz");
				continue;
			} else if (i % buzz == 0) {
				list.add("Buzz");
				continue;
			}
			list.add(Integer.toString(i));
		}
		return list;
	}
	
}
