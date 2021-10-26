package mockito.injectmocks;

public class EmailService implements Service {

	@Override
	public boolean send(String message) {
		System.out.println("Sending email");
		return true;
	}

}
