package org.model;

/**
 * People entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class People implements java.io.Serializable {

	// Fields

	private Integer peopleId;
	private String password;
	private Integer groupNo;
	private String peopleName;
	private String photo;
	private String male;
	private String bornPlace;
	private String bornYear;
	private String nation;
	private Integer departmentNo;
	private String position;
	private String email;

	// Constructors

	/** default constructor */
	public People() {
	}

	/** minimal constructor */
	public People(Integer peopleId, Integer groupNo) {
		this.peopleId = peopleId;
		this.groupNo = groupNo;
	}

	/** full constructor */
	public People(Integer peopleId, String password, Integer groupNo,
			String peopleName, String photo, String male, String bornPlace,
			String bornYear, String nation, Integer departmentNo,
			String position, String email) {
		this.peopleId = peopleId;
		this.password = password;
		this.groupNo = groupNo;
		this.peopleName = peopleName;
		this.photo = photo;
		this.male = male;
		this.bornPlace = bornPlace;
		this.bornYear = bornYear;
		this.nation = nation;
		this.departmentNo = departmentNo;
		this.position = position;
		this.email = email;
	}

	// Property accessors

	public Integer getPeopleId() {
		return this.peopleId;
	}

	public void setPeopleId(Integer peopleId) {
		this.peopleId = peopleId;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getGroupNo() {
		return this.groupNo;
	}

	public void setGroupNo(Integer groupNo) {
		this.groupNo = groupNo;
	}

	public String getPeopleName() {
		return this.peopleName;
	}

	public void setPeopleName(String peopleName) {
		this.peopleName = peopleName;
	}

	public String getPhoto() {
		return this.photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getMale() {
		return this.male;
	}

	public void setMale(String male) {
		this.male = male;
	}

	public String getBornPlace() {
		return this.bornPlace;
	}

	public void setBornPlace(String bornPlace) {
		this.bornPlace = bornPlace;
	}

	public String getBornYear() {
		return this.bornYear;
	}

	public void setBornYear(String bornYear) {
		this.bornYear = bornYear;
	}

	public String getNation() {
		return this.nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public Integer getDepartmentNo() {
		return this.departmentNo;
	}

	public void setDepartmentNo(Integer departmentNo) {
		this.departmentNo = departmentNo;
	}

	public String getPosition() {
		return this.position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}