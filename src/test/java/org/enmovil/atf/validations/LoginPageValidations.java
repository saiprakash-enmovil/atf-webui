package org.enmovil.atf.validations;

import static org.junit.Assert.assertEquals;

import org.enmovil.atf.config.BrowserDriver;
import org.enmovil.atf.services.LoginPageService;

public class LoginPageValidations {
	
	LoginPageService loginPageService = new LoginPageService();
	
	
	public void validateURL() {
		
		BrowserDriver.wait(5);
		String currentUrl =	BrowserDriver.getCurrentDriver().getCurrentUrl();
		System.out.println(currentUrl);
		assertEquals(currentUrl, "https://am-autometrics.in/shipmenttrucks");
	}

}
