package Rmg_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    /* Declaration */
	@FindBy(id="usernmae") private WebElement usernameTextBox;

	@FindBy(id="inputPassword") private WebElement passwordTextBox;
	
	@FindBy(xpath="//button[.='Sign in']") private WebElement loginButton;

	 /* Initialization */
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	 /* Utilization */
	
	public WebElement getUsernameTextBox() {
		return usernameTextBox;
	}

	public WebElement getPasswordTextBox() {
		return passwordTextBox;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}
	
	 /* Business library */
	public void setLogin(String USERNAME,String PASSWORD) {
		usernameTextBox.sendKeys(USERNAME);
		passwordTextBox.sendKeys(PASSWORD);
		loginButton.click();
	}
	
}
