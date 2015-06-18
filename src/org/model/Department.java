package org.model;

/**
 * Department entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Department implements java.io.Serializable {

	// Fields

	private Integer departmentNo;
	private String departmentName;

	// Constructors

	/** default constructor */
	public Department() {
	}

	/** minimal constructor */
	public Department(Integer departmentNo) {
		this.departmentNo = departmentNo;
	}

	/** full constructor */
	public Department(Integer departmentNo, String departmentName) {
		this.departmentNo = departmentNo;
		this.departmentName = departmentName;
	}

	// Property accessors

	public Integer getDepartmentNo() {
		return this.departmentNo;
	}

	public void setDepartmentNo(Integer departmentNo) {
		this.departmentNo = departmentNo;
	}

	public String getDepartmentName() {
		return this.departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

}