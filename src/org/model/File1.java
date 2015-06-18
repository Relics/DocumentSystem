package org.model;

import java.util.Date;

/**
 * File entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class File1 implements java.io.Serializable {

	// Fields

	private Integer fileId;
	private String fileName;
	private String filePath;
	private Integer ownPeopleId;
	private Date modifiedDate;
	private String size;
	private String kind;
	private Integer ownDepartNo;
	private String peopleName;
	// Constructors

	/** default constructor */
	public File1() {
	}

	/** full constructor */
	public File1(String fileName, String filePath, Integer ownPeopleId,
			Date modifiedDate, String size, String kind,Integer ownDepartNo,String peopleName) {
		this.fileName = fileName;
		this.filePath = filePath;
		this.ownPeopleId = ownPeopleId;
		this.modifiedDate = modifiedDate;
		this.size = size;
		this.kind = kind;
		this.ownDepartNo=ownDepartNo;
		this.peopleName=peopleName;
	}

	// Property accessors

	public Integer getFileId() {
		return this.fileId;
	}

	public void setFileId(Integer fileId) {
		this.fileId = fileId;
	}

	public String getFileName() {
		return this.fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFilePath() {
		return this.filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public Integer getOwnPeopleId() {
		return this.ownPeopleId;
	}

	public void setOwnPeopleId(Integer ownPeopleId) {
		this.ownPeopleId = ownPeopleId;
	}

	public Date getModifiedDate() {
		return this.modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getSize() {
		return this.size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getKind() {
		return this.kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public Integer getOwnDepartNo(){
		return this.ownDepartNo;
	}
	
	public void setOwnDepartNo(Integer ownDepartNo){
		this.ownDepartNo=ownDepartNo;
	}
	
	public String getPeopleName(){
		return this.peopleName;
	} 
	
	public void setPeopleName(String peopleName){
		this.peopleName=peopleName;
	}
}