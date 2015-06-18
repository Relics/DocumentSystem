package org.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.action.FileAction;
import org.dao.FileDao;
import org.dao.impl.FileDaoImp;
import org.model.File1;
import org.model.People;
import org.tool.Pager;

import com.opensymphony.xwork2.ActionContext;

public class OnloadMyFile extends HttpServlet {
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		FileAction fileaction=new FileAction();
		try {
			Map session = (Map) ActionContext.getContext().getSession();
			People people = (People) session.get("user");
			FileDao fileDao = new FileDaoImp();
			List<File1> fileList = fileDao.getAll(people.getPeopleId(), 1,
					8);
			Map req = (Map) ActionContext.getContext().get("request");
			Pager page = new Pager(1, fileDao.findSize(people
					.getPeopleId()));
			// ±£´æ
			req.put("fileList", fileList);
			req.put("page", page);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
