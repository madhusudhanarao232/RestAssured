package practiceReqres;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtility.JavaUtility;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Crud_Post {

	@Test
	public void createProjectTest() {
		/*Get Random number*/
		JavaUtility jlib=new JavaUtility();
		/* Step 1: Create Pre-Requests*/
		JSONObject jObj = new JSONObject();
		jObj.put("name", "chinnu"+jlib.getRandom());
		jObj.put("job", "huting lizards");
		
		RequestSpecification req = RestAssured.given();
		req.body(jObj);
		req.contentType(ContentType.JSON);
		
		/* Step 2: Perform the Action*/
		Response res = req.post("https://reqres.in/api/users");
		int actsatusCode = res.getStatusCode();
		/* Step 2: Validate the responce*/
		Assert.assertEquals(201, actsatusCode);
		System.out.println(res.getContentType());
//		System.out.println(res.asString());
//		System.out.println(res.prettyPrint());
		System.out.println(res.prettyPeek());
		
	}
}
