/**
 * 
 */
package chapter20.topic4;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * @author matsusita
 *
 */
@RunWith(Enclosed.class)
public class AuthenticationTest {
	
	public static class アカウントが存在しない場合 {
		
		Authentication	sut;
		
		
		@Before
		public void setUp() {
			sut = new Authentication();
			sut.dao = mock(AccountDao.class);
			when(sut.dao.findOrNull("user001")).thenReturn(null);
		}
		
		@Test
		public void authenticateはnullを返す() {
			assertThat(sut.authenticate("user001", "pw123"), is(nullValue()));
		}
		
	}
	
	public static class アカウントが存在しパスワードが一致する場合 {
		
		Authentication	sut;
		Account			account;
		
		
		@Before
		public void setUp() {
			sut = new Authentication();
			sut.dao = mock(AccountDao.class);
			account = new Account("user001", "pw123");
			when(sut.dao.findOrNull("user001")).thenReturn(account);
		}
		
		@Test
		public void authenticateはaccountを返す() {
			assertThat(sut.authenticate("user001", "pw123"), is(sameInstance(account)));
		}
		
	}
	
	public static class アカウントが存在するがパスワードが一致しない場合 {
		
		Authentication	sut;
		Account			account;
		
		
		@Before
		public void setUp() {
			sut = new Authentication();
			sut.dao = mock(AccountDao.class);
			account = new Account("user001", "PW999");
			when(sut.dao.findOrNull("user001")).thenReturn(account);
		}
		
		@Test
		public void authenticateはnullを返す() {
			assertThat(sut.authenticate("user001", "pw123"), is(nullValue()));
		}
		
	}
	
}
