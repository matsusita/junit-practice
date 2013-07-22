/**
 * 
 */
package chapter18.topic5;

import java.util.HashMap;
import java.util.Map;

/**
 * @author matsusita
 *
 */
public class ItemStock {
	
	private Map<String, Integer>	map	= new HashMap<String, Integer>();
	
	
	/**
	 * @param item Itemオブジェクト
	 * @return 数量
	 */
	public int getNum(Item item) {
		Integer num = map.get(item.name);
		if (num == null) {
			return 0;
		}
		return num;
	}
	
	/**
	 * @param item Itemオブジェクト
	 */
	public void add(Item item) {
		Integer num = map.get(item.name);
		if (num == null) {
			num = 0;
		}
		map.put(item.name, ++num);
	}
	
}
