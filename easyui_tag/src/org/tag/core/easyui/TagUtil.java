package org.tag.core.easyui;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.tag.core.util.StringUtil;

import com.alibaba.fastjson.JSONObject;

/**
 * 
 * 类描述：标签工具类
 * 
 * 张代浩
 * 
 * @date： 日期：2012-12-28 时间：上午09:58:00
 * @version 1.0
 */
public class TagUtil {
	/**
	 * 获取自定义函数名
	 * 
	 * @param functionname
	 * @return
	 */
	public static String getFunction(String functionname) {
		int index = functionname.indexOf("(");
		if (index == -1) {
			return functionname;
		} else {
			return functionname.substring(0, functionname.indexOf("("));
		}
	}

	/**
	 * 获取自定义函数的参数
	 * 
	 * @param functionname
	 * @return
	 */
	public static String getFunParams(String functionname) {
		int index = functionname.indexOf("(");
		String param = "";
		if (index != -1) {
			String testparam = functionname.substring(
					functionname.indexOf("(") + 1, functionname.length() - 1);
			if (StringUtil.isNotEmpty(testparam)) {
				String[] params = testparam.split(",");
				for (String string : params) {
					param += (string.indexOf("{") != -1) ? ("'\"+"
							+ string.substring(1, string.length() - 1) + "+\"',")
							: ("'\"+rec." + string + "+\"',");
				}
			}
		}
		param += "'\"+index+\"'";// 传出行索引号参数
		return param;
	}
}
