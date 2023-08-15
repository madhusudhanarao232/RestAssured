package Parameters;

import org.testng.annotations.Test;

import genericUtility.JavaUtility;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class FormparameterRmg {
@Test
public void formParameter() {
	baseURI="http://rmgtestingserver";
	port=8084;
	JavaUtility jlib=new JavaUtility();
	/* Actions*/
	given()
	.formParam("createdBy", "ChawanPrash")
	.formParam("projectName", "GrowingMindPower"+jlib.getRandom())
	.formParam("status", "good")
	.formParam("teamSize", 19)
	
	.when().post("/addProject")
	/* Validation */
.then().assertThat().statusCode(201).contentType(ContentType.JSON).log().all();
}
}
