package DataDrivenTesting;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PojoClass.DemoPojo;
import genericUtility.JavaUtility;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class DDTUsingDataProvider {
	JavaUtility j=new JavaUtility();
	@DataProvider
	public Object[][] data(){
		Object[][] data= new Object[3][4];
		 
		data[0][0] ="Warner Bros";
		data[0][1] ="Godzilla"+j.getRandom();
		data[0][2] ="On going";
		data[0][3] =8;
		
		data[1][0] ="Warner Bros";
		data[1][1] ="KIngKOng"+j.getRandom();
		data[1][2] ="Complited";
		data[1][3] =14;
		
		data[2][0] ="Warner Bros";
		data[2][1] ="Pacific Rim"+j.getRandom();
		data[2][2] ="Over";
		data[2][3] =21;
		
		
		return data;	
	}
	@Test(dataProvider = "data")
	public void createProject(String createdBy,String projectName,String status,int teamSize ) {
		baseURI="http://rmgtestingserver";
		port=8084;
		/**/
		DemoPojo pojo=new DemoPojo(createdBy, projectName, status, teamSize);
		
		/*pre requests*/
		given().body(pojo).contentType(ContentType.JSON)
		.when().post("/addProject")
 .then().assertThat().statusCode(201).contentType(ContentType.JSON).log().all();
		
	}
}
