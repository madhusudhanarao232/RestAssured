package BDDApproachRMG;

import static io.restassured.RestAssured.*;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;



public class DeleteUser {
	public static String id = "TY_PROJ_24378";
	@BeforeMethod
	public void var() {
	baseURI="http://rmgtestingserver";
	port=8084;
	}
	@Test
	public void deleteUser() {
		/* step 1: actions */
		when()
		.delete("/projects/"+id)
		/* step 2: Validation*/
		.then()
		.assertThat()
		.statusCode(204)
		.log().all();	
	}
}
