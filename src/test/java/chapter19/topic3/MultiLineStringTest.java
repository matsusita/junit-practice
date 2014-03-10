/**
 * 
 */
package chapter19.topic3;

import static java.lang.Math.min;
import static java.lang.System.getProperty;
import static java.util.regex.Pattern.compile;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.junit.Test;

/**
 * @author matsusita
 *
 */
public class MultiLineStringTest {
	
	@Test
	public void joinで文字列が連結される() {
		String hello = "Hello";
		String world = "World";
		String lineSeparator = getProperty("line.separator");
		StringBuilder sb = new StringBuilder();
		sb.append(hello);
		sb.append(lineSeparator);
		sb.append(world);
		sb.append(lineSeparator);
		String expected = sb.toString();
		assertThat(MultiLineString.join(hello, world), is(MultiLineStringMatcher.text(expected)));
	}
	
}

class MultiLineStringMatcher extends BaseMatcher<String> {
	
	public static org.hamcrest.Matcher<String> text(String text) {
		return new MultiLineStringMatcher(text, getProperty("line.separator"));
	}
	
	
	private final String		expected;
	private Object				actual;
	private final List<String>	expectedLines	= new ArrayList<String>();
	private final List<String>	actualLines		= new ArrayList<String>();
	private final Pattern		pattern;
	
	
	public MultiLineStringMatcher(String expected, String ls) {
		this.expected = expected;
		if ("\r".equals(ls)) {
			pattern = compile(".+(\\r|$)");
		} else if ("\n".equals(ls)) {
			pattern = compile(".+(\\n|$)");
		} else {
			pattern = compile(".+(\\r\\n|$)");
		}
		if (expected != null) {
			Matcher m = pattern.matcher(expected);
			while (m.find()) {
				expectedLines.add(expected.substring(m.start(), m.end()));
			}
		}
	}
	
	@Override
	public boolean matches(Object actual) {
		this.actual = actual;
		if (expected == null) {
			return actual == null;
		}
		if (!(actual instanceof String)) {
			return false;
		}
		if (expected.equals(actual)) {
			return true;
		}
		String actualString = (String)actual;
		Matcher m = pattern.matcher(actualString);
		while (m.find()) {
			actualLines.add(actualString.substring(m.start(), m.end()));
		}
		return expectedLines.equals(actualLines);
	}
	
	@Override
	public void describeTo(Description desc) {
		if (expected == null || actual == null) {
			desc.appendValue(expected);
			return;
		}
		int lines = min(expectedLines.size(), actualLines.size());
		for (int i = 0; i < lines; i++) {
			String expectedLine = expectedLines.get(i);
			String actualLine = actualLines.get(i);
			if (!expectedLine.equals(actualLine)) {
				desc.appendValue(expectedLine);
				desc.appendText(", but actual is ");
				desc.appendValue(actualLine);
				desc.appendText(", line ");
				desc.appendText(Integer.toString(i + 1));
				desc.appendText("\n");
				desc.appendValue(expected);
				return;
			}
		}
		desc.appendText("expected text is ");
		desc.appendText(Integer.toString(expectedLines.size()));
		desc.appendText(" lines, ");
		desc.appendText(" but actual text is ");
		desc.appendText(Integer.toString(actualLines.size()));
		desc.appendText(" lines\n");
		desc.appendValue(expected);
	}
	
}
