package mockito.docs;

import static org.mockito.Mockito.*;

import java.util.List;

public class Test01 {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		/*
		 * 1. Let's verify some behaviour! The following examples mock a List, because
		 * most people are familiar with the interface (such as the add(), get(),
		 * clear() methods). In reality, please don't mock the List class. Use a real
		 * instance instead.
		 * 
		 */

		// mock creation
		List<String> mockedList = mock(List.class);

		// using mock object
		mockedList.add("one");
		mockedList.clear();

		// verification
		verify(mockedList).add("one");
		verify(mockedList).clear();

		/*
		 * Once created, a mock will remember all interactions. Then you can selectively
		 * verify whatever interactions you are interested in.
		 * 
		 */
	}
}
