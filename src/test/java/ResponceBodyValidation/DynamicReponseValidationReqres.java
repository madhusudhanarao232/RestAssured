package ResponceBodyValidation;

import static io.restassured.RestAssured.*;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class DynamicReponseValidationReqres {
	@Test
	public void checkDynamicResponse() {
		baseURI="https://reqres.in";
		String expmail = "byron.fields@reqres.in";
	
		Response res = given().get("/api/users?page=2");
        List<String> proMAILs = res.jsonPath().get("data.email");
		res.prettyPeek();
		System.out.println(proMAILs.size());
		
		boolean flag=false;
		
		for(String mail : proMAILs) 
		{
			
			if(mail.equalsIgnoreCase(expmail)) 
			{
				flag=true;
				System.out.println("-------------->"+mail);
			    break;	
			}
		}
		
		
		Assert.assertTrue(flag);

		System.out.println("Data Verified.....");
		

	}
}
