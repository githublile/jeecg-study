package org.tag.web.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.tag.core.util.FileList;

import com.alibaba.fastjson.JSONObject;

@Controller
@RequestMapping("tags")
public class EasyuiTagController {
	private String filepath="C:\\Users\\li.le\\workspace\\easyui_tag\\WebContent\\pages\\easyui_tag\\";
	
	@RequestMapping(params = "url")
	public ModelAndView easyui_tag(String url) {
		return new ModelAndView("easyui_tag/"+url);
	}
	
	@ResponseBody
	@RequestMapping(params = "list")
	public String taglist(ModelMap modelMap) {
		return JSONObject.toJSONString(FileList.getFileList(filepath));
	}
	
	
}
