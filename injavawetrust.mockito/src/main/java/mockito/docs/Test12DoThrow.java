package mockito.docs;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.doThrow;

import java.util.LinkedList;

public class Test12DoThrow {

	public static void main(String[] args) {

		// doReturn()|doThrow()| doAnswer()|doNothing()|doCallRealMethod() family of
		// methods

		LinkedList<String> mockedList = mock(LinkedList.class);

		doThrow(new RuntimeException()).when(mockedList).clear();

		// following throws RuntimeException

		mockedList.clear();

		// You can use doThrow , doAnswer , doNothing , doReturn , doCallRealMethod in
		// place in the corresponding call with when()
		// for any method. It is necessary when you
		
		// - stub void methods
		// - stub methods on spy objects 
		// stub the same method more than once, to change the behaviour of a mock in the middle of a test
	}
}
