package practiceReqres;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class CRUD_Delete {

	@Test
	 public void deleteUsers() {
		 /*Send request to the browsers to get the list of Users*/
		 Response res = RestAssured.delete("https://reqres.in/api/users/2");
		 int actStatusCode = res.getStatusCode();
		 Assert.assertEquals(204, actStatusCode);
		 System.out.println("PASS.......");
		 res.prettyPeek();
	 }
}
