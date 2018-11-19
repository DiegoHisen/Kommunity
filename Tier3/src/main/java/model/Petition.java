package model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Petition 
{

	@Id
	@Column(name="Petition_Id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int peid;
	@Column(name="Creator")
	@OneToOne
	private UserDetails creator;
	@Temporal(TemporalType.DATE)
	private Date date;
	private String content;
	private boolean approved;
	
	public Petition(int peid, UserDetails creator, Date date, String content, boolean approved) 
	{
		this.peid = peid;
		this.creator = creator;
		this.date = date;
		this.content = content;
		this.approved = approved;
	}

	public int getPeid() {
		return peid;
	}

	public void setPeid(int peid) {
		this.peid = peid;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public boolean isApproved() {
		return approved;
	}

	public void setApproved(boolean approved) {
		this.approved = approved;
	}

	public UserDetails getCreator() {
		return creator;
	}

	public void setCreator(UserDetails creator) {
		this.creator = creator;
	}
	
	
	
}
