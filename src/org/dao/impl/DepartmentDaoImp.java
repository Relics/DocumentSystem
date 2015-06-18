package org.dao.impl;

import org.dao.DepartmentDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.model.Department;


public class DepartmentDaoImp  implements DepartmentDao{

	public Department getDepartment(int departmentNo){
		try{
			Session session=org.util.HibernateSessionFactory.getSession();
			Transaction ts=session.beginTransaction();
			Query query=session.createQuery("from Department where departmentNo=?");
			query.setParameter(0, departmentNo);
			query.setMaxResults(1);
			Department depart=(Department) query.uniqueResult();
			if(depart!=null){
				return depart;
			}else{
				return null;
			}
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
}
