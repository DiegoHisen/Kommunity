	package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Vote
{
	@Id
	@Column(name="Vote_Id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int vid;
	@OneToOne
	private UserDetails voter;
	@OneToOne
	private Petition peid;
	public Vote(int vid, UserDetails voter, Petition peid)
	{
		super();
		this.vid = vid;
		this.voter = voter;
		this.peid = peid;
	}
	
	public Vote()
	{
		
	}
	public int getVid() {
		return vid;
	}
	public void setVid(int vid) {
		this.vid = vid;
	}
	public UserDetails getVoter() {
		return voter;
	}
	public void setVoter(UserDetails voter) {
		this.voter = voter;
	}
	public Petition getPeid() {
		return peid;
	}
	public void setPeid(Petition peid) {
		this.peid = peid;
	}
	
	
	
	
	
	

}
