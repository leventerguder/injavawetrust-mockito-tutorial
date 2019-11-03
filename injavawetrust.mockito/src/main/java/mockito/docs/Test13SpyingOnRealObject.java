package mockito.docs;

import java.util.LinkedList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.doReturn;

public class Test13SpyingOnRealObject {

	public static void main(String[] args) {

		// You can create spies of real objects. When you use the spy then the real
		// methods are called (unless a method was stubbed).
		// Real spies should be used carefully and occasionally, for example when
		// dealing with legacy code.

		List<String> list = new LinkedList<>();
		List<String> spy = spy(list);

		// optionally, you can stub out some methods:
		when(spy.size()).thenReturn(100);

		// using the spy calls *real* methods
		spy.add("one");
		spy.add("two");

		// prints "one" - the first element of a list
		System.out.println(spy.get(0));

		// size() method was stubbed - 100 is printed
		System.out.println(spy.size());

		// optionally, you can verify
		verify(spy).add("one");
		verify(spy).add("two");

		// Sometimes it's impossible or impractical to use when(Object) for stubbing
		// spies. Therefore when using spies please consider doReturn|Answer|Throw()
		// family of methods for stubbing

		List<String> list2 = new LinkedList<>();
		List<String> spy2 = spy(list2);

		// Impossible: real method is called so spy.get(0) throws
		// IndexOutOfBoundsException (the list is yet empty)

		try {
			when(spy2.get(0)).thenReturn("foo");

		} catch (Exception e) {
		}
		// You have to use doReturn() for stubbing

		System.out.println(doReturn("foo").when(spy2).get(0));

		/*
		 * Mockito *does not* delegate calls to the passed real instance, instead it
		 * actually creates a copy of it. So if you keep the real instance and interact
		 * with it, don't expect the spied to be aware of those interaction and their
		 * effect on real instance state.
		 * 
		 */

		/*
		 * Watch out for final methods. Mockito doesn't mock final methods so the bottom
		 * line is: when you spy on real objects + you try to stub a final method =
		 * trouble. Also you won't be able to verify those method as well.
		 * 
		 */

	}
}
