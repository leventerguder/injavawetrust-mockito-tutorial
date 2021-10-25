package mockito;

import java.util.List;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

public class MockitoMockMethodExample {

	/*
	 * We can use Mockito class mock() method to create a mock object of a given
	 * class or interface. This is the simplest way to mock an object.
	 * 
	 */

	@SuppressWarnings("unchecked")
	@Test
	public void test() {

		// using Mockito.mock() method
		List<String> mockList = mock(List.class);
		when(mockList.size()).thenReturn(5);
		
		assertTrue(mockList.size() == 5);

	}
}
