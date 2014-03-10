/**
 * 
 */
package chapter20.topic1;

import static java.util.Calendar.DATE;
import static java.util.Calendar.getInstance;

import java.util.Calendar;

/**
 * @author matsusita
 *
 */
public class MonthlyCalendar {
	
	private final Calendar	cal;
	
	
	public MonthlyCalendar() {
		this(getInstance());
	}
	
	MonthlyCalendar(Calendar cal) {
		this.cal = cal;
	}
	
	public int getRemainingDays() {
		return cal.getActualMaximum(DATE) - cal.get(DATE);
	}
	
}
