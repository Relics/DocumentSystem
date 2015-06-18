package org.action;

import java.util.List;
import java.util.Map;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.dao.FileDao;
import org.dao.PeopleDao;
import org.dao.impl.FileDaoImp;
import org.dao.impl.PeopleDaoImp;
import org.model.File1;
import org.model.People;
import org.tool.Pager;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class PeopleAction extends ActionSupport{
	private People people = new People();
	private People people1 = new People();
	private People people2 = new People();
	private List<File> upload;
	private String searchName;
	private String searchType;
	
	private int pageSize = 8;
	private int pageNow = 1;
	
	public People getPeople() {
		return this.people;
	}

	public void setPeople(People people) {
		this.people = people;
	}	

	public People getPeople1() {
		return this.people1;
	}

	public void setPeople1(People people1) {
		this.people1 = people1;
	}
	
	public People getPeople2() {
		return this.people2;
	}

	public void setPeople2(People people2) {
		this.people2 = people2;
	}
	
	public List<File> getUpload() {
		return upload;
	}

	public void setUpload(List<File> upload) {
		this.upload = upload;
	}
	
	public String getSearchName() {
		return searchName;
	}

	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}
	
	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
		
	public int getPageSize() {
		return this.pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNow() {
		return this.pageNow;
	}

	public void setPageNow(int pageNow) {
		this.pageNow = pageNow;
	}
	
	public String saveAdd() throws Exception {
		PeopleDao peopleDao = new PeopleDaoImp();
	
		if(upload != null){
			DateFormat format2 = new SimpleDateFormat("yyyyMMddHHmmss");
			String reTime = format2.format(new Date(System.currentTimeMillis()));
			InputStream is = new FileInputStream(upload.get(0));
			OutputStream os = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\尹庭广\\Document\\Document_system\\WebRoot\\userPhoto\\" + reTime);
			byte buffer[] = new byte[1024];
			int count = 0;
			while ((count = is.read(buffer)) > 0) {
				os.write(buffer, 0, count);
			}
			os.close();
			is.close();
			
			people.setPhoto("userPhoto/" + reTime);
		}
		peopleDao.save(people);

		Map request = (Map) ActionContext.getContext().get("request");
		
		List<People> allUser;
		Pager page;
		allUser = peopleDao.getAbsoluteAll(pageNow, pageSize);
		page = new Pager(getPageNow(), peopleDao.findSize());

		// 保存
		request.put("allUser", allUser);
		request.put("page", page);		
		return SUCCESS;
	}
	
	public String disUser() throws Exception {
		PeopleDao peopleDao = new PeopleDaoImp();
		Map request = (Map) ActionContext.getContext().get("request");
		
		List<People> allUser;
		Pager page;
		allUser = peopleDao.getAbsoluteAll(pageNow, pageSize);
		page = new Pager(getPageNow(), peopleDao.findSize());

		// 保存
		request.put("allUser", allUser);
		request.put("page", page);
		return SUCCESS;
	}
	
	public String check() throws Exception {
		PeopleDao peopleDao = new PeopleDaoImp();
		Map request = (Map) ActionContext.getContext().get("request");
		
		List allInfo;
		allInfo = peopleDao.check(people.getPeopleId());

		// 保存
		request.put("allInfo", allInfo);
		return SUCCESS;
	}
	
	public String edit() throws Exception {
		//这个和check函数是一样的
		PeopleDao peopleDao = new PeopleDaoImp();
		Map request = (Map) ActionContext.getContext().get("request");
		
		List allInfo;
		allInfo = peopleDao.check(people1.getPeopleId());

		// 保存
		request.put("allInfo", allInfo);
		return SUCCESS;
	}

	public String saveEdit() throws Exception {
		PeopleDao peopleDao = new PeopleDaoImp();
	
		if(upload != null){
			DateFormat format2 = new SimpleDateFormat("yyyyMMddHHmmss");
			String reTime = format2.format(new Date(System.currentTimeMillis()));
			InputStream is = new FileInputStream(upload.get(0));
			OutputStream os = new FileOutputStream("D:\\文件\\大三下\\软件过程改进\\第五次\\尹庭广\\Document\\Document_system\\WebRoot\\userPhoto\\" + reTime);
			byte buffer[] = new byte[1024];
			int count = 0;
			while ((count = is.read(buffer)) > 0) {
				os.write(buffer, 0, count);
			}
			os.close();
			is.close();
			
			people1.setPhoto("userPhoto/" + reTime);
		}
		peopleDao.update(people1);
		

		Map request = (Map) ActionContext.getContext().get("request");
		
		List<People> allUser;
		Pager page;
		allUser = peopleDao.getAbsoluteAll(pageNow, pageSize);
		page = new Pager(getPageNow(), peopleDao.findSize());

		// 保存
		request.put("allUser", allUser);
		request.put("page", page);
		return SUCCESS;
	}

	public String savePersonalEdit() throws Exception {
		PeopleDao peopleDao = new PeopleDaoImp();
	
		if(upload != null){
			DateFormat format2 = new SimpleDateFormat("yyyyMMddHHmmss");
			String reTime = format2.format(new Date(System.currentTimeMillis()));
			InputStream is = new FileInputStream(upload.get(0));
			OutputStream os = new FileOutputStream("D:\\文件\\大三下\\软件过程改进\\第五次\\尹庭广\\Document\\Document_system\\WebRoot\\userPhoto\\" + reTime);
			byte buffer[] = new byte[1024];
			int count = 0;
			while ((count = is.read(buffer)) > 0) {
				os.write(buffer, 0, count);
			}
			os.close();
			is.close();
			
			people1.setPhoto("userPhoto/" + reTime);
		}
		
		peopleDao.update(people1);
		

		Map request = (Map) ActionContext.getContext().get("request");
		// 保存
		request.put("allInfo", people1);
		return SUCCESS;
	}
	
	public String delete() throws Exception {
		PeopleDao peopleDao = new PeopleDaoImp();
		peopleDao.delete(people2.getPeopleId());

		Map request = (Map) ActionContext.getContext().get("request");
		
		List<People> allUser;
		Pager page;
		allUser = peopleDao.getAbsoluteAll(pageNow, pageSize);
		page = new Pager(getPageNow(), peopleDao.findSize());

		// 保存
		request.put("allUser", allUser);
		request.put("page", page);
		return SUCCESS;
	}
	
	public String personalCheck() throws Exception{
		Map session = (Map) ActionContext.getContext().getSession();
		People people3 = (People) session.get("user");
		
		PeopleDao peopleDao = new PeopleDaoImp();
		Map request = (Map) ActionContext.getContext().get("request");
		
		List allInfo;
		allInfo = peopleDao.check(people3.getPeopleId());

		// 保存
		request.put("allInfo", allInfo);
		return SUCCESS;
	}	

	public String personalEdit() throws Exception{
		Map session = (Map) ActionContext.getContext().getSession();
		People people3 = (People) session.get("user");
		
		PeopleDao peopleDao = new PeopleDaoImp();
		Map request = (Map) ActionContext.getContext().get("request");
		
		List allInfo;
		allInfo = peopleDao.check(people3.getPeopleId());

		// 保存
		request.put("allInfo1", allInfo);
		return SUCCESS;
	}	
	
	public String searchUser() throws Exception {
		PeopleDao peopleDao = new PeopleDaoImp();
		List<People> searchList;
		searchList = peopleDao.getSearchResult(searchName,searchType);

		Pager page;
		page = new Pager(getPageNow(), searchList.size());
		
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("searchList", searchList);
		request.put("page", page);
		return SUCCESS;
	}
}
