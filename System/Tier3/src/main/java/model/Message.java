package model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Message
{
	@Id
	@Column(name="Message_Id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int mid;
	@OneToOne
	private UserDetails senderid;
	private Date date;
	private String text;
	
	public Message(int mid, UserDetails senderid, Date date, String text) 
	{
		this.mid = mid;
		this.senderid = senderid;
		this.date = date;
		this.text = text;
	}

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}



	public UserDetails getSenderid() {
		return senderid;
	}

	public void setSenderid(UserDetails senderid) {
		this.senderid = senderid;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	
	
	
	
	

}
