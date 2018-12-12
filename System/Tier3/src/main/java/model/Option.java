package model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

public class Option {
	@Id
	@Column(name = "Option_Id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int oid;
	@OneToOne
	private Petition pid;
	private Vote opt;

	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public Petition getPid() {
		return pid;
	}

	public void setPid(Petition pid) {
		this.pid = pid;
	}

	public Vote getOpt() {
		return opt;
	}

	public void setOpt(Vote opt) {
		this.opt = opt;
	}

	public Option(int oid, Petition pid, Vote opt) {
		super();
		this.oid = oid;
		this.pid = pid;
		this.opt = opt;
	}
}