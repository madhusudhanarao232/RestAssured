package Interview_RestAssured;

import java.util.HashSet;
import java.util.Set;

import org.testng.annotations.Test;

import io.restassured.config.LogConfig;

import static io.restassured.RestAssured.*;

public class HowToKeepTheSencitiveDataOutOfTheLog {
  @Test
  public void sample() {
	  Set<String> headers=new HashSet<String>();
	  headers.add("X-REGION");
	  headers.add("Content-type");
	  
	  given()
	  .baseUri("http://rmgtestingserver:8084/")
	  .headers("X-REGION","NAM")
	  // blacklist headers
	  
	.config(config.logConfig(LogConfig.logConfig().blacklistHeaders(headers)))
	  // blacklist multiple headers
//.config(config().logConfig(LogConfig.logConfig().blacklistedHeaders("Accept","set-Cookie")))
	.log().all()
	.when()
	.get("/employees")
	.then().assertThat().statusCode(200);
  }
  
}
