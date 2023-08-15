package Authentication;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class Basic_Preemtive_BasicAuth {

	@Test
	public void primitiveAuth() {
		baseURI="http://rmgtestingserver";
		port=8084;
		given()
		.auth().preemptive().basic("rmgyantra", "rmgy@9999")
		
		.when().get("/login")
		
		.then().assertThat().contentType(ContentType.JSON).statusCode(202).log().all();
	}
}
