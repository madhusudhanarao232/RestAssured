package ResponceBodyValidation;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class DynamicReponseValidationRmg{

	@Test
	public void checkDynamicResponse() {
		baseURI="http://rmgtestingserver";
		port=8084;
		String expId = "TY_PROJ_24373";
		boolean flag=false;
		Response res = given().get("/projects");
		ArrayList<String> proIds = res.jsonPath().get("projectId");
		System.out.println(proIds.size());
		for (String id : proIds) {
		//System.out.println(id);
			if(id.equalsIgnoreCase(expId)) {
				
				flag=true;
				break;
			}
		}
		Assert.assertTrue(flag);
		System.out.println("Data Verified.....");

	}
}
