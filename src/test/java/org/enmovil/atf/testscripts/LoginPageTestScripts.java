package org.enmovil.atf.testscripts;

import org.enmovil.atf.config.BrowserDriver;
import org.enmovil.atf.config.PropertyLoader;
import org.enmovil.atf.data.DataConfig;
import org.enmovil.atf.data.LoginData;
import org.enmovil.atf.services.HomePageService;
import org.enmovil.atf.services.LoginPageService;
import org.enmovil.atf.util.BaseListener;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginPageTestScripts extends BaseListener {
	
	LoginPageService loginService = null;
	LoginData logindata = null;
	HomePageService homePageService = null;
	
	@BeforeClass
	public void init() {
		
		loginService = new LoginPageService();
		homePageService = new HomePageService();
		logindata = new DataConfig().getLoginData();
		InitializeViews.init();
		logger = extent.createTest("AMNS:: Login Verification");
		BrowserDriver.getCurrentDriver().navigate().to(PropertyLoader.getAMNSUrl());
		loginService.loginToAMNSApplication(logindata.getUserName(), logindata.getPassWord());
	}
	
	@Test(description="Open Side Menu list in AMNS Application and navigate",priority=0)
	public void sideMenuList() {
		homePageService.navigateToActiveTrips();
	}
}
