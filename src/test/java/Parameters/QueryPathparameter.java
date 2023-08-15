package Parameters;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class QueryPathparameter {
@Test
public void paraMeters() {
	baseURI="https://reqres.in/api";
	
	given()
	.pathParam("pathpara", "users")
	.queryParam("page", 2)
	
	.when()
	.get("{pathpara}")

	
	.then()
	.assertThat()
	.statusCode(200)
	.contentType(ContentType.JSON)
	.log().all();
}
}
