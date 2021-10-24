package mockito.docs;

import static org.mockito.Mockito.*;

public class Test10StubbingConsecutiveCalls {

	/*
	 * Sometimes we need to stub with different return value/exception for the same
	 * method call. Typical use case could be mocking iterators.
	 * 
	 * Original version of Mockito did not have this feature to promote simple
	 * mocking. For example, instead of iterators one could use Iterable or simply
	 * collections.
	 * 
	 * Those offer natural ways of stubbing (e.g. using real collections). In rare
	 * scenarios stubbing consecutive calls could be useful, though:
	 */
	public static void main(String[] args) {

		MockMe mocked = mock(MockMe.class);

		when(mocked.someMethod("some arg")).thenThrow(new RuntimeException()).thenReturn("foo");

		try {
			// First call: throws runtime exception:
			System.out.println(mocked.someMethod("some arg"));
		} catch (RuntimeException e) {
			e.printStackTrace();
		}

		// Second call: prints "foo"
		System.out.println(mocked.someMethod("some arg"));

		// Any consecutive call: prints "foo" as well (last stubbing wins).
		System.out.println(mocked.someMethod("some arg"));

		// Alternative, shorter version of consecutive stubbing:
		when(mocked.someMethod("some arg")).thenReturn("one", "two", "three");

		System.out.println(mocked.someMethod("some arg")); // one
		System.out.println(mocked.someMethod("some arg")); // two
		System.out.println(mocked.someMethod("some arg")); // three
		System.out.println(mocked.someMethod("some arg")); // three
		System.out.println(mocked.someMethod("some arg")); // three

		// if instead of chaining .thenReturn() calls, multiple stubbing with the same
		// matchers or arguments is used, then each stubbing will override the previous
		// one:

		when(mocked.someMethod("some arg")).thenReturn("new-value");
		when(mocked.someMethod("some arg")).thenReturn("overridden-value");

		System.out.println(mocked.someMethod("some arg")); // overridden-value

	}
}

class MockMe {

	public String someMethod(String arg) {
		return "test";
	}
}