package mockito.argumentmatchers;

import java.util.List;

public class Foo {

	boolean bool(String str, int i, Object obj) {
		return false;
	}

	int in(boolean b, List<String> strs) {
		return 0;
	}

	int bar(byte[] bytes, String[] s, int i) {
		return 0;
	}
	
}
