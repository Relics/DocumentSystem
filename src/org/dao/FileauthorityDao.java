package org.dao;

import java.util.List;

import org.model.Fileauthority;

public interface FileauthorityDao {
	public void save(Fileauthority fileauthority);
	public List getFileList(int fileId);
	public Fileauthority getAuthority(int fileId,int departNo);
	
	//ÐÂÔö
	public void delete(int fileId);
}
