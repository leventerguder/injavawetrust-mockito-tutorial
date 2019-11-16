package verify;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;
import org.mockito.InOrder;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.atLeastOnce;

import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.never;

import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.verifyZeroInteractions;

import static org.mockito.Mockito.only;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.calls;

public class MockitoVerify {

	/*
	 * Mockito Verify methods are used to check that certain behavior happened. We
	 * can use Mockito verify methods at the end of the testing method code to make
	 * sure that specified methods are called.
	 */

	/*
	 * Mockito verify() method can be used to test number of method invocations too.
	 * We can test exact number of times, at least once, at least, at most number of
	 * invocation times for a mocked method.
	 * 
	 */

	/*
	 * 
	 * We can use verifyNoMoreInteractions() after all the verify() method calls to
	 * make sure everything is verified. If any method verification is still left,
	 * it will fail and provide proper message.
	 */

	/*
	 * verifyZeroInteractions() behavior is same as verifyNoMoreInteractions()
	 * method.
	 * 
	 */

	/*
	 * We can use inOrder() method to verify the order of method invocation. We can
	 * skip a method invocation but the methods being verified must be in the same
	 * order.
	 * 
	 * 
	 */

	@Test
	@SuppressWarnings("unchecked")
	public void test() {

		List<String> mockList = mock(List.class);
		mockList.add("injavawetrust");
		mockList.size();
		verify(mockList).add("injavawetrust");

	}

	@Test
	@SuppressWarnings("unchecked")
	public void test2() {
		/*
		 * If we want to make sure a method is called but we don’t care about the
		 * argument, then we can use ArgumentMatchers with verify method
		 */

		List<String> mockList = mock(List.class);
		mockList.add("injavawetrust");
		mockList.size();

		verify(mockList).add(anyString());
		verify(mockList).add(any(String.class));
	}

	@Test
	@SuppressWarnings("unchecked")
	public void test3() {
		/*
		 * Mockito verify() method is overloaded, the second one is verify(T mock,
		 * VerificationMode mode). We can use it to verify for the invocation count.
		 * 
		 */

		List<String> mockList = mock(List.class);

		System.out.println(mockList.size());

		verify(mockList, times(1)).size(); // same as normal verify method
		verify(mockList, atLeastOnce()).size(); // must be called at least once

		verify(mockList, atMost(2)).size(); // must be called at most 2 times
		verify(mockList, atLeast(1)).size(); // must be called at least once
		verify(mockList, never()).clear(); // must never be called
	}

	@Test
	@SuppressWarnings("unchecked")
	public void test4() {
		/*
		 * verifyNoMoreInteractions()
		 * 
		 * This method can be used after all the verify methods to make sure that all
		 * the interactions are verified. It will fail the test if there are any
		 * unverified interactions on the mocked object.
		 * 
		 */

		List<String> mockList = mock(List.class);

		// all interactions are verified, so below will pass
		verifyNoMoreInteractions(mockList);

		// mockList.isEmpty();
		// ifisEmpty() is activate, below will fail
		verifyNoMoreInteractions(mockList);
	}

	// verifyZeroInteractions()
	@SuppressWarnings({ "unchecked", "rawtypes", "deprecation" })
	@Test
	public void test5() {
		/*
		 * verifyZeroInteractions()
		 * 
		 * verifyZeroInteractions() method behavior is same as
		 * verifyNoMoreInteractions() method.
		 */

		List<String> mockList = mock(List.class);

		Map mockMap = mock(Map.class);
		Set mockSet = mock(Set.class);

		//verify(mockList).isEmpty();
		verifyZeroInteractions(mockList, mockMap, mockSet);

	}

	// Mockito verify only method call
	@SuppressWarnings({ "rawtypes" })
	@Test
	public void test6() {
		/*
		 * If we want to verify that only one method is being called, then we can use
		 * only() with verify method.
		 * 
		 */

		Map mockMap = mock(Map.class);
		mockMap.isEmpty();
		verify(mockMap, only()).isEmpty();
	}

	// Mockito Verify Order of Invocation
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	public void test7() {
		/*
		 * We can use InOrder to verify the order of invocation. We can skip any method
		 * to verify, but the methods being verified must be invoked in the same order.
		 */

		List<String> mockList = mock(List.class);
		Map mockMap = mock(Map.class);

		mockList.add("injavawetrust");
		mockList.size();
		mockList.isEmpty();
		
		mockMap.isEmpty();
		
		InOrder inOrder = inOrder(mockList, mockMap);
		inOrder.verify(mockList).add("injavawetrust");
		inOrder.verify(mockList, calls(1)).size();
		inOrder.verify(mockList).isEmpty();
		inOrder.verify(mockMap).isEmpty();
	}
}
