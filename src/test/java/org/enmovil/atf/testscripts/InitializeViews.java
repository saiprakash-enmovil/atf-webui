package org.enmovil.atf.testscripts;


import org.enmovil.atf.config.BrowserDriver;
import org.enmovil.atf.services.HomePageService;
import org.enmovil.atf.services.LoginPageService;
import org.openqa.selenium.WebDriver;



public class InitializeViews {
	
protected static WebDriver uiDriver = null;
	
	public static void init() {
		if(uiDriver == null) {
			uiDriver = BrowserDriver.getCurrentDriver();
		}
		LoginPageService.init();
		HomePageService.init();
	
	} 
}
