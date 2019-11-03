package mockito.docs;

import static org.mockito.Mockito.mock;

import org.mockito.Mockito;
import org.mockito.stubbing.Answer;

public class Test14ChangingReturnValues {

	/*
	 * 14. Changing default return values of unstubbed invocations (Since 1.7) You
	 * can create a mock with specified strategy for its return values. It's quite
	 * an advanced feature and typically you don't need it to write decent tests.
	 * However, it can be helpful for working with legacy systems.
	 * 
	 */

	public static void main(String[] args) {

		Foo mock = mock(Foo.class, Mockito.RETURNS_SMART_NULLS);

		System.out.println(mock);

	}
}

class Foo {

}