 package Serialization;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import PojoClass.EmpAOB;
import PojoClass.Employee;
import PojoClass.EmployeeComplexData;
import PojoClass.Spouse;

public class EmpDeSeriliazationJsonToJava {

	@Test(priority=1)
	public void deSer() throws JsonParseException, JsonMappingException, IOException {

		ObjectMapper mapper = new ObjectMapper();

		Employee data = mapper.readValue(new File("./emp.json"), Employee.class);

		System.out.println("Emp Name: "+data.getName());
		System.out.println("Emp Eid: "+data.getEid());
		System.out.println("Emp email: "+data.getEmail());
		System.out.println("Emp age: "+data.getAge());
		System.out.println("Emp PhoneNumber: "+data.getPhno());
		
		System.out.println();
		System.out.println("------------------------------------------------------");
		System.out.println();
	}

	@Test(priority=2)
	public void complexDeSer() throws JsonParseException, JsonMappingException, IOException {

		ObjectMapper mapper = new ObjectMapper();

		EmployeeComplexData data = mapper.readValue(new File("./complexData.json"), EmployeeComplexData.class);

		System.out.println("Emp Name: "+data.getName());
		System.out.println("Emp Eid: "+data.getEid());
		System.out.println("Emp age: "+data.getAge());

		System.out.println(Arrays.toString(data.getEmail()));
		System.out.println(Arrays.toString(data.getPhno()));

		//		for(int i=0,j=0;i<data.getEmail().length&&j<data.getPhno().length;i++,j++) {
		//		System.out.println("Emp email:"+(i+1)+"->"+data.getEmail()[i]);
		//		System.out.println("Emp PhoneNumber:"+(j+1)+"->"+data.getPhno()[j]);
		//		}

		System.out.println();
		System.out.println("------------------------------------------------------");
		System.out.println();
	}
	@Test(priority=3)
	public void empAOB() throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper m = new ObjectMapper();

		EmpAOB data = m.readValue(new File("./EmpAOBData.json"), EmpAOB.class);


		System.out.println("Emp Name: "+data.getName());
		System.out.println("Emp Eid: "+data.getEid());
		System.out.println("Emp age: "+data.getAge());
		/* To Print ArrayValues like as Array */
		System.out.println("Emp Phno: "+Arrays.toString(data.getPhno()));
		System.out.println("Emp Email: "+Arrays.toString(data.getEmail()));

		//Spouse Details
		for(int i=0;i<data.getspouse().length;i++) {
		Spouse s = data.getspouse()[i];
		System.out.println();
		System.out.println((i+1)+" spouse details");
		System.out.println();
		System.out.println("Spouse Name: "+s.getName());
		System.out.println("Spouse age: "+s.getAge());
		System.out.println("Spouse phno: "+Arrays.toString(s.getPhno()));
		}

		/* to Print Array values One by ONE */
		//	for(int i=0,j=0,k=0;i<data.getEmail().length&&j<data.getPhno().length&&k<data.getPhno().length;i++,j++,k++) {
		//			
		//			System.out.println("Emp email:"+(i+1)+"->"+data.getEmail()[i]);
		//			System.out.println("Emp PhoneNumber:"+(j+1)+"->"+data.getPhno()[j]);
		//			
		//			System.out.println("SPOUSE PhoneNumber:"+(k+1)+"->"+data.getspouse().getPhno()[k]);
		//			
		//			}

		System.out.println();
		System.out.println("------------------------------------------------------");
		System.out.println();
	}

}
