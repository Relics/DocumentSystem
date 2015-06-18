package org.dao;
import java.util.List;

import org.model.People;
public interface PeopleDao {
	public People validate(int peopleId,String password);
	public void save(People people);
	public void update(People people);
	public void delete(int peopleId);
	public List getAbsoluteAll(int pageNow,int pageSize);
	public int findSize();
	public List check(int peopleId);
	public List getSearchResult(String searchName,String searchType);
	
	public People findPassword(int peopleId);
	
}
