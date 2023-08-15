package practiceRMG_Yantra;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class CRUD_GetAllUser {
@Test
	public void getAllusersFromReqres() {
		 /*Send request to the browsers to get the list of Users*/
		 Response res = RestAssured.get("http://rmgtestingserver:8084/projects");
		 int actStatusCode = res.getStatusCode();
		 Assert.assertEquals(200, actStatusCode);
		 System.out.println("PASS.......");
		 res.prettyPeek();
	}
}
