package org.action;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Administrator
 */
import java.util.Map;
import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.dao.PeopleDao;
import org.dao.impl.PeopleDaoImp;
import org.model.People;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class EmailAction  extends ActionSupport{

    public String emailTo;      //收件人邮箱地址
    public String emailFrom;    //发件人邮箱地址
    public String password;     //发件人邮箱密码
    public String subject="";      //邮件主题
    public String content;      //邮件内容
    public String smtpStyle;    //邮箱的smtp类型

	private String message;
    //设置smtp的类型
    public void setEmailStyle(){
        String emailFrom2=this.emailFrom;
        String style=emailFrom2.substring(emailFrom2.indexOf('@')+1, emailFrom2.indexOf('.'));
        this.smtpStyle="smtp."+style+".com";
    }
    
    public EmailAction() {
        emailTo = "";
        emailFrom = "buptgogame@163.com";
        password = "buptgogame123";
        content = "";
        setEmailStyle();
    }

    public String disFeedback(){
    	return SUCCESS;
    }
    public void SendEmailTest(String subject,String content,String emailTo) throws Exception{
    	Properties props = new Properties();
        props.put("mail.smtp.host", smtpStyle);
        props.put("mail.smtp.auth", "true"); // 

        Session sendMailSession = Session.getInstance(props, null);

        
            Transport transport = sendMailSession.getTransport("smtp");
            //根据邮箱地址和密码连接邮箱
            transport.connect(smtpStyle, emailFrom, password);
            Message newMessage = new MimeMessage(sendMailSession);

            // 设置mail主题
            newMessage.setSubject(subject);

            // 设置发信人地址
            String strFrom = new String(emailFrom.getBytes(), "iso-8859-1");
            newMessage.setFrom(new InternetAddress(strFrom));
			
            Address addressTo[] = {new InternetAddress(emailTo)};
            newMessage.setRecipients(Message.RecipientType.TO, addressTo);

            // 设置mail正文
            newMessage.setSentDate(new java.util.Date());
            newMessage.setText(content);

            newMessage.saveChanges(); // 保存发送信息
            transport.sendMessage(newMessage, newMessage
                    .getRecipients(Message.RecipientType.TO)); // 发送邮件

            transport.close();
            // Transport.send(newMessage);

    }

    public String feedback(){
    	 System.out.println("feedback");
    	 EmailAction SEmail = new EmailAction();
         SEmail.emailTo="buptgogame@163.com";
         try{
        	 SEmail.SendEmailTest(subject,content,"buptgogam@163.com");
        	 System.out.println("success");
        	 Map session=(Map)ActionContext.getContext().getSession();
        	 session.put("emailMessage", message);
         	 return SUCCESS;
         }
         catch(Exception e){
        	 Map request = (Map) ActionContext.getContext().get("request");
 			message="1";
 			request.put("emailMessage", message);
        	 return ERROR;
         }
    }
    
    public People people;
	
    
}
