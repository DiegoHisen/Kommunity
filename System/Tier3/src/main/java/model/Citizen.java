package model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Citizen
{
	@Id
	private String cpr;
	
	
	public Citizen(String cpr)
	{
		this.cpr = cpr;
	}
	
	public String getCpr()
	{
		return cpr;
	}
	
	public void setCpr(String cpr)
	{
		this.cpr = cpr;
	}
	

}
