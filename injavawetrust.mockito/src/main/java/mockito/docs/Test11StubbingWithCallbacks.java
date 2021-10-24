package mockito.docs;

import static org.mockito.Mockito.*;

import java.util.Arrays;

import org.mockito.stubbing.Answer;

import org.mockito.invocation.InvocationOnMock;

public class Test11StubbingWithCallbacks {

	/*
	 * Allows stubbing with generic Answer interface.
	 * 
	 * Yet another controversial feature which was not included in Mockito
	 * originally.
	 * 
	 * We recommend simply stubbing with thenReturn() or thenThrow(), which should
	 * be enough to test/test-drive any clean & simple code. However, if you do have
	 * a need to stub with the generic Answer interface, here is an example:
	 * 
	 */

	public static void main(String[] args) {

		MockMe2 mock = mock(MockMe2.class);

		when(mock.someMethod(anyString())).thenAnswer(new Answer<String>() {
			public String answer(InvocationOnMock invocation) {
				Object[] args = invocation.getArguments();
				Object mock = invocation.getMock();
				System.out.println(mock.getClass());
				return "test value, called with arguments: " + Arrays.toString(args);
			}
		});

		// Following prints "called with arguments: [foo]"
		System.out.println(mock.someMethod("foo"));
	}
}

class MockMe2 {
	public String someMethod(String str) {
		return "test method";
	}
}
