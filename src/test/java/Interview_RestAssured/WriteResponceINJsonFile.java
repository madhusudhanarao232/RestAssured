package Interview_RestAssured;

import org.testng.annotations.Test;

import com.google.common.io.Files;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class WriteResponceINJsonFile {

	@Test
	public void writeInFile() throws IOException {
		Response res = when().get("rmgtestingserver:8084/projects");
		// Extract response as a JSON String
		String resAsString = res.getBody().asString();
		// converting into BYte[] array
		byte[] resAsStringByte = resAsString.getBytes();
		//Creating target File  {file from common.io.Files package}
		File file=new File("src/test/resources/WriteFile/targetFileForString.json");
		//Writing into files
		Files.write(resAsStringByte,file);
	}
	@Test
	public void writeInFile2() throws IOException {
		Response res = when().get("rmgtestingserver:8084/projects");
		InputStream resAsInputStream = res.asInputStream();
		byte [] resAsInputStreamByte= new byte[resAsInputStream.available()];
		resAsInputStream.read(resAsInputStreamByte);
		//Creating target File  {file from common.io.Files package}
		File file=new File("src/test/resources/WriteFile/targetFileForInputStream.json");
		//Writing into files
		Files.write(resAsInputStreamByte,file);

	}
	@Test
	public void writeInFile3() throws IOException {
		Response res = when().get("rmgtestingserver:8084/projects");
        byte[] resAsByteArray = res.asByteArray();
      //Creating target File  {file from common.io.Files package}
      		File file=new File("src/test/resources/WriteFile/targetFileForByteArray.json");
      		//Writing into files
      		Files.write(resAsByteArray,file);
     
        
	}
}
/*
 * 1.which way is more optimal if you want to write into a file?
 * 2.If you notice that we get response
 */
