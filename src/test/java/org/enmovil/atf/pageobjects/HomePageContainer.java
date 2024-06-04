package org.enmovil.atf.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageContainer {
	
	@FindBy(xpath="//img[@id='sidebar-toggle']")
	private WebElement sidebarToggle;
	
	@FindBy(xpath="//a[text()=\"Intransit Road\"]")
	private WebElement inTransitRoad;
	
	@FindBy(xpath="//a[@href='/sndtrucks'][normalize-space()='Active Trips']")
	private WebElement activeTrips;
	
	@FindBy(xpath="//a[@href='/deliveredtrips']")
	private WebElement deliveredTrips;
	
	@FindBy(xpath="//a[@href='/alltrips']")
	private WebElement allTrips;
	
	@FindBy(xpath="//a[@href='/returntoplant']")
	private WebElement returnToPlant;
	
	@FindBy(xpath="//a[@href='/allbatchtrips']")
	private WebElement allBatchTrips;
	
	@FindBy(xpath="//a[text()='Intransit Rail']")
	private WebElement inTransitRail;
	
	@FindBy(xpath="//a[@href='/rail-consignments/default'][normalize-space()='Active Trips']")
	private WebElement railActiveTrips;
	
	@FindBy(xpath="//a[@href='/allrailtrips']")
	private WebElement allRailTrips;
	
	@FindBy(xpath="//a[@href='/allbatchrailtrips']")
	private WebElement allBatchRailTrips;

	public WebElement getSidebarToggle() {
		return sidebarToggle;
	}

	public void setSidebarToggle(WebElement sidebarToggle) {
		this.sidebarToggle = sidebarToggle;
	}

	public WebElement getInTransitRoad() {
		return inTransitRoad;
	}

	public void setInTransitRoad(WebElement inTransitRoad) {
		this.inTransitRoad = inTransitRoad;
	}

	public WebElement getActiveTrips() {
		return activeTrips;
	}

	public void setActiveTrips(WebElement activeTrips) {
		this.activeTrips = activeTrips;
	}

	public WebElement getDeliveredTrips() {
		return deliveredTrips;
	}

	public void setDeliveredTrips(WebElement deliveredTrips) {
		this.deliveredTrips = deliveredTrips;
	}

	public WebElement getAllTrips() {
		return allTrips;
	}

	public void setAllTrips(WebElement allTrips) {
		this.allTrips = allTrips;
	}

	public WebElement getReturnToPlant() {
		return returnToPlant;
	}

	public void setReturnToPlant(WebElement returnToPlant) {
		this.returnToPlant = returnToPlant;
	}

	public WebElement getAllBatchTrips() {
		return allBatchTrips;
	}

	public void setAllBatchTrips(WebElement allBatchTrips) {
		this.allBatchTrips = allBatchTrips;
	}

	public WebElement getInTransitRail() {
		return inTransitRail;
	}

	public void setInTransitRail(WebElement inTransitRail) {
		this.inTransitRail = inTransitRail;
	}

	public WebElement getRailActiveTrips() {
		return railActiveTrips;
	}

	public void setRailActiveTrips(WebElement railActiveTrips) {
		this.railActiveTrips = railActiveTrips;
	}

	public WebElement getAllRailTrips() {
		return allRailTrips;
	}

	public void setAllRailTrips(WebElement allRailTrips) {
		this.allRailTrips = allRailTrips;
	}

	public WebElement getAllBatchRailTrips() {
		return allBatchRailTrips;
	}

	public void setAllBatchRailTrips(WebElement allBatchRailTrips) {
		this.allBatchRailTrips = allBatchRailTrips;
	}
	
	
	

}
