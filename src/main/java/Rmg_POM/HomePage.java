package Rmg_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage { 
    // Declaration
	
	//div/descendant::a[text()='Logout']
	
	@FindBy(xpath="//a[text()='Logout']")private WebElement logoutBtn;
	
	@FindBy(xpath="//a[.='Home']")private WebElement hometBtn;
	
	@FindBy(xpath="//a[.='Projects']")private WebElement projectsBtn;
	
	@FindBy(xpath="//a[.='Users']")private WebElement usersBtn;
	
	@FindBy(xpath="//a[.='Settings']")private WebElement settingsBtn;
	

	// Initialization
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	// Utilization
	
	
	
	public WebElement getHometBtn() {
		return hometBtn;
	}
	public WebElement getLogoutBtn() {
		return logoutBtn;
	}



	public WebElement getProjectsBtn() {
		return projectsBtn;
	}
	public WebElement getUsersBtn() {
		return usersBtn;
	}
	public WebElement getSettingsBtn() {
		return settingsBtn;
	}
	
	//Business library
	
	public void signOut() {
		logoutBtn.click();
	}
	
	
	
}
