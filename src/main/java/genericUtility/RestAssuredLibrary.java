package genericUtility;

import io.restassured.response.Response;
     /**
      *   It Consist of methods of RestAsured
      *   @author LenovoThinkPad
      * 
      */
public class RestAssuredLibrary {
	
	/**
	 * 
	 *    This method will return the JSON DATA from corresponding
	 *    response body
	 * @param res
	 * @param path
	 * @return
	 */
	public String getJsonData(Response res,String path) {
		String jsonData=res.jsonPath().get(path);
		return jsonData;
	}

}
