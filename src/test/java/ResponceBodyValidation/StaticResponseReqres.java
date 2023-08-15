package ResponceBodyValidation;


import static io.restassured.RestAssured.*;


import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.response.Response;

public class StaticResponseReqres {

	@Test
	public void staticRes() {
		
		String expId = "9";
		baseURI="https://reqres.in";
		Response res = given().get("/api/users/2");
		String actId = res.jsonPath().get("data[0].id");
		res.prettyPeek();
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(actId, expId);
		//Assert.assertEquals(actId, expId);
		System.out.println("Verified......");
	}
}
