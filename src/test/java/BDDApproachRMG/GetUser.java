package BDDApproachRMG;

import static io.restassured.RestAssured.*;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class GetUser{
	public static String id = "TY_PROJ_24404";
	@BeforeMethod
	public void var() {
	baseURI="http://rmgtestingserver";
	port=8084;
	}
	@Test
	public void getAllUsers() {

		/* step 1: actions */
		when()
		.get("/projects/")
		/* step 2: Validation*/
		.then()
		.assertThat()
		.contentType(ContentType.JSON)
		.statusCode(200)
		.log().all();
	}
	@Test
	public void getSingleUser() {
		/* step 1: actions */
		when()
		.get("/projects/"+id)
		/* step 2: Validation*/
		.then()
		.assertThat()
		.contentType(ContentType.JSON)
		.statusCode(200)
		.log().all();

	}
	@Test
	public void deleteUser() {
		/* step 1: actions */
		when()
		.delete("/projects/"+id)
		/* step 2: Validation*/
		.then()
		.assertThat()
		.contentType(ContentType.JSON)
		.statusCode(204)
		.log().all();	
	}

}
