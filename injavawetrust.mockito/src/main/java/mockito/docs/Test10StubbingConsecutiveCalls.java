package mockito.docs;

import static org.mockito.Mockito.*;

import org.mockito.Mock;

public class Test10StubbingConsecutiveCalls {

	public static void main(String[] args) {

		MockMe mocked = mock(MockMe.class);

		when(mocked.someMethod("some arg"))
				.thenThrow(new RuntimeException())
				.thenReturn("foo");

		try {
			// First call: throws runtime exception:
			System.out.println(mocked.someMethod("some arg"));
		} catch (Exception e) {
		}

		// Second call: prints "foo"
		System.out.println(mocked.someMethod("some arg"));

		// Any consecutive call: prints "foo" as well (last stubbing wins).
		System.out.println(mocked.someMethod("some arg"));

		// Alternative, shorter version of consecutive stubbing:
		when(mocked.someMethod("some arg"))
				.thenReturn("one", "two", "three");
		
		
		System.out.println(mocked.someMethod("some arg")); // one
		System.out.println(mocked.someMethod("some arg")); // two
		System.out.println(mocked.someMethod("some arg")); // three
		
		//  if instead of chaining .thenReturn() calls, multiple stubbing with the same matchers or arguments is used, then each stubbing will override the previous one:

		//All mock.someMethod("some arg") calls will return "two"
		 when(mocked.someMethod("some arg"))
		   .thenReturn("one");
		 when(mocked.someMethod("some arg"))
		   .thenReturn("two");
		 
	}
}

class MockMe {

	public String someMethod(String arg) {
		return "test";
	}
}