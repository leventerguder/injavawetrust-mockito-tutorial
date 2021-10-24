package mockito.docs;

import static org.mockito.Mockito.*;

public class Test03ArgumentMatchers2 {

	public static void main(String[] args) {

		/*
		 * If you are using argument matchers, ALL ARGUMENTS have to be provided by
		 * matchers.
		 */

		MyMock mock = mock(MyMock.class);

		// 0 -> anyInt OK
		// str -> anyString OK
		// third argument eq("third argument")

		mock.someMethod(0, "str", "third argument");

		// above is correct - eq() is also an argument matcher
		verify(mock).someMethod(anyInt(), anyString(), eq("third argument"));

		verify(mock).someMethod(anyInt(), anyString(), "third argument");
		// above is incorrect - exception will be thrown because third argument is given
		// without an argument matcher.

		/*
		 * Matcher methods like any(), eq() do not return matchers. Internally, they
		 * record a matcher on a stack and return a dummy value (usually null). This
		 * implementation is due to static type safety imposed by the java compiler. The
		 * consequence is that you cannot use any(), eq() methods outside of
		 * verified/stubbed method.
		 */
	}
}

class MyMock {
	public void someMethod(int i, String s, String string) {

	}
}