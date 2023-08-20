package FrameWork;

import org.testng.Assert;
import org.testng.annotations.Test;

import PojoClass.DemoPojo;
import genericUtility.BaseClass;
import genericUtility.EndPoints;
import genericUtility.Iconstants;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class CreateProjectWithOutPOM extends BaseClass{

	
	@Test
	public void createProjectInDatabe() throws Throwable {
	
		baseURI=Iconstants.appURI;
		
		DemoPojo pojo=new DemoPojo("Mahendra", "THOR_"+jlib.getRandom(), "Active", 34);
		
		Response resp = given().body(pojo).contentType(ContentType.JSON)
		.when().post(EndPoints.createProject);
		
		//System.out.println(resp.prettyPeek());
		
		String expdata = rlib.getJsonData(resp, "projectId");
		
		System.out.println("ExpData ---->"+expdata);
		
		String query = "select * from project";	
		String actdata = dlib.executeQuerryAndVerify(query, 1, expdata);
		Assert.assertEquals(expdata, actdata);
		System.out.println("---------------<   TC PASSED  >------------");
		resp.then().log().all();
		
	}
}
