package mockito.docs;

import static org.mockito.Mockito.*;

import java.util.LinkedList;
import java.util.List;

import org.mockito.InOrder;

public class Test06VerificationInOrder {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		// A. Single mock whose methods must be invoked in a particular order

		LinkedList<String> mockedList = mock(LinkedList.class);

		//
		mockedList.add("was added first");
		mockedList.add("was added second");

		//
		InOrder inOrder = inOrder(mockedList);

		// following will make sure that add is first called with "was added first",
		// then with "was added second"
		inOrder.verify(mockedList).add("was added first");
		inOrder.verify(mockedList).add("was added second");

		// B. Multiple mocks that must be used in a particular order

		List<String> firstMock = mock(List.class);
		List<String> secondMock = mock(List.class);

		// using mocks
		firstMock.add("was called first");
		secondMock.add("was called second");

		// create inOrder object passing any mocks that need to be verified in order

		InOrder inOrder2 = inOrder(firstMock, secondMock);

		// following will make sure that firstMock was called before secondMock
		inOrder2.verify(firstMock).add("was called first");
		inOrder2.verify(secondMock).add("was called second");

		/*
		 * Verification in order is flexible - you don't have to verify all interactions
		 * one-by-one but only those that you are interested in testing in order. Also,
		 * you can create an InOrder object passing only the mocks that are relevant for
		 * in-order verification.
		 */
	}
}
