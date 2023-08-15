package Authentication;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class OAuth2_Coops_api {
	@Test
 public void oauthToken() {
		baseURI="http://coop.apps.symfonycasts.com";
	// generate a access token
		Response res = given()
		.formParam("client_id", "pyga my test")
		.formParam("client_secret", "a351b5d6c0b0d2e98dee11247b10dfe1")
		.formParam("grant_type", "client_credentials")
		.formParam("redirect_uri", "https://madhu.in")
		.formParam("code", "authorization_code")
		.when().post("/token");
	 
		//capture the access token 
		String token = res.jsonPath().get("access_token");
		System.out.println("Access Token ----------> "+token);
		
		res.then().log().all();
		
		//Use the Token in particular api
		
		given()
		.auth().oauth2(token)
		.pathParams("fparam","api","pid", 4652, "thirdparam", "eggs-count")
		//.pathParam("pid", 4652)
		
		.when().post("/{fparam}/{pid}/{thirdparam}")
		
		.then().log().all();
 }
	
}
