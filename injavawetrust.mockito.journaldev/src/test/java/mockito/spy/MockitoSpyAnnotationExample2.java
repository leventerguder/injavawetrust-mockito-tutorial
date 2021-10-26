package mockito.spy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

public class MockitoSpyAnnotationExample2 {

	@Spy
	List<String> spyOnList = new ArrayList<>();

	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void test() {

		spyOnList.add("A");
		assertEquals(1, spyOnList.size());
		assertEquals("A", spyOnList.get(0));

		spyOnList.add("E");
		assertEquals(2, spyOnList.size());
		assertEquals("E", spyOnList.get(1));

		when(spyOnList.size()).thenReturn(10);
		assertEquals(10, spyOnList.size());

		/*
		 * When we have to reuse spied object at multiple places, it’s better to
		 * use @Spy annotation.
		 */

		/*
		 * it’s recommended to use Spy to create partial mocks. Because in Spy, we are
		 * instantiating an object, whereas when we create a mock object, Mockito
		 * creates a bare-minimum instance of the object
		 */
	}
}
