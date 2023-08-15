package Interview_RestAssured;

import org.testng.annotations.Test;

import PojoClass.DemoPojo;
import genericUtility.JavaUtility;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.*;

public class SpecBuilder {
	@Test
	public void specBuilder() {

		//create a instace of genUtility classes
		JavaUtility jlib=new JavaUtility();
		/* step 1: Create a pojo class instance*/

		DemoPojo pojo=new DemoPojo("Marvels", "Captain_America_"+jlib.getRandom(), "In Active", 4);

		/* Create a instance of ResponseSpecification and store it in 
		 * ref var of RequestSpecBuilder it is acts like as a 
		 * pre-conditions for request script
		 * 
		 * */
		RequestSpecification req = new RequestSpecBuilder()
				.setBaseUri("http://rmgtestingserver:8084")
				.setContentType(ContentType.JSON).build();
		/* Create a instance of ResponseSpecification and store it in 
		 * ref var of ResponseSpecBuilder 
		 * it is acts like as a pre-conditions for request script
		 * */
		ResponseSpecification res = new ResponseSpecBuilder()
				.expectContentType(ContentType.JSON)
				.expectStatusCode(201).build();

        /*pre req*/
		given().spec(req).body(pojo).contentType(ContentType.JSON)
		
		.when().pathParam("fpara", "addProject").post("/{fpara}")
		
		.then().spec(res).log().all();

	}

}
