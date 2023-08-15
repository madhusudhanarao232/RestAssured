package RequestChaining;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class RequestChainingReqres {
   @Test
   public void chainingReqres() {
	   baseURI="https://reqres.in";
		
		Response res = when().get("/api/users/?page=2");
		
		res.prettyPeek();
		 
		int id = res.jsonPath().get("data[0].id");
		/* Applying Chaining Concept Here*/
		given().pathParam("id", id)
		
		.when().get("/api/users/{id}")
		
	   .then().log().all() ;	
   }
}
