package mockito.docs;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class Test09MockAnnotation {

	public static void main(String[] args) {

		/*
		 * Shorthand for mocks creation - @Mock annotation
		 * 
		 * - Minimizes repetitive mock creation code.
		 * 
		 * - Makes the test class more readable.
		 * 
		 * - Makes the verification error easier to read because the field name is used
		 * to identify the mock
		 */

		ArticleManagerTest articleManagerTest = new ArticleManagerTest();

		// Deprecetad
		// MockitoAnnotations.initMocks(articleManagerTest);

		/*
		 * Initializes objects annotated with Mockito annotations for given
		 * testClass: @org.mockito.Mock, @Spy, @Captor, @InjectMocks
		 */
		MockitoAnnotations.openMocks(articleManagerTest);

		ArticleCalculator mockedCalculator = articleManagerTest.getCalculator();
		ArticleDatabase mockedDatabase = articleManagerTest.getDatabase();
		UserProvider mockedUserProvider = articleManagerTest.getUserProvider();

		articleManagerTest.setManager(new ArticleManager(mockedCalculator, mockedDatabase, mockedUserProvider));

		System.out.println(mockedCalculator + "" + mockedCalculator.getClass());
		System.out.println(mockedDatabase + "" + mockedDatabase.getClass());
		System.out.println(mockedUserProvider + "" + mockedUserProvider.getClass());

		System.out.println(articleManagerTest.getManager());

	}
}

/*
 * ArticleManager needs ArticleCalculator , ArticleDatabase , UserProvider.
 */
class ArticleManagerTest {

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