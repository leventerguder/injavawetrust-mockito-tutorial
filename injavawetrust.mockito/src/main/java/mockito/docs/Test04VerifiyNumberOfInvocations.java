package mockito.docs;

import static org.mockito.Mockito.*;

import java.util.LinkedList;

public class Test04VerifiyNumberOfInvocations {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		LinkedList<String> mockedList = mock(LinkedList.class);

		// using mock
		mockedList.add("once");

		mockedList.add("twice");
		mockedList.add("twice");

		mockedList.add("three times");
		mockedList.add("three times");
		mockedList.add("three times");

		// following two verifications work exactly the same - times(1) is used by
		// default

		// times(1) is the default. Therefore using times(1) explicitly can be omitted

		verify(mockedList).add("once");
		verify(mockedList, times(1)).add("once");

		// exact number of invocations verification
		verify(mockedList, times(2)).add("twice");
		verify(mockedList, times(3)).add("three times");

		// verification using never(). never() is an alias to times(0)
		verify(mockedList, never()).add("never happened");

		// verification using atLeast()/atMost()
		verify(mockedList, atMostOnce()).add("once");
		verify(mockedList, atLeastOnce()).add("three times");
		verify(mockedList, atLeast(2)).add("three times");
		verify(mockedList, atMost(5)).add("three times");
	}
}
