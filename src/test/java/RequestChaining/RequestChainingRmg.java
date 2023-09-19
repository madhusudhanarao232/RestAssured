package RequestChaining;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.Reporter;
import org.testng.annotations.Test;

import PojoClass.DemoPojo;
import genericUtility.JavaUtility;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class RequestChainingRmg{
	@Test
	public void postChaining() {
		baseURI ="http://rmgtestingserver";
		port=8084;
		JavaUtility jlib=new JavaUtility();
		/* Create a pre req*/
		DemoPojo pojo=new DemoPojo("Optimus Prime", "Transformers_"+jlib.getRandom(), "Complited", 16);
		/* step 1: pre conditions & Action */

//		Response res = given().body(pojo)  
//				.contentType(ContentType.JSON).when().post("/addProject");
//
//		/* step 2: get ProjectId from The Response */
//		String pid = res.jsonPath().get("projectId");
//		Reporter.log("GENERATED ProjectId -------------> "+pid,true);
		
		/* step 3: Applying Chaining Concept For GET */
		String pid="TY_PROJ_005";
		given().pathParam("id", pid)
		.when().get("/projects/{id}")
		.then().assertThat().contentType(ContentType.JSON).log().all();

		/* step 4: Applying Chaining Concept For PUT */
		
		DemoPojo pojo1=new DemoPojo("Bumble BEE", "Transformers New Season", "On Going", 16);
		Response res1 = given().body(pojo1)
				.contentType(ContentType.JSON).when().put("/projects/"+pid);
		System.out.println();
		Reporter.log(pid+"...........Project Updated ........",true);
		System.out.println();
		System.out.println(res1.asPrettyString());
		
		/* step 5: Applying Chaining Concept For DELETE*/
		
		given().pathParam("id1", pid)
		.when().delete("/projects/{id1}")
		.then().assertThat().statusCode(204).contentType(ContentType.JSON).log().all();
		System.out.println();
		String deletedId = res1.jsonPath().get("projectId");
		Reporter.log(deletedId+"...........Project Deleted ........",true);
		System.out.println();
	}
}
