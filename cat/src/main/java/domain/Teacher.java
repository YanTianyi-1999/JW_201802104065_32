//201802104065闫天意
package domain;

import java.io.Serializable;

public final class Teacher implements Comparable<Teacher>,Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private String no;
	private ProfTitle profTitle;
	private Degree degree;
	private Department department;

	public Teacher(Integer id,
				   String name,
				   ProfTitle profTitle,
				   Degree degree,
				   Department department,
				   String no) {
		this(name, profTitle, degree, department,no);
		this.id = id;
	}
	public Teacher(
			String name,
			ProfTitle profTitle,
			Degree degree,
			Department department,
			String no) {
		this.name = name;
		this.profTitle = profTitle;
		this.degree = degree;
		this.department = department;
		this.no=no;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ProfTitle getProfTitle() {
		return this.profTitle;
	}

	public void setProfTitle(ProfTitle profTitle) {
		this.profTitle = profTitle;
	}

	public Degree getDegree() {
		return degree;
	}

	public void setDegree(Degree degree) {
		this.degree = degree;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public int compareTo(Teacher o) {
		// TODO Auto-generated method stub
		return this.id-o.getId();
	}
}
