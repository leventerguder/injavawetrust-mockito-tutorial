# Mockito

Mockito is a java based mocking framework, used in conjunction with other testing frameworks such as JUnit and TestNG.

It internally uses Java Reflection API and allows to create objects of a service. A mock object returns a dummy data and avoids external dependencies. 
It simplifies the development of tests by mocking external dependencies and apply the mocks into the code under test.


Mockito is a popular mocking framework for Java unit testing. We can easily mock dependencies using Mockito. Mockito coding style is fluent and similar to JUnit and TestNG frameworks, so its learning curve is very small.


## Mockito Mock Creation

The Mockito framework allows us to create mock objects using either @Mock annotation or mock() static method.

## Mockito Behavior Verification

To add a behavior to the mocked class when() and thenReturn() functions are used. It means that when the mock object (addService) is called for add method with (num1, num2) parameters, then it returns the value stored in the expected variable.

## Mockito Verify Interaction

Mockito framework keeps track of all the method calls and their parameters to mock object.
Mockito verify() method on the mock object verifies that a method is called with certain parameters.
We can also specify the number of invocation logic, such as the exact number of times, at least specified number of times, less than the specified number of times etc. We can use VerificationModeFactory for number of invocation times logic.

Mockito verify() method checks that a method is called with the right parameters. It does not check the result of a method call like assert method.


Mockito Verify methods are used to check that certain behavior happened. We can use Mockito verify methods at the end of the testing method code to make sure that specified methods are called.

- Mockito verify() method can be used to test number of method invocations too. We can test exact number of times, at least once, at least, at most number of invocation times for a mocked method.

- We can use verifyNoMoreInteractions() after all the verify() method calls to make sure everything is verified. If any method verification is still left, it will fail and provide proper message.

- verifyZeroInteractions() behavior is same as verifyNoMoreInteractions() method.

- We can use inOrder() method to verify the order of method invocation. We can skip a method invocation but the methods being verified must be in the same order

Mockito verify() method is overloaded, the second one is verify(T mock, VerificationMode mode). We can use it to verify for the invocation count.


## Mockito Stub Concrete Class

Using when() – thenReturn() function, we can stub a concrete/implementation class and also a single element of a collection. The non-stubbed elements will contains null in them.


## Mockito Spy

We can use Mockito Spy to partial mock an object. When we spy on an object, the real methods are being called unless it’s stubbed.

When you call the method of a spied object, the real method will be called, unless a predefined behavior was defined. Using spy we can define behavior by using when() – theReturn() functions or can invoke real implementation.

We can create mockito spy objects using two ways.

- Mockito.spy() method
- Mockito @Spy Annotation


## Mockito Mock

Mockito mocking framework provides different ways to mock a class. Let’s look at different methods through which we can mock a class and stub its behaviors.

### Mockito mock method

We can use Mockito class mock() method to create a mock object of a given class or interface.
This is the simplest way to mock an object.


### Mockito @Mock Annotation

We can mock an object using @Mock annotation too. It’s useful when we want to use the mocked object at multiple places because we avoid calling mock() method multiple times. The code becomes more readable and we can specify mock object name that will be useful in case of errors.

### Mockito @InjectMocks Annotation

When we want to inject a mocked object into another mocked object, we can use @InjectMocks annotation. @InjectMock creates the mock object of the class and injects the mocks that are marked with the annotations @Mock into it.


Mockito @InjectMocks annotations allow us to inject mocked dependencies in the annotated class mocked object. This is useful when we have external dependencies in the class we want to mock. We can specify the mock objects to be injected using @Mock or @Spy annotations.

Mockito tries to inject mocked dependencies using one of the three approaches, in the specified order.


- Constructor Based Injection – when there is a constructor defined for the class, Mockito tries to inject dependencies using the biggest constructor.

- Setter Methods Based Injection – when there are no constructors defined, Mockito tries to inject dependencies using setter methods.

- Field Based Injection – if there are no constructors or field-based injection possible, then mockito tries to inject dependencies into the field itself.


If there is only one matching mock object, then mockito will inject that into the object. If there is more than one mocked object of the same class, then mock object name is used to inject the dependencies.


### Mockito spy() for partial mocking

If we want to mock only specific behaviors and call the real methods for unstubbed behaviors, then we can create a spy object using Mockito spy() method.

### Mockito @Spy Annotation

We can use @Spy annotation to spy on an object.
Note that the @Spy annotation tries to call the no-args constructor to initialized the mocked object. If your class doesn’t have it then you will get the following error.


## Mockito Stub Exception – JUnit 5

Sometimes our methods throw exceptions and we want to mock the object and test the exceptions.
We can use Mockito mock objects with when() and thenThrow() to mock this scenario.


## Mockito Argument Matchers

Mockito allows us to create mock objects and stub the behavior for our test cases. We usually mock the behavior using when() and thenReturn() on the mock object.


### Mockito Argument Matchers  - any()

Sometimes we want to mock the behavior for any argument of the given type, in that case, we can use Mockito argument matchers. Mockito argument methods are defined in org.mockito.ArgumentMatchers class as static methods.

