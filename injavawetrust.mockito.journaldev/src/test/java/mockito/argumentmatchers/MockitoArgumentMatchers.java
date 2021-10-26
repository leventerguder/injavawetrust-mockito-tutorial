package mockito.argumentmatchers;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.AdditionalMatchers.aryEq;
import static org.mockito.AdditionalMatchers.gt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.awt.List;

import org.junit.jupiter.api.Test;

public class MockitoArgumentMatchers {

	@Test
	public void testAny() {

		/*
		 * Let’s see some examples of using mockito argument matchers to stub generic
		 * behaviors.
		 */
		Foo mockFoo = mock(Foo.class);
		when(mockFoo.bool(anyString(), anyInt(), any(Object.class))).thenReturn(true);

		/*
		 * We are stubbing bool() method to return “true” for any string, integer and
		 * object arguments. All the below assertions will pass in this case:
		 */

		assertTrue(mockFoo.bool("A", 1, "A"));
		assertTrue(mockFoo.bool("B", 10, new Object()));

	}

	@Test
	public void testEq() {

		Foo mockFoo = mock(Foo.class);
		when(mockFoo.bool(eq("false"), anyInt(), any(Object.class))).thenReturn(false);
		assertFalse(mockFoo.bool("false", 10, new Object()));

		when(mockFoo.in(anyBoolean(), anyList())).thenReturn(10);

	}

	@Test
	public void testAdditionalMatchers() {

		Foo mockFoo = mock(Foo.class);
		when(mockFoo.bar(any(byte[].class), aryEq(new String[] { "A", "B" }), gt(10))).thenReturn(11);

		assertEquals(11, mockFoo.bar("abc".getBytes(), new String[] { "A", "B" }, 20));
		assertEquals(11, mockFoo.bar("xyz".getBytes(), new String[] { "A", "B" }, 99));
	}

	@Test
	public void testVerify() {

		Foo mockFoo = mock(Foo.class);
		
		mockFoo.bool("test", 0, List.class);
		mockFoo.bool("false", 10, List.class);
		
		verify(mockFoo, atLeast(1)).bool(anyString(), anyInt(), any(Object.class));
		verify(mockFoo, atLeast(1)).bool(eq("false"), anyInt(), any(Object.class));
	}

}
