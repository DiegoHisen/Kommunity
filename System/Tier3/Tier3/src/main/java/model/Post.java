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
public class Post 
{

	@Id
	@Column(name = "Post_Id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int pid;
	@OneToOne
	private UserDetails creator;
	private String content;
	private String type;
	@Temporal(TemporalType.DATE)
	private Date date;
	
	public Post(int pid, UserDetails creator, String content, String type, Date date) 
	{
		this.pid = pid;
		this.creator = creator;
		this.content = content;
		this.type = type;
		this.date = date;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}


	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public UserDetails getCreator() {
		return creator;
	}

	public void setCreator(UserDetails creator) {
		this.creator = creator;
	}
	
	
	

}
