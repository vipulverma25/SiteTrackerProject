package pageObject;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.test.sitetracker.ExcelManager;

public class HomePage {

	public static final String COMPONENT_REFERENCE = "//a[@title='Component Reference']";
	public static final String COMPONENT = "//div/h2[@class='slds-text-heading_medium']";
	public static final String INTERRUPT_MSG = "//span/a[@id='dismissError']";
	public static final String QUICKFIND_SEARCH = "//div/input[@name='Quick Find']";
	public static final String DATATABLE_LINK = "//div[contains(@class,'lwc-section')]/descendant::span[@title='datatable']";
	public static final String EXAMPLE_DROPDOWN = "//div[contains(@class,'slds-combobox__form-element')]/input";
	public static final String INLINE_DROPDOWN_VALUE = "//lightning-base-combobox-item[@data-value='withInlineEdit']//span[contains(text(),'Data Table with Inline Edit')]";
	public static final String RUN_BUTTON = "//button[contains(@class,'slds-button_neutral')]/child::lightning-primitive-icon";

	WebDriver driver;
	ExcelManager em = new ExcelManager();

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public void navigatTo_HomePage(String Url) {
		driver.get(Url);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		List<WebElement> ls = driver.findElements(By.xpath("INTERRUPT_MSG"));
		if (ls.isEmpty()) {
		} else {
			driver.findElement(By.xpath("INTERRUPT_MSG")).click();
		}
		// driver.navigate().refresh();

	}

	public void click_On_Link() {
		WebElement link = driver.findElement(By.xpath(COMPONENT_REFERENCE));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", link);
	}

	public void quick_Find() {
		WebElement search = driver.findElement(By.xpath(QUICKFIND_SEARCH));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// js.executeScript("document.getElementById('search').setAttribute('value',
		// 'datatable')");
		js.executeScript("arguments[0].click()", search);
		driver.findElement(By.xpath(QUICKFIND_SEARCH)).sendKeys("datatable");
		WebElement datatbl = driver.findElement(By.xpath(DATATABLE_LINK));
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		js.executeScript("arguments[0].click()", datatbl);

	}

	public void select_Ele_in_Dropdown() throws InterruptedException {

		// WebElement drpdwn = driver.findElement(By.xpath(EXAMPLE_DROPDOWN));
		// JavascriptExecutor js = (JavascriptExecutor)driver;
		// js.executeScript("arguments[0].click()", drpdwn);
		// driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// WebElement drpdwn_val =
		// driver.findElement(By.xpath(INLINE_DROPDOWN_VALUE));
		// js.executeScript("arguments[0].click()", drpdwn_val);
		// WebElement run_Btn = driver.findElement(By.xpath(RUN_BUTTON));
		// js.executeScript("arguments[0].scrollIntoView(true);", RUN_BUTTON);
		// js.executeScript("arguments[0].click()", run_Btn);
		// driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		// or use wait until till page is loaded
		Thread.sleep(15000);
		Actions mouse = new Actions(driver);
		WebElement wb = driver.findElement(By.xpath(EXAMPLE_DROPDOWN));
		mouse.moveToElement(wb).click().perform();
		// Thread.sleep(10000);
		WebElement wb2 = driver.findElement(By.xpath(INLINE_DROPDOWN_VALUE));
		mouse.moveToElement(wb2).click();
		mouse.build().perform();
		Thread.sleep(5000);

		// WebDriverWait wait = new WebDriverWait(driver, 30);
		// wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.name("preview")));
		// wait.until(new ExpectedCondition<Boolean>() {
		// public Boolean apply(WebDriver wdriver) {
		// return ((JavascriptExecutor) driver).executeScript(
		// "return document.readyState"
		// ).equals("complete");
		// }
		// });
		//
		// driver.switchTo().defaultContent();
		WebElement run_Btn = driver.findElement(By.xpath(RUN_BUTTON));
		mouse.moveToElement(run_Btn).build().perform();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(false);", wb);
		js.executeScript("arguments[0].click()", run_Btn);

	}
}
