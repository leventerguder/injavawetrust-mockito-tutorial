package mockito.docs;

import static org.mockito.Mockito.*;

import java.util.LinkedList;

public class Test08FindingRedundantInvocations {

	public static void main(String[] args) {

		LinkedList<String> mockedList = mock(LinkedList.class);

		mockedList.add("one");
		mockedList.add("two");

		verify(mockedList).add("one");

		//following verification will fail
		verifyNoMoreInteractions(mockedList);
	}
}
