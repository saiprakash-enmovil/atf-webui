package org.enmovil.atf.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageContainer {
	
	@FindBy(xpath="//input[@name='email']")
	private WebElement userID;
	
	@FindBy(xpath="//input[@name='password']")
	private WebElement userPassword;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement loginButton;

	public WebElement getUserID() {
		return userID;
	}

	public void setUserID(WebElement userID) {
		this.userID = userID;
	}

	public WebElement getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(WebElement userPassword) {
		this.userPassword = userPassword;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}

	public void setLoginButton(WebElement loginButton) {
		this.loginButton = loginButton;
	}

	
}
