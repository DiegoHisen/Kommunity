package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import security.Security;
@Entity
public class UserDetails 
{
	@Id
	private int cpr;
	private String password;
	private String name;
	private String email;
	private String role;
	@OneToOne
	private City city;
	
	public UserDetails(City city,String email,String name,String role,String password,int cpr)
	{
		this.cpr = cpr;
		this.password = Security.HashFunction(password);
		this.name = name;
		this.email = email;
		this.role = role;
		this.city = city;
	}
	
	public int GetCpr()
	{
		return cpr;
	}
	
	public void SetCpr(int cpr)
	{
		this.cpr = cpr;
	}
	
	public String GetPassword()
	{
		return password;
	}
	
	public void SetPassword(String password)
	{
		this.password = Security.HashFunction(password);
	}
	
	public String GetName()
	{
		return name;
	}
	
	public void SetName(String name)
	{
		this.name = name;
	}
	
	public String GetEmail()
	{
		return email;
	}
	
	public void SetEmail(String email)
	{
		this.email = email;
	}
	
	public String GetRole()
	{
		return role;
	}
	
	public void SetRole(String role)
	{
		this.role = role;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}
	
	
	
	
	

}
