package Rmg_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateProjectPage {

	/* Declaration */
	
	@FindBy(xpath="//span[.='Create Project']")private WebElement createProjectBtn;
	/* Initialization */
	
	public CreateProjectPage(WebDriver driver) {
		
		PageFactory.initElements(driver,this);
	}
	/* Utilization */
	
	public WebElement getCreateProjectBtn() {
		return createProjectBtn;
		
	}
	/* Business library */
}
