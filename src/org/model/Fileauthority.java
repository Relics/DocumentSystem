package org.model;

/**
 * Fileauthority entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Fileauthority implements java.io.Serializable {

	// Fields

	private FileauthorityId id;
	private Integer isFolder;
	private Integer isViewable;

	// Constructors

	/** default constructor */
	public Fileauthority() {
	}

	/** minimal constructor */
	public Fileauthority(FileauthorityId id) {
		this.id = id;
	}

	/** full constructor */
	public Fileauthority(FileauthorityId id, Integer isFolder,
			Integer isViewable) {
		this.id = id;
		this.isFolder = isFolder;
		this.isViewable = isViewable;
	}

	// Property accessors

	public FileauthorityId getId() {
		return this.id;
	}

	public void setId(FileauthorityId id) {
		this.id = id;
	}

	public Integer getIsFolder() {
		return this.isFolder;
	}

	public void setIsFolder(Integer isFolder) {
		this.isFolder = isFolder;
	}

	public Integer getIsViewable() {
		return this.isViewable;
	}

	public void setIsViewable(Integer isViewable) {
		this.isViewable = isViewable;
	}

}