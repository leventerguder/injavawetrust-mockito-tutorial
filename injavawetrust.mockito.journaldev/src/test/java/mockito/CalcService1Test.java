package mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.mockito.Mockito;

import mockito.AddService;
import mockito.CalcService;

public class CalcService1Test {

	@Test
	public void testCalc() {

		System.out.println("**--- Test testCalc executed ---**");

		AddService addService = Mockito.mock(AddService.class);
		CalcService calcService = new CalcService(addService);

		int num1 = 11;
		int num2 = 12;
		int expected = 23;

		when(addService.add(num1, num2)).thenReturn(expected);

		int actual = calcService.calc(num1, num2);

		assertEquals(expected, actual);

		/*
		 * 
		 * In the above example, we are testing CalcService. Mockito.mock() method is
		 * used to create a mock object of AddService class.
		 */
	}
}
