package org.web.system.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.core.common.model.json.AjaxJson;
import org.core.constant.Globals;
import org.core.extend.datasource.DataSourceContextHolder;
import org.core.extend.datasource.DataSourceType;
import org.core.util.ContextHolderUtils;
import org.core.util.IpUtil;
import org.core.util.NumberComparator;
import org.core.util.ResourceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.tag.core.util.FileList;
import org.web.system.manager.ClientManager;
import org.web.system.pojo.base.Client;
import org.web.system.pojo.base.TSFunction;
import org.web.system.pojo.base.TSRole;
import org.web.system.pojo.base.TSRoleFunction;
import org.web.system.pojo.base.TSRoleUser;
import org.web.system.pojo.base.TSUser;
import org.web.system.service.SystemService;
import org.web.system.service.UserService;

import com.alibaba.fastjson.JSONObject;

@Controller
@RequestMapping("study")
public class StudyController {
	private Logger log = Logger.getLogger(StudyController.class);
	private SystemService systemService;
	private UserService userService;
	private String message = null;
	private Map<Integer, List<TSFunction>> shortcutFunctionMap = null;

	@Autowired
	public void setSystemService(SystemService systemService) {
		this.systemService = systemService;
	}

	@Autowired
	public void setUserService(UserService userService) {

		this.userService = userService;
	}
	
	private String filepath="C:\\Users\\li.le\\workspace\\jeecg_study\\WebContent\\pages\\study_demo\\";
	
	@RequestMapping(params = "url")
	public String easyui_tag(String url) {
		String param=url+"="+url;
		return "redirect:study.do?"+param;
	}
	
	@ResponseBody
	@RequestMapping(params = "list")
	public String taglist(ModelMap modelMap) {
		return JSONObject.toJSONString(FileList.getFileList(filepath));
	}
	
	
	/**
	 * 菜单跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "loginpage")
	public ModelAndView left(@RequestParam(value="loginpage") String page) {
		
		
		return new ModelAndView("study_demo/"+page);
	}
	
	
	/**
	 * 菜单跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "left")
	public ModelAndView left(@RequestParam(value="left") String page,HttpServletRequest request) {
		
		TSUser user = new TSUser();
		user.setUserName("admin");
		
		request.setAttribute("menuMap", getFunctionMap(user));
		
		return new ModelAndView("study_demo/"+page);
	}
	
	/**
	 * 获取权限的map
	 * 
	 * @param user
	 * @return
	 */
	private Map<Integer, List<TSFunction>> getFunctionMap(TSUser user) {
		Map<Integer, List<TSFunction>> functionMap = new HashMap<Integer, List<TSFunction>>();
		Map<String, TSFunction> loginActionlist = getUserFunction(user);
		if (loginActionlist.size() > 0) {
			Collection<TSFunction> allFunctions = loginActionlist.values();
			for (TSFunction function : allFunctions) {
				if (!functionMap.containsKey(function.getFunctionLevel() + 0)) {
					functionMap.put(function.getFunctionLevel() + 0,
							new ArrayList<TSFunction>());
				}
				functionMap.get(function.getFunctionLevel() + 0).add(function);
			}
			// 菜单栏排序
			Collection<List<TSFunction>> c = functionMap.values();
			for (List<TSFunction> list : c) {
				Collections.sort(list, new NumberComparator());
			}
		}
		return functionMap;
	}
	
	/**
	 * 获取用户菜单列表
	 * 
	 * @param user
	 * @return
	 */
	private Map<String, TSFunction> getUserFunction(TSUser user) {
		Map<String, TSFunction> loginActionlist = new HashMap<String, TSFunction>();
		List<TSFunction> TSFunctions = systemService.loadAll(TSFunction.class);
		
		for (TSFunction function : TSFunctions) {
			loginActionlist.put(function.getId(), function);
		}
		
		return loginActionlist;
	}
	
	
}
