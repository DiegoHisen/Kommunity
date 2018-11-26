package Common;

public class User {
	
	public long cpr;
	public String name;
	public String email;
	public String role;
	public String city;
	public String password;

	
	public User(long cpr, String name, String email, String role, String city, String password) {
		this.cpr = cpr;
		this.name = name;
		this.email = email;
		this.role = role;
		this.city = city;
		this.password = password;
	}

	public long getCpr() {
		return cpr;
	}

	public void setCpr(long cpr) {
		this.cpr = cpr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	public String getPassword() {
		return city;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	



	

}
