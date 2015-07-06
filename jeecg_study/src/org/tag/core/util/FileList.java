package org.tag.core.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileList {
	
	public static List<String> getFileList(String filepath){
		List<String> list=new ArrayList<String>();
		File file=new File(filepath);
		
		for (File f : file.listFiles()) {
			if(!f.isDirectory()){
				list.add(f.getName().replace(".jsp", ""));
			}
		}
		
		return list;
	}
	
}
