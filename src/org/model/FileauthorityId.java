package org.model;

/**
 * FileauthorityId entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class FileauthorityId implements java.io.Serializable {

	// Fields

	private Integer fileId;
	private Integer departmentNo;

	// Constructors

	/** default constructor */
	public FileauthorityId() {
	}

	/** full constructor */
	public FileauthorityId(Integer fileId, Integer departmentNo) {
		this.fileId = fileId;
		this.departmentNo = departmentNo;
	}

	// Property accessors

	public Integer getFileId() {
		return this.fileId;
	}

	public void setFileId(Integer fileId) {
		this.fileId = fileId;
	}

	public Integer getDepartmentNo() {
		return this.departmentNo;
	}

	public void setDepartmentNo(Integer departmentNo) {
		this.departmentNo = departmentNo;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof FileauthorityId))
			return false;
		FileauthorityId castOther = (FileauthorityId) other;

		return ((this.getFileId() == castOther.getFileId()) || (this
				.getFileId() != null
				&& castOther.getFileId() != null && this.getFileId().equals(
				castOther.getFileId())))
				&& ((this.getDepartmentNo() == castOther.getDepartmentNo()) || (this
						.getDepartmentNo() != null
						&& castOther.getDepartmentNo() != null && this
						.getDepartmentNo().equals(castOther.getDepartmentNo())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getFileId() == null ? 0 : this.getFileId().hashCode());
		result = 37
				* result
				+ (getDepartmentNo() == null ? 0 : this.getDepartmentNo()
						.hashCode());
		return result;
	}

}