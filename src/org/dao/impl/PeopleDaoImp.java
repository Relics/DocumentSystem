package org.dao.impl;

import java.util.List;

import org.dao.PeopleDao;
import org.model.File1;
import org.model.People;
import org.util.HibernateSessionFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PeopleDaoImp implements PeopleDao {

	public People findPassword(int peopleId) {
		// TODO Auto-generated method stub
		try{
			Session session=org.util.HibernateSessionFactory.getSession();
			Transaction ts=session.beginTransaction();
			Query query=session.createQuery("from People where peopleId=?");
			query.setParameter(0, peopleId);
			query.setMaxResults(1);
			People people=(People) query.uniqueResult();
			if(people!=null){
				return people;
			}else{
				return null;
			}
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	public People validate(int peopleId, String password) {
		// TODO Auto-generated method stub
		try{
			Session session=org.util.HibernateSessionFactory.getSession();
			Transaction ts=session.beginTransaction();
			Query query=session.createQuery("from People where peopleId=? and password=?");
			query.setParameter(0, peopleId);
			query.setParameter(1, password);
			query.setMaxResults(1);
			People people=(People) query.uniqueResult();
			if(people!=null){
				return people;
			}else{
				return null;
			}
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	public void save(People people) {
		Session session = HibernateSessionFactory.getSession();
		Transaction tran = session.beginTransaction();
		session.save(people);
		tran.commit();
		HibernateSessionFactory.closeSession();
	}
	
	public void update(People people) {
		Session session = HibernateSessionFactory.getSession();
		Transaction tran = session.beginTransaction();
		session.merge(people);
		tran.commit();
		HibernateSessionFactory.closeSession();
	}
	
	public void delete(int peopleId) {
		try{
			Session session=org.util.HibernateSessionFactory.getSession();
			Transaction ts=session.beginTransaction();
			Query query=session.createQuery("from People a where a.peopleId=?");
			query.setParameter(0, peopleId);
			
			People people=(People) query.uniqueResult();
			session.delete(people);
			ts.commit();
			session.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public List getAbsoluteAll(int pageNow,int pageSize){
		try{
			Session session=org.util.HibernateSessionFactory.getSession();
			Transaction ts=session.beginTransaction();
			Query query=session.createQuery("from People");
			//query.setParameter(0, ownPeopleId);
			int firstResult=(pageNow-1)*pageSize;
			query.setFirstResult(firstResult);
			query.setMaxResults(pageSize);
			List list=query.list();
			ts.commit();
			session.close();
			session=null;
			return list;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	public int findSize(){
		try{
			Session session=org.util.HibernateSessionFactory.getSession();
			Transaction ts=session.beginTransaction();
			Query query=session.createQuery("from People");
			List list=query.list();
			ts.commit();
			session.close();
			session=null;
			return list.size();
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}
	}
	
	public List check(int peopleId){
		try{
			Session session=org.util.HibernateSessionFactory.getSession();
			Transaction ts=session.beginTransaction();
			Query query=session.createQuery("from People where peopleId=?");
			query.setParameter(0, peopleId);
			List list=query.list();
			ts.commit();
			return list;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	public List getSearchResult(String searchName,String searchType){
		Session session=org.util.HibernateSessionFactory.getSession();
		Transaction ts=session.beginTransaction();
		
		Query query;
		List<File1> list;
		if(searchType.equals("员工号")){
			query=session.createQuery("from People where peopleID like :searchName");
			query.setString("searchName","%" + searchName + "%");
			list=query.list();		
			ts.commit();
			session.clear();
			if(list!=null){
				return list;
			}else{
				return null;
			}			
		}	
		else if(searchType.equals("密码")){
			query=session.createQuery("from People where password like :searchName");
			query.setString("searchName","%" + searchName + "%");
			list=query.list();		
			ts.commit();
			session.clear();
			if(list!=null){
				return list;
			}else{
				return null;
			}			
		}	
		else if(searchType.equals("用户组别号")){
			query=session.createQuery("from People where groupNo like :searchName");
			query.setString("searchName","%" + searchName + "%");
			list=query.list();		
			ts.commit();
			session.clear();
			if(list!=null){
				return list;
			}else{
				return null;
			}			
		}	
		else if(searchType.equals("用户名")){
			query=session.createQuery("from People where peopleName like :searchName");
			query.setString("searchName","%" + searchName + "%");
			list=query.list();		
			ts.commit();
			session.clear();
			if(list!=null){
				return list;
			}else{
				return null;
			}			
		}	
		else if(searchType.equals("性别")){
			query=session.createQuery("from People where male like :searchName");
			query.setString("searchName","%" + searchName + "%");
			list=query.list();		
			ts.commit();
			session.clear();
			if(list!=null){
				return list;
			}else{
				return null;
			}			
		}	
		else if(searchType.equals("出生地")){
			query=session.createQuery("from People where bornPlace like :searchName");
			query.setString("searchName","%" + searchName + "%");
			list=query.list();		
			ts.commit();
			session.clear();
			if(list!=null){
				return list;
			}else{
				return null;
			}			
		}	
		else if(searchType.equals("出生日期")){
			query=session.createQuery("from People where bornYear like :searchName");
			query.setString("searchName","%" + searchName + "%");
			list=query.list();		
			ts.commit();
			session.clear();
			if(list!=null){
				return list;
			}else{
				return null;
			}			
		}	
		else if(searchType.equals("民族")){
			query=session.createQuery("from People where Nation like :searchName");
			query.setString("searchName","%" + searchName + "%");
			list=query.list();		
			ts.commit();
			session.clear();
			if(list!=null){
				return list;
			}else{
				return null;
			}			
		}	
		else if(searchType.equals("所属部门编号")){
			query=session.createQuery("from People where departmentNo like :searchName");
			query.setString("searchName","%" + searchName + "%");
			list=query.list();		
			ts.commit();
			session.clear();
			if(list!=null){
				return list;
			}else{
				return null;
			}			
		}	
		else if(searchType.equals("职位")){
			query=session.createQuery("from People where position like :searchName");
			query.setString("searchName","%" + searchName + "%");
			list=query.list();		
			ts.commit();
			session.clear();
			if(list!=null){
				return list;
			}else{
				return null;
			}			
		}	
		else if(searchType.equals("电子邮箱")){
			query=session.createQuery("from People where email like :searchName");
			query.setString("searchName","%" + searchName + "%");
			list=query.list();		
			ts.commit();
			session.clear();
			if(list!=null){
				return list;
			}else{
				return null;
			}			
		}	
		
		else
			return null;
	}
}
