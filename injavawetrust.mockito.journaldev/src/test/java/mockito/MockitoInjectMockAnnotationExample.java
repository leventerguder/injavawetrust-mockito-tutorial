package mockito;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class MockitoInjectMockAnnotationExample {

	@BeforeEach
	public void setup() {
		// if we don't call below, we will get NullPointerException
		MockitoAnnotations.openMocks(this);
	}

	// Mockito @InjectMocks Annotation
	/*
	 * When we want to inject a mocked object into another mocked object we can
	 * use @InjectMocks annotation.
	 * 
	 * 
	 */

	@Mock
	private List<String> names;

	/*
	 * @InjectMock creates an instance of the class and injects the mocks that are
	 * marked with the annotations @Mock into it.
	 */

	@InjectMocks
	private Fruits mockFruits;

	@Test
	public void test() {

		when(names.get(0)).thenReturn("Apple");
		when(names.size()).thenReturn(1);

		assertEquals("Apple", names.get(0));
		assertEquals(1, names.size());

		// mockFruits names is using mockList, below asserts confirm it
		assertEquals("Apple", mockFruits.getNames().get(0));
		assertEquals(1, mockFruits.getNames().size());

		names.add(1, "Mango");
		// below will print null because mockList.get(1) is not stubbed
		System.out.println(names.get(1));
	}
}

class Fruits {

	private List<String> names;

	public List<String> getNames() {
		return names;
	}

	public void setNames(List<String> names) {
		this.names = names;
	}

}