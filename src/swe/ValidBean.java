package swe;

public class ValidBean {
	private String email,password;
	public boolean valid;
	 public ValidBean(){  
	        System.out.println("Object Created");  
	    }
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isValid() {
		return valid;
	}
	public void setValid(boolean valid) {
		this.valid = valid;
	} 

}
