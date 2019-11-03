package mockito.docs;

import static org.mockito.Mockito.*;

import java.util.LinkedList;
import java.util.List;

import org.mockito.InOrder;

public class Test06VerificationInOrder {

	public static void main(String[] args) {

		// A. Single mock whose methods must be invoked in a particular order

		LinkedList<String> singleMock = mock(LinkedList.class);

		//
		singleMock.add("was added first");
		singleMock.add("was added second");

		//
		InOrder inOrder = inOrder(singleMock);

		// following will make sure that add is first called with "was added first",
		// then with "was added second"
		inOrder.verify(singleMock).add("was added first");
		inOrder.verify(singleMock).add("was added second");

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
	}
}
