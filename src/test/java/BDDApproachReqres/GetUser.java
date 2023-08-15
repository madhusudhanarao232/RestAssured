package BDDApproachReqres;

import static io.restassured.RestAssured.*;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class GetUser{
	@BeforeMethod
	public void var() {
	baseURI="https://reqres.in";
	}
	@Test
	public void getAllUsers() {

		/* step 1: actions */
		when()
		.get("/api/users?page=2")
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
		.get("/api/users/2")
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
		.delete("/api/users/2")
		/* step 2: Validation*/
		.then()
		.assertThat()
		.statusCode(204)
		.log().all();	
	}

}
