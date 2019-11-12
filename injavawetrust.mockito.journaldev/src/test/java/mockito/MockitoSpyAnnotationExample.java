package mockito;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class MockitoSpyAnnotationExample {

	@Spy
	Utils mockUtils;

	@Before
	public void setuo() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void setup() {
		when(mockUtils.process(1, 4)).thenReturn(5);

		// //mocked method
		assertEquals(5, mockUtils.process(1, 4));

		//
		// real method called since it's not stubbed
		assertEquals(20, mockUtils.process(19, 1));
	}

	/*
	 * 
	 * Note that the @Spy annotation tries to call the no-args constructor to
	 * initialized the mocked object. If your class doesn’t have it then you will
	 * get the following error.
	 */

	/*
	 * Also, note that Mockito cannot instantiate inner classes, local classes,
	 * abstract classes, and interfaces. So it’s always a good idea to provide an
	 * instance to spy on. Otherwise real methods might not get called and silently
	 * ignored. For example, if you specify a spy object as below:
	 * 
	 */

	/*
	 * 
	 * @Spy List<String> spyList;
	 * 
	 * You will notice that when you call add() or get() methods, real methods are
	 * not getting called. If you specify the spy object like below, then everything
	 * will work fine.
	 * 
	 * 
	 * @Spy List<String> spyList = new ArrayList<>();
	 */

}

class Utils {
	public int process(int x, int y) {
		System.out.println("Input Params = " + x + "," + y);
		return x + y;
	}
}