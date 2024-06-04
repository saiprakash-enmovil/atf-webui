package org.enmovil.atf.services;

import org.apache.log4j.Logger;
import org.enmovil.atf.config.BrowserDriver;
import org.enmovil.atf.pageobjects.LoginPageContainer;
import org.openqa.selenium.support.PageFactory;

public class LoginPageService {
	
	public static LoginPageContainer loginPageContainer;
	private static Logger log = Logger.getLogger(LoginPageService.class);
	
	public LoginPageService loginToAMNSApplication(String uname, String password) {
		try {
			BrowserDriver.waitForPageToLoad();
			loginPageContainer.getUserID().sendKeys(uname);
			loginPageContainer.getUserPassword().sendKeys(password);
			BrowserDriver.wait(2);
			loginPageContainer.getLoginButton().click();
			log.info("User logged in successfully.");
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return this;
	}
	public static void init() {
		loginPageContainer = PageFactory.initElements(BrowserDriver.getCurrentDriver(), LoginPageContainer.class);
	}

}
