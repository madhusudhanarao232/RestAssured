package Authentication;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class Basic_DigestAuth {
@Test
public void basicDigestAuth() {
	baseURI="http://rmgtestingserver";
	port=8084;
	
	given().auth()
	.digest("rmgyantra", "rmgy@9999")
	.when().get("/login")
	.then().log().all();
}
}
