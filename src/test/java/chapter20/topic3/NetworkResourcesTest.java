/**
 * 
 */
package chapter20.topic3;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.ByteArrayInputStream;

import org.junit.Test;

/**
 * @author matsusita
 *
 */
public class NetworkResourcesTest {
	
	@Test
	public void loadでネットワークから取得した文字列を返す() throws Exception {
		String expected = "Hello World";
		NetworkLoader mockLoader = mock(NetworkLoader.class);
		ByteArrayInputStream input = new ByteArrayInputStream(expected.getBytes());
		when(mockLoader.getInput()).thenReturn(input);
		NetworkResources sut = new NetworkResources();
		sut.loader = mockLoader;
		String actual = sut.load();
		assertThat(actual, is(expected));
	}
	
}
