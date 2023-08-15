package DifferaentWaysToPostARequest;

import java.util.HashMap;

import org.testng.annotations.Test;

import genericUtility.JavaUtility;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class HashMapReqres {
	JavaUtility jlib=new JavaUtility();
	
	@Test
	public void usingHashMapReqres() {
		baseURI="https://reqres.in/";
		/* Pre Requests*/
		HashMap<String, Object> map=new HashMap<String, Object>();
		map.put("name", "Srinivasa"+jlib.getRandom());
		map.put("job", "VaddiKasulavaru");
		/* step 1: Pre Conditions */
		given().body(map).contentType(ContentType.JSON)
		/* step 2:Actions */
		.when().post("/api/users")
		/* step 3:Validation */
		.then().assertThat().statusCode(201).contentType(ContentType.JSON).log().all();
	}

}
