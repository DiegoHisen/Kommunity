package model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Citizen
{
	@Id
	private int cpr;
	
	public Citizen(int cpr)
	{
		this.cpr = cpr;
	}
	
	public int GetCpr()
	{
		return cpr;
	}
	
	public void SetCpr(int cpr)
	{
		this.cpr = cpr;
	}
	

}
