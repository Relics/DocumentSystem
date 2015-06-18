package org.dao.impl;

import java.util.List;

import org.dao.FileDao;
import org.dao.FileauthorityDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.model.File1;
import org.util.*;

public class FileDaoImp implements FileDao {

	public void save(File1 file) {
		Session session = HibernateSessionFactory.getSession();
		Transaction tran = session.beginTransaction();
		session.saveOrUpdate(file);
		tran.commit();
		HibernateSessionFactory.closeSession();
	}
	public File1 getOneFile(String fileName){
		try{
			Session session=org.util.HibernateSessionFactory.getSession();
			Transaction ts=session.beginTransaction();
			Query query=session.createQuery("from File1 where fileName like :fileName");
			query.setString("fileName","%" + fileName + "%");
			//query.setParameter(0, fileName);
			//query.setMaxResults(1);
			List<File1> file=(List<File1>) query.list();
			ts.commit();
			session.clear();
			return file.get(file.size()-1);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	public File1 getOneFile(int fileId){
		Session session=org.util.HibernateSessionFactory.getSession();
		Transaction ts=session.beginTransaction();
		Query query=session.createQuery("from File1 where fileId=?");
		query.setParameter(0, fileId);
		query.setMaxResults(1);
		File1 file=(File1) query.uniqueResult();
		ts.commit();
		session.clear();
		if(file!=null){
			return file;
		}else{
			return null;
		}
	}
	
	public List getFileListByName(String fileName){
		Session session=org.util.HibernateSessionFactory.getSession();
		Transaction ts=session.beginTransaction();
		Query query=session.createQuery("from File1 where kind<>? and fileName like :fileName order by modifiedDate DESC");
		query.setString("fileName","%" + fileName + "%");
		query.setParameter(0, "文件夹");
//		Query query=session.createQuery("from File1 where fileName=? order by DESC");
//		query.setParameter(0, fileName);
		//query.setMaxResults(1);
		//File1 file=(File1) query.uniqueResult();
		List<File1> list=query.list();
		ts.commit();
		session.clear();
		if(list!=null){
			return list;
		}else{
			return null;
		}
	}
	//修改
	public List getAll(int ownPeopleId,int pageNow,int pageSize) {
		try{
			Session session=org.util.HibernateSessionFactory.getSession();
			Transaction ts=session.beginTransaction();
			Query query=session.createQuery("from File1 where ownPeopleId=? and kind=? order by modifiedDate DESC");
			query.setParameter(0, ownPeopleId);
			query.setParameter(1, "文件夹");
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
	//新增
	public List getMyFile(int peopleId,String path,int pageNow,int pageSize){
		try{
			Session session=org.util.HibernateSessionFactory.getSession();
			Transaction ts=session.beginTransaction();
			Query query=session.createQuery("from File1 where ownPeopleId=? and kind<>? and filePath=? order by modifiedDate DESC");
			query.setParameter(0, peopleId);
			query.setParameter(1, "文件夹");
			query.setParameter(2,path);
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
	
	//新增
	public List getFileByPath(String path,int peopleId){
		try{
			Session session=org.util.HibernateSessionFactory.getSession();
			Transaction ts=session.beginTransaction();
			Query query=session.createQuery("from File1 where ownPeopleId=? and kind<>? and filePath=?");
			query.setParameter(0, peopleId);
			query.setParameter(1, "文件夹");
			query.setParameter(2,path);
//			int firstResult=(pageNow-1)*pageSize;
//			query.setFirstResult(firstResult);
//			query.setMaxResults(pageSize);
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
	
	public int findSize(int ownPeopleId){
		try{
			Session session=org.util.HibernateSessionFactory.getSession();
			Transaction ts=session.beginTransaction();
			Query query=session.createQuery("from File1 where ownPeopleId=? order by modifiedDate DESC");
			query.setParameter(0, ownPeopleId);
			//int firstResult=(pageNow-1)*pageSize;
			//query.setFirstResult(firstResult);
			//query.setMaxResults(pageSize);
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
	
	public int findSize(){
		try{
			Session session=org.util.HibernateSessionFactory.getSession();
			Transaction ts=session.beginTransaction();
			Query query=session.createQuery("from File1 order by modifiedDate DESC");
			//query.setParameter(0, ownPeopleId);
			//int firstResult=(pageNow-1)*pageSize;
			//query.setFirstResult(firstResult);
			//query.setMaxResults(pageSize);
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
	
	public List getALLByDepartNo(int departmentNo){
		try{
			Session session=org.util.HibernateSessionFactory.getSession();
			Transaction ts=session.beginTransaction();
			Query query=session.createQuery("select a from File1 a,Fileauthority b where a.fileId=b.id.fileId and b.id.departmentNo=? and b.isViewable=1 and a.kind<>? order by a.modifiedDate DESC");
			query.setParameter(0, departmentNo);
			query.setParameter(1, "文件夹");
			List list=query.list();
			ts.commit();
			return list;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	public List getALLByDepartNo(int departmentNo,String path){
		try{
			Session session=org.util.HibernateSessionFactory.getSession();
			Transaction ts=session.beginTransaction();
			Query query=session.createQuery("select a from File1 a,Fileauthority b where a.fileId=b.id.fileId and b.id.departmentNo=? and b.isViewable=1 and a.filePath=? order by a.modifiedDate DESC");
			query.setParameter(0, departmentNo);
			query.setParameter(1, path);
			List list=query.list();
			ts.commit();
			return list;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	public List getAllFolder(int departNo){
		try{
			Session session=org.util.HibernateSessionFactory.getSession();
			Transaction ts=session.beginTransaction();
			Query query=session.createQuery("select a from File1 a where a.kind=? and a.ownDepartNo=? order by a.modifiedDate DESC");
			query.setParameter(0, "文件夹");
			query.setParameter(1, departNo);
			List list=query.list();
			ts.commit();
			return list;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	public void delete(int fileId){
		try{
			Session session=org.util.HibernateSessionFactory.getSession();
			Transaction ts=session.beginTransaction();
			Query query=session.createQuery("from File1 a where a.fileId=?");
			query.setParameter(0, fileId);
			
			File1 file=(File1) query.uniqueResult();
			session.delete(file);
			ts.commit();
			session.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	//新增
	public void deleteFolder(String path,int peopleId){
		try{
			Session session=org.util.HibernateSessionFactory.getSession();
			Transaction ts=session.beginTransaction();
			Query query=session.createQuery("from File1 a where a.filePath=? and ownPeopleId=?");
			query.setParameter(0, path);
			query.setParameter(1, peopleId);
			List<File1> fileList=query.list();
			FileauthorityDao fileauthorityDao=new FileauthorityDaoImp();
			for(int i=0;i<fileList.size();i++){
				
				Query query1=session.createQuery("from Fileauthority a where a.id.fileId=?");
				query1.setParameter(0, fileList.get(i).getFileId());				
				List<File1> list=(List<File1>) query1.list();
				for(int j=0;j<list.size();j++)
				{
					session.delete(list.get(j));
				}
				session.delete(fileList.get(i));
			}			
			ts.commit();
			session.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public List getFileForLeader(int departNo,int pageNow,int pageSize){
		try{
			Session session=org.util.HibernateSessionFactory.getSession();
			Transaction ts=session.beginTransaction();
			Query query=session.createQuery("select a from File1 a where a.ownDepartNo=? order by a.modifiedDate DESC");
			query.setParameter(0, departNo);
			int firstResult=(pageNow-1)*pageSize;
			query.setFirstResult(firstResult);
			query.setMaxResults(pageSize);
			List list=query.list();
			ts.commit();
			return list;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	public List getFileForLeader(int departNo,String path,int pageNow,int pageSize){
		try{
			Session session=org.util.HibernateSessionFactory.getSession();
			Transaction ts=session.beginTransaction();
			Query query=session.createQuery("select a from File1 a where a.ownDepartNo=? and a.filePath=? and a.kind<>? order by a.modifiedDate DESC");
			query.setParameter(0, departNo);
			query.setParameter(1, path);
			query.setParameter(2, "文件夹");
			int firstResult=(pageNow-1)*pageSize;
			query.setFirstResult(firstResult);
			query.setMaxResults(pageSize);
			List list=query.list();
			ts.commit();
			return list;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	public int getSizeForLeader(int departNo){
		try{
			Session session=org.util.HibernateSessionFactory.getSession();
			Transaction ts=session.beginTransaction();
			Query query=session.createQuery("select a from File1 a where a.ownDepartNo=? and a.kind<>? order by a.modifiedDate DESC");
			query.setParameter(0, departNo);
			query.setParameter(1, "文件夹");
			//int firstResult=(pageNow-1)*pageSize;
			//query.setFirstResult(firstResult);
			//query.setMaxResults(pageSize);
			List list=query.list();
			ts.commit();
			return list.size();
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}
	}
	
	public List getAllFromDepartNo(int departmentNo){
		try{
			Session session=org.util.HibernateSessionFactory.getSession();
			Transaction ts=session.beginTransaction();
			Query query=session.createQuery("select a from File1 a,Fileauthority b where a.fileId=b.id.fileId and b.id.departmentNo=? and b.isViewable=1 and a.ownDepartNo=? and a.kind<>? order by a.modifiedDate DESC");
			query.setParameter(0, departmentNo);
			query.setParameter(1, departmentNo);
			query.setParameter(2, "文件夹");
			List list=query.list();
			ts.commit();
			return list;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	//修改，删除了a.depatNo
	public List getAllFromDepartNo(int departmentNo,String path){
		try{
			Session session=org.util.HibernateSessionFactory.getSession();
			Transaction ts=session.beginTransaction();
			Query query=session.createQuery("select a from File1 a,Fileauthority b where a.fileId=b.id.fileId and b.id.departmentNo=? and b.isViewable=1 and a.kind<>? and a.filePath=? order by a.modifiedDate DESC");
			query.setParameter(0, departmentNo);
			//query.setParameter(1, departmentNo);
			query.setParameter(1, "文件夹");
			query.setParameter(2, path);
			List list=query.list();
			ts.commit();
			return list;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	public int getSizeForOther(int departNo){
		try{
			Session session=org.util.HibernateSessionFactory.getSession();
			Transaction ts=session.beginTransaction();
			Query query=session.createQuery("select a from File1 a,Fileauthority b where a.fileId=b.id.fileId and b.id.departmentNo=? and b.isViewable=1 and a.ownDepartNo=? order by a.modifiedDate DESC");
			query.setParameter(0, departNo);
			query.setParameter(1, departNo);
			List list=query.list();
			ts.commit();
			return list.size();
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}
	}
	
	public List getAbsoluteAll(int pageNow,int pageSize){
		try{
			Session session=org.util.HibernateSessionFactory.getSession();
			Transaction ts=session.beginTransaction();
			Query query=session.createQuery("from File1 where kind<>? order by modifiedDate DESC");
			query.setParameter(0, "文件夹");
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

}
