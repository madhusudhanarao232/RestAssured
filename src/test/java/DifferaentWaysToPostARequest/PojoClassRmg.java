package DifferaentWaysToPostARequest;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import org.testng.annotations.Test;

import PojoClass.DemoPojo;
import genericUtility.JavaUtility;
import io.restassured.http.ContentType;

public class PojoClassRmg {

	@Test
	public void usingPojo() {
		baseURI ="http://rmgtestingserver";
		port=8084;
		JavaUtility jlib=new JavaUtility();
		/* Create a pre-requests*/
		DemoPojo pojo = new DemoPojo("Madhu", "ManMade"+jlib.getRandom(), "Pending", 7);
		/* step 1: pre conditions */
		given().body(pojo).contentType(ContentType.JSON)
		/* step 2: actions */
		.when().post("/addProject")
		/* step 3: Validation */
.then().assertThat().statusCode(201).contentType(ContentType.JSON).log().all(); 

	}
}
