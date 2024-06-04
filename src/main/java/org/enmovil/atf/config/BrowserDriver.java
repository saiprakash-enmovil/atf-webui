package org.enmovil.atf.config;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BrowserDriver {
	private static WebDriver bDriver;
	private static int defaultTimeoutSeconds = 16;

	public static WebDriver getCurrentDriver(String browser) {
		if (bDriver == null) {
			try {
				bDriver = Browser.getBrowser(browser);
			} catch (UnreachableBrowserException ucb) {
				System.out.println("Check the driver file");
				ucb.printStackTrace();
			}
		}
		return bDriver;
	}

	public static WebDriver getCurrentDriver() {
		return getCurrentDriver(PropertyLoader.getBrowser());
	}

	public static WebElement waitForPageElement(WebElement elementToWaitFor, Integer waitTimeInSeconds) {
		WebDriverWait wait = null;
		try {
			if (waitTimeInSeconds == null) {
				waitTimeInSeconds = defaultTimeoutSeconds;
			}
			wait = new WebDriverWait(getCurrentDriver(), Duration.ofSeconds(waitTimeInSeconds));
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return wait.until(ExpectedConditions.visibilityOf(elementToWaitFor));
	}
	
	
	public static void wait(int time) {
		try { 
			for(int i =0; i <= time; i ++) {
				Thread.sleep(1000);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
		

	public static void selectDropDownItem(WebElement element, String item) {
		Select select = new Select(element);
		select.selectByVisibleText(item);
	}

	public static String takeScreenShot() {
		String newFileNamePath = null;
		try {
			File directory = new File(".");
			DateFormat dateFormat = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ssaa");
			Date date = new Date();
			newFileNamePath = directory.getCanonicalPath() + "\\ScreenShots\\" + dateFormat.format(date) + "_" + ".jpg";
			//File file = new File(newFileNamePath);
			File srcFile = ((TakesScreenshot) getCurrentDriver()).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(srcFile, new File(newFileNamePath));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Check the file");
		}
		return newFileNamePath;
	}
	
	public static void scrollDown() {
		JavascriptExecutor js = (JavascriptExecutor) getCurrentDriver();
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}
	
	public static void scrollHorizontal() {
		//JavascriptExecutor js = (JavascriptExecutor) getCurrentDriver();
		//js.executeScript("arguments[0].scrollIntoView(true);", element);
		//js.executeScript("document.getElementById('gvLocationHorizontalRail').scrollLeft += 250", "");
		Actions actions = new Actions(getCurrentDriver());
		actions.scrollByAmount(5000, 0).perform();
	}
	
	public static void doubleClick(WebElement webElement) {
		Actions action = new Actions(BrowserDriver.getCurrentDriver());
		//Double click on element
		WebElement ele = webElement;
		action.doubleClick(ele).perform();
	}
	
	public static void closeBrowser() {
		getCurrentDriver().quit();
	}

	@SafeVarargs
	public static void waitForPageElementLoad(ExpectedCondition<WebElement>... conditions) {
	    WebElement isLoaded = null;
	    Wait<WebDriver> wait = new FluentWait<>(getCurrentDriver())
	            .withTimeout(Duration.ofSeconds(35))
	            .ignoring(StaleElementReferenceException.class)
	            .pollingEvery(Duration.ofSeconds(2));
	    for (ExpectedCondition<WebElement> condition : conditions) {
	        isLoaded = wait.until(condition);
	        if (isLoaded == null) {
	            //Stop checking on first condition returning false.
	            break;
	        }
	    }
	    //return isLoaded;
	}
	
	@SafeVarargs
	public static Boolean waitForPageToLoad(ExpectedCondition<Boolean>... conditions) {
		Boolean isLoaded = false;
	    Wait<WebDriver> wait = new FluentWait<>(getCurrentDriver())
	            .withTimeout(Duration.ofSeconds(45))
	            .ignoring(StaleElementReferenceException.class)
	            .pollingEvery(Duration.ofSeconds(2));
	    for (ExpectedCondition<Boolean> condition : conditions) {
	        isLoaded = wait.until(condition);
	        if (isLoaded == false) {
	            //Stop checking on first condition returning false.
	            break;
	        }
	    }
	    return isLoaded;
	}
	
	public static Boolean waitForPageToLoad() {
		return waitForPageToLoad(EXPECT_DOC_READY_STATE);
	}
	/**
	 * Returns 'true' if the value of the 'window.document.readyState' via
	 * JavaScript is 'complete'
	 */
	public static final ExpectedCondition<Boolean> EXPECT_DOC_READY_STATE = new ExpectedCondition<Boolean>() {
	    @Override
	    public Boolean apply(WebDriver bdriver) {
	        String script = "if (typeof window != 'undefined' && window.document) { return window.document.readyState; } else { return 'notready'; }";
	        Boolean result;
	        try {
	            result = ((JavascriptExecutor) bdriver).executeScript(script).equals("complete");
	        } catch (Exception ex) {
	            result = Boolean.FALSE;
	        }
	        return result;
	    }
	};
	/**
	 * Returns 'true' if there is no 'wait_dialog' element present on the page.
	 */
	public static final ExpectedCondition<Boolean> EXPECT_NOT_WAITING = new ExpectedCondition<Boolean>() {
	    @Override
	    public Boolean apply(WebDriver bdriver) {
	        Boolean loaded = true;
	        try {
	            WebElement wait = getCurrentDriver().findElement(By.id("F"));
	            if (wait.isDisplayed()) {
	                loaded = false;
	            }
	        } catch (StaleElementReferenceException serex) {
	            loaded = false;
	        } catch (NoSuchElementException nseex) {
	            loaded = true;
	        } catch (Exception ex) {
	            loaded = false;
	            System.out.println("EXPECTED_NOT_WAITING: UNEXPECTED EXCEPTION: " + ex.getMessage());
	        }
	        return loaded;
	    }
	};
	/**
	 * Returns true if there are no elements with the 'spinner' class name.
	 */
	public static final ExpectedCondition<Boolean> EXPECT_NO_SPINNERS = new ExpectedCondition<Boolean>() {
	    @Override
	    public Boolean apply(WebDriver bDriver) {
	        Boolean loaded = true;
	        try {
	        List<WebElement> spinners = bDriver.findElements(By.className("spinner"));
	        for (WebElement spinner : spinners) {
	            if (spinner.isDisplayed()) {
	                loaded = false;
	                break;
	            }
	        }
	        }catch (Exception ex) {
	            loaded = false;
	        }
	        return loaded;
	    } 
	};
	
	public static void horizontalScroll(Integer waitTimeInSeconds) {
		//JavascriptExecutor js = (JavascriptExecutor) getCurrentDriver();
		//js.executeScript("arguments[0].scrollIntoView()", problematicElement);
		WebElement myElement = (new WebDriverWait(getCurrentDriver(), Duration.ofSeconds(waitTimeInSeconds)))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='Mark Delivered']")));
        myElement.click();
        Actions move = new Actions(getCurrentDriver());
        move.moveToElement(myElement).clickAndHold();
        move.moveByOffset(125,0);
        move.release();
        move.perform();
	}
}
