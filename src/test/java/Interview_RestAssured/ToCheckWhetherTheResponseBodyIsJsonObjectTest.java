package Interview_RestAssured;

import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class ToCheckWhetherTheResponseBodyIsJsonObjectTest {
	
	@Test
	public void checkJsonObject() {
		
       
		Response res = given()
				.pathParam("pid", "TY_PROJ_6213")
		        .when().get("rmgtestingserver:8084/projects/{pid}");
		// capture the response
		
		String resBody=res.getBody().asString();
		
		try {
			ObjectMapper mapper=new ObjectMapper();
			
	        JsonNode jsonNode = mapper.readTree(resBody);
	     // to about methods their return types
//			boolean ab = jsonNode.isArray();
//			boolean bc = jsonNode.isInt();
//			boolean cd = jsonNode.isNull();
			
	        if(jsonNode.isObject()) {
	        	// the response body is json Object
	        	System.out.println("Responce is a JSON object");
	        	// you can further process the Json object as needed 
	        }
	        else if(jsonNode.isArray()) {
	        	
	        	
	        }
	        else {
	        	
	        }
		}
		catch(Exception e) {
			
		}
		
	}

}
