package model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

public class Inbox {
	@Id
	@Column(name = "Receiver_Id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int rid;
	@OneToOne
	private UserDetails rcpr;
	@OneToOne
	private Message mid;

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	

	public UserDetails getRcpr() {
		return rcpr;
	}

	public void setRcpr(UserDetails rcpr) {
		this.rcpr = rcpr;
	}

	public Message getMid() {
		return mid;
	}

	public void setMid(Message mid) {
		this.mid = mid;
	}

	public Inbox(int rid, UserDetails rcpr, Message mid) {
		super();
		this.rid = rid;
		this.rcpr = rcpr;
		this.mid = mid;
	}
	
	public Inbox()
	{
		
	}

}
