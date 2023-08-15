package DifferaentWaysToPostARequest;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.testng.annotations.Test;

import PojoClass.PojoReqres;
import genericUtility.JavaUtility;
import io.restassured.http.ContentType;

public class PojoClassReqres {

JavaUtility jlib=new JavaUtility();
	
	@Test
	public void usingHashMapReqres() {
		baseURI="https://reqres.in/";
		/* Pre Requests*/
		PojoReqres pojo=new PojoReqres("Madhu"+jlib.getRandom(), "Cooker");
		/* step 1: Pre Conditions */
		given().body(pojo).contentType(ContentType.JSON)
		/* step 2:Actions */
		.when().post("/api/users")
		/* step 3:Validation */
		.then().assertThat().statusCode(201).contentType(ContentType.JSON).log().all();
	}

	
}
