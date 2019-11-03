package mockito.docs;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class Test09MockAnnotation {

	public static void main(String[] args) {

		InitializeMock initializeMock = new InitializeMock();
		MockitoAnnotations.initMocks(initializeMock);
		// MockitoAnnotations.initMocks(this); initializes fields annotated with Mockito
		// annotations.

		// Initializes objects annotated with Mockito annotations for given testClass:
		// @Mock, @Spy, @Captor, @InjectMocks

		// Allows shorthand creation of objects required for testing.
		// Minimizes repetitive mock creation code.
		// Makes the test class more readable.
		// Makes the verification error easier to read because field name is used to
		// identify the mock

		initializeMock.setManager(new ArticleManager(initializeMock.getCalculator(), initializeMock.getDatabase(),
				initializeMock.getUserProvider()));

		System.out.println(initializeMock.getCalculator());

		System.out.println(initializeMock.getDatabase());
		System.out.println(initializeMock.getUserProvider());
		System.out.println(initializeMock.getManager());
	}
}

class InitializeMock {
	@Mock
	private ArticleCalculator calculator;
	@Mock
	private ArticleDatabase database;

	@Mock
	private UserProvider userProvider;

	private ArticleManager manager;

	public ArticleCalculator getCalculator() {
		return calculator;
	}

	public void setCalculator(ArticleCalculator calculator) {
		this.calculator = calculator;
	}

	public ArticleDatabase getDatabase() {
		return database;
	}

	public void setDatabase(ArticleDatabase database) {
		this.database = database;
	}

	public UserProvider getUserProvider() {
		return userProvider;
	}

	public void setUserProvider(UserProvider userProvider) {
		this.userProvider = userProvider;
	}

	public ArticleManager getManager() {
		return manager;
	}

	public void setManager(ArticleManager manager) {
		this.manager = manager;
	}

}

class ArticleManager {
	private ArticleCalculator calculator;
	private ArticleDatabase database;
	private UserProvider userProvider;

	public ArticleManager(ArticleCalculator calculator, ArticleDatabase database, UserProvider userProvider) {
		super();
		this.calculator = calculator;
		this.database = database;
		this.userProvider = userProvider;
	}

	public ArticleCalculator getCalculator() {
		return calculator;
	}

	public void setCalculator(ArticleCalculator calculator) {
		this.calculator = calculator;
	}

	public ArticleDatabase getDatabase() {
		return database;
	}

	public void setDatabase(ArticleDatabase database) {
		this.database = database;
	}

	public UserProvider getUserProvider() {
		return userProvider;
	}

	public void setUserProvider(UserProvider userProvider) {
		this.userProvider = userProvider;
	}

}

class ArticleCalculator {

	int sum(int a, int b) {
		return a + b;
	}
}

class ArticleDatabase {

}

class UserProvider {

}