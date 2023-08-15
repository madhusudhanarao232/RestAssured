package genericUtility;

import java.sql.SQLException;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import Rmg_POM.HomePage;
import Rmg_POM.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseClass {
	public WebDriver driver=null;
	public static WebDriver sdriver=null;
	public DataBaseUtility dlib=new DataBaseUtility();
	public JavaUtility jlib=new JavaUtility();
	public RestAssuredLibrary rlib=new RestAssuredLibrary();
	public WebActionUtility w=new WebActionUtility() ;
	public String URL=null;
	//public String BROWSE;
	@BeforeSuite
	   public void connectToDB() throws SQLException {
		dlib.connectDB();
		Reporter.log("------------------CONNECTED TO DATABASE----------------",true);
	}
	@BeforeClass
	public void lanchBrowser() throws Throwable {
		
		driver=new ChromeDriver();
		URL=Iconstants.appURI;
		sdriver=driver;
		w.maximizeTheBrowser(driver); 
		driver.get(URL);
		w.waitForElementInDOM(driver);
		Reporter.log("  BROWSER IS LAUNCHED............ ",true);
	}
	@BeforeMethod
	public void  loginToApplication() {
		LoginPage lp=new LoginPage(driver);
		String USERNAME = Iconstants.appUN;
		String PASSWORD = Iconstants.appPWD;
		lp.setLogin( USERNAME, PASSWORD);
		Reporter.log("  login to the Application...............",true);
	}
	@AfterMethod
	public void logoutFromApplication() throws Throwable {
		HomePage hp=new HomePage(driver);
		
		w.waitForElementInDOM(driver);
		hp.getLogoutBtn().click();
		//hp.signOut();
		Reporter.log("  LOgOuting from the Application ...............",true);
	}
	@AfterClass
	public void closeTheBrowser() {
		driver.quit();
		Reporter.log("  BROWSER Closed................",true);
	}
	
	@AfterSuite
	 public void closeConnectionToDB() throws SQLException {
		 dlib.closeDB();
		 Reporter.log("------------------DATABASE CLOSED----------------",true);
			
		}
}
