package practiceReqres;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class CRUD_GetAllUsers {

	 @Test
	 public void getAllusersFromReqres() {
		 /*Send request to the browsers to get the list of Users*/
		 Response res = RestAssured.get("https://reqres.in/api/users?page=2");
		 int actStatusCode = res.getStatusCode();
		 Assert.assertEquals(200, actStatusCode);
		 System.out.println("PASS.......");
		 res.prettyPeek();
	 }
}
