package jp.co.aforce.bean;

public class LoginBean implements java.io.Serializable{
	
	private String id;
	private String name;
	private String pass;
	
	public String getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getPass() {
		return pass;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPass(String pass) {
		this.pass = pass;
	}

}
