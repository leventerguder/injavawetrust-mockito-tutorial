package mockito;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// The below example shows the usage of @Mock annotation.

public class CalcService2Test {

	private CalcService calcService;

	@Mock
	private AddService addService;

	@BeforeEach
	public void setup() {

		// MockitoAnnotations.initMocks(this); // deprecated
		MockitoAnnotations.openMocks(this);

		// Note that we need to call MockitoAnnotations.openMocks(this); to initialize
		// objects annotated with @Mock , @Spy , @Captor , or @InjectMocks
	}

	@Test
	public void testCalc() {
		
		System.out.println("**--- Test testCalc executed ---**");

		calcService = new CalcService(addService);

		int num1 = 11;
		int num2 = 12;
		int expected = 23;

		when(addService.add(num1, num2)).thenReturn(expected);

		int actual = calcService.calc(num1, num2);

		assertEquals(expected, actual);

	}
}
