package Serialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import PojoClass.EmpAOB;
import PojoClass.Employee;
import PojoClass.EmployeeComplexData;
import PojoClass.Spouse;

public class EmpSerializationJavaToJson {

	@Test
	public void simpleEmpSer() throws JsonGenerationException, JsonMappingException, IOException  {
		Employee emp=new Employee("MADHU", "TR557", "madhu@gmail.com", 25, 8500321287l);
		
		ObjectMapper mapper = new ObjectMapper(); 
		
		//to get json File in Single line
		
//		mapper.writeValue(new File("./emp.json"), emp);
		
		//to get the content like actual Json format
		mapper.writerWithDefaultPrettyPrinter().writeValue(new File("./emp.json"), emp);
	}
	
	@Test
	public void complexDataSer() throws JsonGenerationException, JsonMappingException, IOException {
		
		String [] email={"madhu@gamil.com","dande@gmail.com","madhu.dande@gamil.com","rao.dande@gamil.com"};
		long [] phno={8500321287l,9494689927l,9652662166l};
		EmployeeComplexData data=new EmployeeComplexData("MADHUSUDHANARAO DANDE", "TR557", email, 25, phno);
	
	      ObjectMapper m = new ObjectMapper();
	      
	      m.writerWithDefaultPrettyPrinter().writeValue(new File("./complexData.json"), data);
	      
	}
	
	@Test
	public void complexAOB() throws JsonGenerationException, JsonMappingException, IOException {
		long sph[]= {6304540601l,1234567890l};
		Spouse s=new Spouse("Mounika", 23, sph);
		String email[]= {"madhu@gamil.com","dande@gamil.com"};
		long eph[]= {8500321287l,9494689927l};
		EmpAOB edata=new EmpAOB("MADHUSUDHANA_RAO", "TR557", email, 25, eph, s);
		
		 ObjectMapper m = new ObjectMapper();
	      
	      m.writerWithDefaultPrettyPrinter().writeValue(new File("./EmpAOBData.json"), edata);
	}
	
}
