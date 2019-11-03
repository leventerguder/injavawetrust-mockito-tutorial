package mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MockSingleElementTest {

	public static void main(String[] args) {

		@SuppressWarnings("unchecked")
		List<String> mockedList = mock(ArrayList.class);

		when(mockedList.get(0)).thenReturn("first-element");

		System.out.println(mockedList.get(0));
		assertEquals("first-element", mockedList.get(0));

		// "null" gets printed as get(1) is not stubbed
		System.out.println(mockedList.get(1));
	}
}
