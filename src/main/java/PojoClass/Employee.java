package PojoClass;

public class Employee {
	//Declaration
	private String name;
	private String Eid;
	private String email;
	private int age;
	private long phno;
 // initialization in Constructor 
 
 public Employee() {} // No args Constructor
 
public Employee(String name, String eid, String email, int age, long phno) {
	super();
	this.name = name;
	Eid = eid;
	this.email = email;
	this.age = age;
	this.phno = phno;
}
 // Utilization
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEid() {
	return Eid;
}
public void setEid(String eid) {
	Eid = eid;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public long getPhno() {
	return phno;
}
public void setPhno(long phno) {
	this.phno = phno;
}


 
}
