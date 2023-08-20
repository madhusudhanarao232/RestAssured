package FrameWork;

import org.testng.annotations.Test;

import PojoClass.DemoPojo;
import Rmg_POM.CreateProjectPage;
import Rmg_POM.HomePage;
import genericUtility.BaseClass;
import genericUtility.EndPoints;
import genericUtility.JavaUtility;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class Create_project_WithPOM extends BaseClass{

	@Test
	public void createProjectWithPOM() {
		
		/* Create an Object for JavaUtility */
		JavaUtility jlib=new JavaUtility();
		
		/* Create Object instance for Necessary classes */
		CreateProjectPage cp=new CreateProjectPage(driver);
		HomePage hp=new HomePage(driver);
		DemoPojo pojo=new DemoPojo("Madhu", "Marvel"+jlib.getRandom(), "Complited", 7);
		
		/* */
		hp.getProjectsBtn().click();
		cp.getCreateProjectBtn().click();
		 String createpro = EndPoints.createProject;
		given().body(pojo).contentType(ContentType.JSON)
		
		.when().post(createpro)
		
		.then().assertThat().contentType(ContentType.JSON).log().all();
		
		
	}
}
