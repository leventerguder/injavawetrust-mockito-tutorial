package mockito.docs;

import static org.mockito.Mockito.*;

import java.util.LinkedList;

public class Test08FindingRedundantInvocations {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		LinkedList<String> mockedList = mock(LinkedList.class);

		// using mocks
		mockedList.add("one");
		mockedList.add("two");

		verify(mockedList).add("one");
		// verify(mockedList).add("two");

		// following verification will fail
		verifyNoMoreInteractions(mockedList);
	}
}
