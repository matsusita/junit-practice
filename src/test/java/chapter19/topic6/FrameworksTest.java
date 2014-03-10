/**
 * 
 */
package chapter19.topic6;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assume.assumeTrue;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

/**
 * @author matsusita
 *
 */
@RunWith(Theories.class)
public class FrameworksTest extends Frameworks {
	
	@DataPoints
	public static ApplicationServer[]	APP_SERVER_PARAMS	= ApplicationServer.values();
	
	@DataPoints
	public static Database[]			DATABASE_PARAMS		= Database.values();
	
	static Map<String, Boolean>			SUPPORTS			= new HashMap<String, Boolean>();
	
	
	@BeforeClass
	public static void setUpClass() throws Exception {
		InputStream in = FrameworksTest.class.getResourceAsStream("support.txt");
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(in));
			while (true) {
				String line = reader.readLine();
				if (line == null) {
					break;
				}
				String[] params = line.split("\\|");
				StringBuilder sb = new StringBuilder();
				sb.append(params[0]);
				sb.append("-");
				sb.append(params[1]);
				SUPPORTS.put(sb.toString(), Boolean.valueOf(params[2]));
			}
		} finally {
			if (reader != null) {
				reader.close();
			}
		}
		
	}
	
	@Theory
	public void isSupportはtrueを返す(ApplicationServer applicationServer, Database database) {
		assumeTrue(isSupport(applicationServer, database));
		StringBuilder sb = new StringBuilder();
		sb.append(", AppServer:");
		sb.append(applicationServer);
		sb.append(", DB:");
		sb.append(database);
		String desc = sb.toString();
		assertThat(desc, Frameworks.isSupport(applicationServer, database), is(true));
	}
	
	@Theory
	public void isSupportはfalseを返す(ApplicationServer applicationServer, Database database) {
		assumeTrue(!isSupport(applicationServer, database));
		StringBuilder sb = new StringBuilder();
		sb.append(", AppServer:");
		sb.append(applicationServer);
		sb.append(", DB:");
		sb.append(database);
		String desc = sb.toString();
		assertThat(desc, Frameworks.isSupport(applicationServer, database), is(false));
	}
	
	public static boolean isSupport(ApplicationServer applicationServer, Database database) {
		StringBuilder sb = new StringBuilder();
		sb.append(applicationServer.toString());
		sb.append("-");
		sb.append(database.toString());
		return SUPPORTS.get(sb.toString());
	}
	
}
