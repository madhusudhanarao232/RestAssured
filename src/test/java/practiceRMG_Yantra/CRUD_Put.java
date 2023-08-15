package practiceRMG_Yantra;

import java.util.Random;

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
	/*Get Random number*/
	Random r=new Random();
	int ran = r.nextInt(1000);
	/* Step 1: Create Pre-Requests*/
	JSONObject jObj = new JSONObject();
	jObj.put("createdBy", "chinnu THE CAT");
	jObj.put("projectName", "huting lizards");
	jObj.put("status", "chinnu");
	jObj.put("teamsize", 10);
	
	RequestSpecification req = RestAssured.given();
	req.body(jObj);
	req.contentType(ContentType.JSON);
	
	/* Step 2: Perform the Action*/
	String id = "TY_PROJ_24297";
	Response res = req.put("http://rmgtestingserver:8084/projects/"+id);
	int actStatusCode = res.getStatusCode();
	/* Step 2: Validate the responce*/
	Assert.assertEquals(200, actStatusCode);
	System.out.println(res.getContentType());
//	System.out.println(res.asString());
//	System.out.println(res.prettyPrint());
	System.out.println(res.prettyPeek());
	
	
}
}
