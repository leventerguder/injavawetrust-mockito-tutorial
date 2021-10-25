package mockito;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MockSingleElementTest {

	@Test
	public void testMethod() {

		/*
		 * Using when() – thenReturn() function, we can stub a concrete/implementation
		 * class and also a single element of a collection. The non-stubbed elements
		 * will contains null in them.
		 */

		@SuppressWarnings("unchecked")
		List<String> mockedList = mock(ArrayList.class);

		when(mockedList.get(0)).thenReturn("first-element");

		System.out.println(mockedList.get(0));
		assertEquals("first-element", mockedList.get(0));

		assertEquals(null, mockedList.get(1));
	}
}
