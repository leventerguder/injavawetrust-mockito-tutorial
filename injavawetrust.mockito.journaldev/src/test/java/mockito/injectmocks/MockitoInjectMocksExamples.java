package mockito.injectmocks;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class MockitoInjectMocksExamples {

	@BeforeEach
	void init_mocks() {
		// If you won’t call MockitoAnnotations.openMocks(this); then you will get
		// NullPointerException.
		MockitoAnnotations.openMocks(this);
	}

	@Mock
	EmailService emailService;

	@Mock
	SMSService smsService;

	@InjectMocks
	AppServicesConstructorBased appServicesConstructorInjectionMock;

	@InjectMocks
	AppServicesSetterBased appServicesSetterInjectionMock;

	@InjectMocks
	AppServicesFieldBased appServicesFieldInjectionMock;

	@Test
	void test_constructor_injection_mock() {

		when(appServicesConstructorInjectionMock.sendEmail("Email")).thenReturn(true);
		when(appServicesConstructorInjectionMock.sendSMS(anyString())).thenReturn(true);

		assertTrue(appServicesConstructorInjectionMock.sendEmail("Email"));
		assertFalse(appServicesConstructorInjectionMock.sendEmail("Unstubbed Email"));

		assertTrue(appServicesConstructorInjectionMock.sendSMS("SMS"));

	}

	@Test
	void test_setter_injection_mock() {

		when(appServicesSetterInjectionMock.sendEmail("New Email")).thenReturn(true);
		when(appServicesSetterInjectionMock.sendSMS(anyString())).thenReturn(true);

		assertTrue(appServicesSetterInjectionMock.sendEmail("New Email"));
		assertFalse(appServicesSetterInjectionMock.sendEmail("Unstubbed Email"));

		assertTrue(appServicesSetterInjectionMock.sendSMS("SMS"));

	}

	@Test
	void test_field_injection_mock() {

		when(appServicesFieldInjectionMock.sendEmail(anyString())).thenReturn(true);
		when(appServicesFieldInjectionMock.sendSMS(anyString())).thenReturn(true);

		assertTrue(appServicesFieldInjectionMock.sendEmail("Email"));
		assertTrue(appServicesFieldInjectionMock.sendEmail("New Email"));

		assertTrue(appServicesFieldInjectionMock.sendSMS("SMS"));

	}

}
