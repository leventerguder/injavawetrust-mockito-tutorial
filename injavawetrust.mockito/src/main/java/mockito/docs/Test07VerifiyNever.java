package mockito.docs;

import static org.mockito.Mockito.*;

import java.util.LinkedList;

public class Test07VerifiyNever {

	// making sure interaction(s) never happened on mock

	public static void main(String[] args) {

		LinkedList<String> mockedList = mock(LinkedList.class);
		LinkedList<String> mockedList2 = mock(LinkedList.class);
		LinkedList<String> mockedList3 = mock(LinkedList.class);

		mockedList.add("one");

		verify(mockedList).add("one");

		// verify that method never called on a mock
		verify(mockedList, never()).add("two");
		
		//verify that othet mocks were not interacted

		verifyZeroInteractions(mockedList2, mockedList3);
		verifyNoMoreInteractions(mockedList2, mockedList3);
	}
}
