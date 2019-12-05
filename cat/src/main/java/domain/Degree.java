//201802104065闫天意
package domain;

import java.io.Serializable;

public final class Degree implements
		Comparable<Degree>,Serializable{
	private Integer id;
	private String description;
	private String no;
	private String remarks;
	public Degree(Integer id, String description, String no, String remarks) {
		this(description, no, remarks);
		this.id = id;
	}
	public Degree(String description, String no, String remarks) {
		this.description = description;
		this.no = no;
		this.remarks = remarks;
	}

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getNo() {
		return no;
	}


	public void setNo(String no) {
		this.no = no;
	}


	public String getRemarks() {
		return remarks;
	}


	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Override
	public int compareTo(Degree o) {
		return this.id - o.getId();
	}

	
}
