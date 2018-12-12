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
	private int old;
	@OneToOne
	private int pid;

	public int getOld() {
		return old;
	}

	public void setOld(int old) {
		this.old = old;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getOpt() {
		return opt;
	}

	public void setOpt(String opt) {
		this.opt = opt;
	}

	public Option(int old, int pid, String opt) {
		super();
		this.old = old;
		this.pid = pid;
		this.opt = opt;
	}

	private String opt;
}
