/**
 * 
 */
package chapter20.topic1;

import static java.util.Calendar.DAY_OF_MONTH;
import static java.util.Calendar.HOUR_OF_DAY;
import static java.util.Calendar.MILLISECOND;
import static java.util.Calendar.MINUTE;
import static java.util.Calendar.MONTH;
import static java.util.Calendar.SECOND;
import static java.util.Calendar.YEAR;
import static java.util.Calendar.getInstance;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Calendar;

import org.junit.Test;

/**
 * @author matsusita
 *
 */
public class MonthlyCalendarTest {
	
	@Test
	public void 現在時刻が20120131の場合getRemainingDaysは0を返す() {
		MonthlyCalendar sut = new MonthlyCalendar(newCalendar(2012, 1, 31));
		assertThat(sut.getRemainingDays(), is(0));
	}
	
	@Test
	public void 現在時刻が20120130の場合getRemainingDaysは1を返す() {
		MonthlyCalendar sut = new MonthlyCalendar(newCalendar(2012, 1, 30));
		assertThat(sut.getRemainingDays(), is(1));
	}
	
	@Test
	public void 現在時刻20120201の場合getRemainingDaysは28を返す() {
		MonthlyCalendar sut = new MonthlyCalendar(newCalendar(2012, 2, 1));
		assertThat(sut.getRemainingDays(), is(28));
	}
	
	static Calendar newCalendar(int yyyy, int mm, int dd) {
		Calendar cal = getInstance();
		cal.set(YEAR, yyyy);
		cal.set(MONTH, mm - 1);
		cal.set(DAY_OF_MONTH, dd);
		cal.set(HOUR_OF_DAY, 0);
		cal.set(MINUTE, 0);
		cal.set(SECOND, 0);
		cal.set(MILLISECOND, 0);
		return cal;
	}
	
}
