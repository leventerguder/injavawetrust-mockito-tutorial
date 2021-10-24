package mockito.docs;

import static org.mockito.Mockito.*;

import java.util.LinkedList;

public class Test03ArgumentMatchers {

	/*
	 * Mockito verifies argument values in natural java style : by using an equals
	 * method. Sometimes , when extra flexibility is required then you might use
	 * argument matchers
	 */

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		LinkedList<String> mockedList = mock(LinkedList.class);

		// ArgumentMatchers # anyInt
		// stubbing using built-in anyInt() argument matcher
		when(mockedList.get(anyInt())).thenReturn("element");

		// following prints "element"
		System.out.println(mockedList.get(999));

		// you can also verify using an argument matcher
		verify(mockedList).get(anyInt());

		mockedList.add("123456");
		// argument matchers can also be written as Java 8 Lambdas
		verify(mockedList).add(argThat(someString -> someString.length() > 5));

		/*
		 * 
		 * Argument matchers allow flexible verification or stubbing.
		 * 
		 * Be reasonable with using complicated argument matching. The natural matching
		 * style using equals() with occasional anyX() matchers tend to give clean &
		 * simple tests. Sometimes it's just better to refactor the code to allow
		 * equals() matching or even implement equals() method to help out with testing.
		 * 
		 */


	}
}
