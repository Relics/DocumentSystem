package org.tool;

import java.io.UnsupportedEncodingException;

public class GetFileName {

	public GetFileName(){
		
	}
	
	public String getFileName(String filename){
		String temp=filename.substring(13, filename.length());
		return temp;
	}
	public String fullFileName(String filename,String date){
		return date+filename;
	}
	
	public String getDownloadChineseFileName(String filename){
		String downloadChineseFileName=filename;
		try{
			downloadChineseFileName=new String(downloadChineseFileName.getBytes(),"ISO8859-1");
		}catch(UnsupportedEncodingException e){
			e.printStackTrace();
		}
		return downloadChineseFileName;
	}
}
