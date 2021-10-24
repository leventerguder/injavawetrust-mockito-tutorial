package mockito.docs;

import static org.mockito.Mockito.*;

import java.util.LinkedList;

public class Test07VerifiyNever {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		LinkedList<String> mockedList = mock(LinkedList.class);

		// using mocks - only mockOne is interacted
		mockedList.add("one");

		// ordinary verification
		verify(mockedList).add("one");

		// verify that method never called on a mock
		verify(mockedList, never()).add("two");

	}
}