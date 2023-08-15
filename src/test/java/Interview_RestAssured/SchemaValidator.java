package Interview_RestAssured;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.module.jsv.JsonSchemaValidator;

import static io.restassured.RestAssured.*;

public class SchemaValidator {
//      https://jsonformatter.org/json-to-jsonschema
	@Test
	public void schema() {
		baseURI="https://reqres.in";
		File file=new File("./src/test/resources/schema.json");
		given().pathParams("fpara", "api", "spara","users")
		.queryParam("page", 2)
		.when().get("/{fpara}/{spara}")
		//when().get("/api/users/?page=2")
		.then().assertThat()
		.body(JsonSchemaValidator.matchesJsonSchema(file))
		.log().all();
	}
}
