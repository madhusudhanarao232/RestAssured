package Interview_RestAssured;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class ValidateUrlTest {
	@Test
	public void validateUrl()
	{
		//   https://petstore.swagger.io/v2
      String s = "https://google.com/";
      Response res = RestAssured.head(s);
     int code = res.getStatusCode();
     ResponseBody body = res.getBody().prettyPeek();
     String date = res.getHeader("Date");
   
     System.err.println(date);
    // System.out.println(body);
     System.out.println("\u001B[1m"+"\u001B[32m"+code+"\u001B[0m");
     if(code==200) {
    	 System.out.println("\u001B[1m"+"\u001B[32m"+"Given URL is valid"+"\u001B[0m");
     }
     else
    	 System.err.println("Given URL is invalid");

	}
}
