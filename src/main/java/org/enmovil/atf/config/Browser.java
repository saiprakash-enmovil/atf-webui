package org.enmovil.atf.config;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Browser {
	
	public static WebDriver uiDriver;
	
   
	public static WebDriver getBrowser(String browser) {
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", PropertyLoader.getChromePath());
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			options.addArguments("--no-sandbox");
			options.addArguments("--disable-dev-shm-usage");
			//options.addArguments("--disable-web-security");
			//options.addArguments("--allow-file-access-from-files");
			uiDriver = new ChromeDriver(options);
		}
		
		else if(browser.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", PropertyLoader.getEdgePath());
			uiDriver = new EdgeDriver();
		}
		
		else if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", PropertyLoader.getFirefoxPath());
			FirefoxOptions options = new FirefoxOptions();
			options.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
			uiDriver = new FirefoxDriver(options);
		}
		
		uiDriver.manage().window().maximize();
		uiDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(26));
		return uiDriver; 
		
	}

}
