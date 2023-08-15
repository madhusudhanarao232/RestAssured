package practiceReqres;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CRUD_Put {

	@Test
	public void updateUserusingPut() {
		/* Step 1: Create Pre-Requests*/
		JSONObject jObj = new JSONObject();
		jObj.put("name", "chinnuTheCat");
		jObj.put("job", "huting lizards Over");

		RequestSpecification req = RestAssured.given();
		req.body(jObj);
		req.contentType(ContentType.JSON);

		/* Step 2: Perform the Action*/
		Response res = req.put("https://reqres.in/api/users/2");
         int actStatusCode = res.getStatusCode();
		/* Step 3: Validate the responce*/
         Assert.assertEquals(200, actStatusCode);
		//	System.out.println(res.getContentType());
		//	System.out.println(res.asString());
		//	System.out.println(res.prettyPrint());
		System.out.println(res.prettyPeek());
	}

}
