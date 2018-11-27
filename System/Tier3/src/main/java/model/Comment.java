package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Comment 
{

	@Id
	@Column(name="Comment_Id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cmtid;
	@OneToOne
	private Post pid;
	@OneToOne
	private UserDetails writer;
	
	public Comment(int cmtid, Post pid, UserDetails writer)
	{
		this.cmtid = cmtid;
		this.pid = pid;
		this.writer = writer;
	}

	public int getCmtid() {
		return cmtid;
	}

	public void setCmtid(int cmtid) {
		this.cmtid = cmtid;
	}


	public UserDetails getWriter() {
		return writer;
	}

	public void setWriter(UserDetails writer) {
		this.writer = writer;
	}

	public Post getPid() {
		return pid;
	}

	public void setPid(Post pid) {
		this.pid = pid;
	}


	

}
