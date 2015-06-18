package org.dao.impl;

import java.util.List;

import org.dao.FileauthorityDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.model.File1;
import org.model.Fileauthority;
import org.util.HibernateSessionFactory;

public class FileauthorityDaoImp implements FileauthorityDao {

	public void save(Fileauthority fileauthority) {
		// TODO Auto-generated method stub
		Session session = HibernateSessionFactory.getSession();
		Transaction tran = session.beginTransaction();
		session.saveOrUpdate(fileauthority);
		tran.commit();
		HibernateSessionFactory.closeSession();
	}
	public List getFileList(int fileId){
		try{
			Session session=org.util.HibernateSessionFactory.getSession();
			Transaction ts=session.beginTransaction();
			Query query=session.createQuery("from Fileauthority a where a.id.fileId=?");
			query.setParameter(0, fileId);
			List list=query.list();
			ts.commit();
			HibernateSessionFactory.closeSession();
			return list;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	public Fileauthority getAuthority(int fileId,int departNo){
		try{
			Session session=org.util.HibernateSessionFactory.getSession();
			Transaction ts=session.beginTransaction();
			Query query=session.createQuery("from Fileauthority a where a.id.fileId=? and a.id.departmentNo=?");
			query.setParameter(0, fileId);
			query.setParameter(1, departNo);
			Fileauthority a=(Fileauthority) query.uniqueResult();
			ts.commit();
			HibernateSessionFactory.closeSession();
			return a;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	//ÐÂÔö
	public void delete(int fileId){
		try{
			Session session=org.util.HibernateSessionFactory.getSession();
			Transaction ts=session.beginTransaction();
			Query query=session.createQuery("from Fileauthority a where a.id.fileId=?");
			query.setParameter(0, fileId);
			
			List<File1> fileList=(List<File1>) query.list();
			for(int i=0;i<fileList.size();i++)
			{
				session.delete(fileList.get(i));
			}
			ts.commit();
			session.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
