package Authentication;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class BearerToken {
@Test
public void bearerToken() {
//	baseURI="http://rmgtestingserver";
//	port=8084;
	
	JSONObject jobj= new JSONObject();
	jobj.put("name", "SDET-49");
	given()
	.auth().oauth2("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")
	.body(jobj).contentType(ContentType.JSON)
	
	.when().post("https://api.github.com/user/repos")
	
	.then().assertThat()
	//here i am getting new status code i.e.==>422  means
	//the server can not process the request also pass the request
	.time(Matchers.lessThan(5000l),TimeUnit.MILLISECONDS).log().all();
	
	/*Get the Project from repo */
	given()
	.pathParams("owner", "madhusudhanarao232", "repo","SDET-49") //multiple params
//	.pathParam("owner", "madhusudhanarao232")
//	.pathParam("repo", "SDET-49")
	.when().get("https://api.github.com/repos/{owner}/{repo}")
	
	.then().assertThat().statusCode(200).log().all();
	
}
}
