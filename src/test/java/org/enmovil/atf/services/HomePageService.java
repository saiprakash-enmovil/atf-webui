package org.enmovil.atf.services;

import org.apache.log4j.Logger;
import org.enmovil.atf.config.BrowserDriver;
import org.enmovil.atf.pageobjects.HomePageContainer;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePageService {
	
	public static HomePageContainer homePageContainer;
	private static Logger log = Logger.getLogger(HomePageService.class);
	
	public HomePageService navigateToActiveTrips() {
	
			BrowserDriver.wait(5);
			homePageContainer.getSidebarToggle().click();
			homePageContainer.getInTransitRoad().click();
			homePageContainer.getActiveTrips().click();
		
		return this;
		
	}
	public static void init() {
		homePageContainer = PageFactory.initElements(BrowserDriver.getCurrentDriver(), HomePageContainer.class);
	}

}
