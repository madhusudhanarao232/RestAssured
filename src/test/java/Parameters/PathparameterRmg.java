package Parameters;

import static io.restassured.RestAssured.*;


import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PathparameterRmg {
@Test
public void pathParameter() {
	baseURI="http://rmgtestingserver";
	port=8084;
	
	given()
	.pathParam("projectId", "TY_PROJ_24368")

	.when()
	.get("/projects/{projectId}")
	
	.then().assertThat().contentType(ContentType.JSON).statusCode(200).log().all();
	
	
	
	
}
}
