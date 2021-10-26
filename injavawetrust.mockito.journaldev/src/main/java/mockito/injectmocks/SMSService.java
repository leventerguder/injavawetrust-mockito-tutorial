package mockito.injectmocks;

public class SMSService implements Service {

	@Override
	public boolean send(String message) {
		System.out.println("Sending SMS");
		return true;
	}

}
