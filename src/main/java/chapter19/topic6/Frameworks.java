/**
 * 
 */
package chapter19.topic6;

/**
 * @author matsusita
 *
 */
public class Frameworks {
	
	public static boolean isSupport(ApplicationServer applicationServer, Database database) {
		switch (applicationServer) {
			case GlassFish:
				return true;
			case Tomcat:
				return database == Database.MySQL;
			case JBoss:
				return database == Database.DB2 || database == Database.PostgreSQL;
			default:
				return false;
		}
	}
	
}
