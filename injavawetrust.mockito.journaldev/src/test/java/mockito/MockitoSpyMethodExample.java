package mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class MockitoSpyMethodExample {

	// Mockito spy() for partial mocking
	// if we want to mock only specific behaviors and call the real methods for
	// unstubbed behaviors then we can create a spy object using Mockito spy()
	// method.

	@Test
	public void testSpy() {

		List<String> list = new ArrayList<>();
		List<String> spyOnList = spy(list);

		when(spyOnList.size()).thenReturn(10);
		assertEquals(10, spyOnList.size());

		// calling real methods since below methods are not stubbed

		spyOnList.add("element1");
		spyOnList.add("element2");

		assertEquals("element1", spyOnList.get(0));
		assertEquals("element2", spyOnList.get(1));
	}
}
