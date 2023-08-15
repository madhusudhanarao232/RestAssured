package practiceRMG_Yantra;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class CRUD_Delete {
  @Test
  public void deleteUser() {
	  String id = "TY_PROJ_24297";
	  Response res = RestAssured.delete("http://rmgtestingserver:8084/projects/"+id);
	  int actualStatusCode = res.getStatusCode();
      Assert.assertEquals(204, actualStatusCode);
      System.out.println("PASS.......");
	   res.prettyPeek();
  }
}
