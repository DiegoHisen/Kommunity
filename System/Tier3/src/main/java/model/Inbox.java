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

	public String getRcpr() {
		return rcpr;
	}

	public void setRcpr(String rcpr) {
		this.rcpr = rcpr;
	}

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public Inbox(int rid, String rcpr, int mid) {
		super();
		this.rid = rid;
		this.rcpr = rcpr;
		this.mid = mid;
	}

}
