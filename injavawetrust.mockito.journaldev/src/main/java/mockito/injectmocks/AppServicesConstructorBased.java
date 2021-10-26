package mockito.injectmocks;

public class AppServicesConstructorBased {

	private EmailService emailService;
	private SMSService smsService;

	public AppServicesConstructorBased(EmailService emailService, SMSService smsService) {
		this.emailService = emailService;
		this.smsService = smsService;
	}

	public boolean sendSMS(String msg) {
		return smsService.send(msg);
	}

	public boolean sendEmail(String msg) {
		return emailService.send(msg);
	}
}
