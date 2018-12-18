package Common;


public class Option {

	private int oid;
	private Petition pid;
	private Vote opt;

	public Option()
	{
		
	}
	
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