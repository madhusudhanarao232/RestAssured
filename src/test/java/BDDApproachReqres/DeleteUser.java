package BDDApproachReqres;

import static io.restassured.RestAssured.*;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;



public class DeleteUser {	
	@Test
	public void deleteUser() {
		baseURI="https://reqres.in";
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
