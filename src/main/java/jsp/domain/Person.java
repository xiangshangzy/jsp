package jsp.domain;

import java.util.Date;

//业务逻辑层(实体类)
public class Person {	
	private String id;		//类属性需要与数据库中的字段一一对应
	private String name;
	private String password;
	private Date birthDate; 
	
	public Person() {
		super();
	}

	public Person(String iD, String name, String password, Date birthDate) {
		super();
		id= iD;
		this.name = name;
		this.password = password;
		this.birthDate = birthDate;
	}	
	
	public String getID() {
		return id;
	}

	public void setID(String iD) {
		id= iD;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
