package practiceRMG_Yantra;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class CRUD_GetSingleUser {

	@Test
	public void getSingleUserName() {
		String id = "TY_PROJ_24297";
		Response res = RestAssured.get("http://rmgtestingserver:8084/projects/"+id);
        int actualStatusCode = res.getStatusCode();
        Assert.assertEquals(200, actualStatusCode);
        System.out.println("PASS.......");
	   res.prettyPeek();
	}
}
//TY_PROJ_24297