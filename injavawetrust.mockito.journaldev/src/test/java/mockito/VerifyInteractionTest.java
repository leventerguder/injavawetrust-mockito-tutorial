package mockito;

import static org.mockito.Mockito.verify;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.internal.verification.VerificationModeFactory;

public class VerifyInteractionTest {

	@Test
	@SuppressWarnings("unchecked")
	public void testMethod() {

		List<String> mockedList = Mockito.mock(List.class);

		mockedList.add("first-element");
		mockedList.add("second-element");
		mockedList.add("third-element");
		mockedList.add("third-element");
		mockedList.clear();

		/*
		 * Mockito verify() method checks that a method is called with the right
		 * parameters. It does not check the result of a method call like assert method
		 */
		verify(mockedList).add("first-element");
		verify(mockedList).add("second-element");
		verify(mockedList, VerificationModeFactory.times(2)).add("third-element");

		verify(mockedList).clear();

	}
}
