package mockito;


public class Notes {

	public static void main(String[] args) {

		/*
		 * https://www.journaldev.com/21816/mockito-tutorial
		 */

		// Mockito is a Java based mocking framework , used in conjuction with other
		// testing frameworks such as Junit and TestNG

		// It internally uses Java Reflection API and allows to create objects of a
		// service.
		// A mock object returns a dummy data and avoids external dependencies.
		// It simplifies the development of tests by mocking external dependencies and
		// apply the mocks into the code under test.

		// ### Mockito Mock Creation ###
		// The Mockito framework allows us to create mock objects using either @Mock
		// annotation or static mock() method.

		// we need to call MockitoAnnotations.initMocks(this); to initialize objects
		// annotated with @Mock, @Spy, @Captor, or @InjectMocks

		// ### Mockito Behavior Verification

		// To add a behavior to the mocked class when() and thenReturn() functions are
		// used.
		// It means that when the mock object (addService) is called for add method
		// with(num1, num2) parameters then it returns the value stored in the expected
		// variable.

		// ### Mockito Verify Interaction

		// Mockito framework keeps track of all the method calls and their parameters to
		// the mock object. Mockito verify() method on the mock object verifies that a
		// method is called with certain parameters. We can also specify the number of
		// invocation logic, such as the exact number of times, at least specified
		// number of times, less than the specified number of times, etc. We can use
		// VerificationModeFactory for number of invocation times logic.

		/*
		 * Mockito verify() method checks that a method is called with the right
		 * parameters. It does not check the result of a method call like assert method.
		 * The below example demonstrates the usage of verify() method:
		 * 
		 */

		// ### Mockito Stub Concrete Class
		// Using when() - thenReturn() function , we can stub a concrete/implementation
		// class and also a single element of a collection

		// The non-stubbed elements will contains null in them.

		// ### Mockito Spy

		/*
		 * When you call the method of a spied object, the real method will be called,
		 * unless a predefined behavior was defined. Using spy we can define behavior by
		 * using when() – theReturn() functions or can invoke real implementation.
		 * 
		 */

		/*
		 * Mockito is a popular mocking framework for Java unit testing. We can easily
		 * mock dependencies using Mockito. Mockito coding style is fluent and similar
		 * to JUnit and TestNG frameworks, so its learning curve is very small.
		 * 
		 */
	}
}
