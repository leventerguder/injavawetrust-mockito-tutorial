package mockito;

import org.junit.Before;
import org.junit.Test;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import mockito.AddService;
import mockito.CalcService;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;



public class CalcService2Test {

	CalcService calcService;

	@Mock
	AddService addService;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		
		// Note that we need to call MockitoAnnotations.initMocks(this); to initialize objects annotated with @Mock , @Spy , @Captor , or @InjectMocks
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
