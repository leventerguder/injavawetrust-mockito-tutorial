package mockito.docs;

import static org.mockito.Mockito.*;

import java.util.LinkedList;

public class Test05StubbingWithException {

	public static void main(String[] args) {

		LinkedList<String> mockedList = mock(LinkedList.class);

		doThrow(new RuntimeException()).when(mockedList).clear();
		
		//following throws RuntimeException
		mockedList.clear();
	}
}
