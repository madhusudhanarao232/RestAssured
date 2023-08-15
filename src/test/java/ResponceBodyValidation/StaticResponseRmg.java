package ResponceBodyValidation;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import junit.framework.Assert;

public class StaticResponseRmg {

	@Test
	public void staticRes() {
		baseURI="http://rmgtestingserver";
		port=8084;
		String expId = "TY_PROJ_12318";
		Response res = given().get("/projects");
		String actId = res.jsonPath().get("[0].projectId");
		
		Assert.assertEquals(actId, expId);
	}
}
