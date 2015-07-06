package org.tag.core.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.ServletRequest;
import javax.servlet.jsp.PageContext;

public class StringToFile {
	private PageContext pc;
	private String tagContent;
	private String classname;
	private String filepath;
	private ServletRequest request;

	public StringToFile(PageContext pc, String tagContent,String classname) {
		this.pc = pc;
		this.tagContent = tagContent;
		this.classname=classname;
		run();
	}
	
	
	public ServletRequest getRequest(){
		return request;
	}
	
	public void run() {
		request = pc.getRequest();
		request.setAttribute(classname, tagContent);
//		ServletContext context = request.getServletContext();
//		String contextpath = context.getContextPath();
//		String realpath = context.getRealPath(contextpath);
//		String filepath = realpath + File.separator + "tagfile"+File.separator+classname;
		
//		filepath="C:\\Users\\li.le\\workspace\\jeecg_study\\WebContent\\pages\\study_domo\\tag_file\\"+classname+".jsp";
		filepath="C:\\Users\\li.le\\workspace\\jeecg_study\\WebContent\\pages\\study_demo\\tag_file\\"+classname+".jsp";
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(filepath);
			fos.write(tagContent.getBytes("UTF-8"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
