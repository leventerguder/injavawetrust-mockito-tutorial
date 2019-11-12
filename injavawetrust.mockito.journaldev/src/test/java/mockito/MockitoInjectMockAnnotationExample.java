package mockito;

import java.util.List;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class MockitoInjectMockAnnotationExample {

	// Mockito @InjectMocks Annotation
	/*
	 * When we want to inject a mocked object into another mocked object we can
	 * use @InjectMocks annotation.
	 * 
	 * 
	 */

	@Mock
	List<String> mockList;

	/*
	 * @InjectMock creates an instance of the class and injects the mocks that are
	 * marked with the annotations @Mock into it.
	 */

	@InjectMocks
	Fruits mockFruits;

	@Test
	public void test() {
		when(mockList.get(0)).thenReturn("Apple");
		when(mockList.size()).thenReturn(1);
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