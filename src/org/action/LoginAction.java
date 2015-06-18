package org.action;

import java.util.List;
import java.util.Map;
import org.dao.PeopleDao;
import org.dao.impl.PeopleDaoImp;
import org.model.People;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{
	private People people = new People();
	private String message;

	public String getMessage(){
		return message;
	}
	public void setMessage(String message){
		this.message=message;
	}
	public People getPeople(){
		return people;
	}
	public void setPeople(People people){
		this.people=people;
	}
	public String execute() throws Exception {
		PeopleDao peopleDao=new PeopleDaoImp();//得到Dao接口对象
		People user=peopleDao.validate(people.getPeopleId(), people.getPassword());//调用Dao中的方法
		String message="";
		if(user!=null){
		//如果不为空，保存到Session中
			Map session=(Map)ActionContext.getContext().getSession();
			session.put("user", user);
			session.put("message", message);
			return SUCCESS;
		}else{
			Map request = (Map) ActionContext.getContext().get("request");
			message="1";
			request.put("message", message);
			return ERROR;
		}
	}
	
	public String logOut()throws Exception{
		Map session=(Map)ActionContext.getContext().getSession();
		session.remove("user");
		return SUCCESS;
	}
	public String message1="0"; 
	public String findPassword1(){
		Map session=(Map)ActionContext.getContext().getSession();
		session.put("key", 0);
		return SUCCESS;
	}
	
 		public String findPassword()throws Exception{
 	    	EmailAction SEmail = new EmailAction();
 	    	PeopleDao peopleDao=new PeopleDaoImp();//得到Dao接口对象
 	 		People user=peopleDao.findPassword(people.getPeopleId());//调用Dao中的方法

 	 		if(user!=null){
 	 		//如果不为空，保存到Session中
 	 			SEmail.emailTo=user.getEmail();
 	 	        SEmail.subject="找回密码";
 	 	        SEmail.content="duang";
 	 	        SEmail.SendEmailTest("找回密码",user.getPassword(),user.getEmail()); 
 	 	        
 	 	        Map session=(Map)ActionContext.getContext().getSession();
 	 	        message1="0";
 				session.put("message1", message1);
 				session.put("key", 1);
 	 			return SUCCESS;
 	 		}else{ 
 	 			Map session=(Map)ActionContext.getContext().getSession();
 	 			message1="1";
 	 		   	session.put("message1", message1);
 	 			session.put("key", 1);
 	 			return ERROR;
 	 		}
 	    }
    }

