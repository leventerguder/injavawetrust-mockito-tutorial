package mockito;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class MockitoMockAnnotationExample {

	/*
	 * We can mock an object using @Mock annotation too. It’s useful when we want to
	 * use the mocked object at multiple places because we avoid calling mock()
	 * method multiple times. The code becomes more readable and we can specify mock
	 * object name that will be useful in case of errors.
	 * 
	 */

	/*
	 * When using @Mock annotation , we have to make sure that we call
	 * MockitoAnnotations.openMocks(this) to initialize the mocked object.
	 * 
	 * We can do this in testing framework setup methods that are executed before
	 * the tests.
	 * 
	 */

	@Mock
	private List<String> mockList;

	@BeforeAll
	public void setup() {
		// if we dont call below , we will get NullPointerException
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void test() {

		when(mockList.get(0)).thenReturn("injavawetrust");
		when(mockList.get(1)).thenReturn("java");
		when(mockList.get(1)).thenReturn("mockito");

		assertEquals("injavawetrust", mockList.get(0));
		assertEquals("java", mockList.get(1));
		assertEquals("mockito", mockList.get(2));

	}

}
