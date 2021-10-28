package stepDefinition;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import pageObject.HomePage;

public class StepDefinition {

	public static WebDriver driver;
	HomePage homePage;
	public static Properties prop;

	@Before("@selenium")
	public void setUp() throws IOException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\project\\sitetracker\\src\\main\\resource\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		homePage = new HomePage(driver);
		FileReader reader;
		try {
			reader = new FileReader("/project/sitetracker/src/main/resource/CustomData.properties");
			prop = new Properties();
			prop.load(reader);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Given("^login to homepage$")
	public void login_to_url() {
		String url = (String) prop.get("URL");
		homePage.navigatTo_HomePage(url);
	}

	@And("^click on COMPONENT_REFERENCE tab$")
	public void click_On_Comp_Ref() {
		homePage.click_On_Link();
		String comp_Page_Header = driver.findElement(By.xpath(HomePage.COMPONENT)).getText();
		Assert.assertEquals("Components", comp_Page_Header);
	}

	@And("^search in QuickFind for datatable$")
	public void quickFind_Search() {
		homePage.quick_Find();
		/*
		 * String comp_Page_Header =
		 * driver.findElement(By.xpath(homePage.COMPONENT)).getText();
		 * Assert.assertEquals("Components", comp_Page_Header);
		 */ }

	@And("^select in line edit option from elements dropdown and run$")
	public void select_From_Drpdwn_And_Run() throws InterruptedException {
		homePage.select_Ele_in_Dropdown();
	}

	@After("@selenium")
	public void tearDown() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.quit();

	}

}
