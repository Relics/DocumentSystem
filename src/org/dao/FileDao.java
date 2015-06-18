package org.dao;

import java.util.List;

import org.model.File1;

public interface FileDao {
	public void save(File1 file);
	public File1 getOneFile(String fileName);
	public List getAll(int ownPeopleId,int pageNow,int pageSize) ;
	public File1 getOneFile(int fileId);
	public List getALLByDepartNo(int departmentNo);
	public List getALLByDepartNo(int departmentNo,String path);
	public List getAllFromDepartNo(int departmentNo);
	public List getAllFromDepartNo(int departmentNo,String path);
	public int findSize(int a );
	public List getAbsoluteAll(int pageNow,int pageSize);
	public int findSize();
	public List getFileForLeader(int departNo,int pageNow,int PageSize);
	public List getFileForLeader(int departNo,String path,int pageNow,int PageSize);
	public int getSizeForLeader(int departNo);
	public int getSizeForOther(int departNo);
	public List getFileListByName(String fileName);
	public void delete(int fileId);
	public List getAllFolder(int departNo);
	//新增
	public List getMyFile(int peopleId,String path,int pageNow,int pageSize);
	//新增
	public List getFileByPath(String path,int peopleId);
	
	//新增
	public void deleteFolder(String path,int peopleId);
}
