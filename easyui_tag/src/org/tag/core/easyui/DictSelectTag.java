package org.tag.core.easyui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.commons.lang.StringUtils;

/**
 * 
 * 选择下拉框
 * 
 * @author: lianglaiyang
 * @date： 日期：2013-04-18
 * @version 1.0
 */
public class DictSelectTag extends TagSupport {

	private static final long serialVersionUID = 1;
	private String typeGroupCode; // 数据字典类型
	private String field; // 选择表单的Name EAMPLE:<select name="selectName" id = ""
							// />
	private String id; // 选择表单ID EAMPLE:<select name="selectName" id = "" />
	private String defaultVal; // 默认值
	private String divClass; // DIV样式
	private String labelClass; // Label样式
	private String title; // label显示值
	private boolean hasLabel = true; // 是否显示label
	private String type;// 控件类型select|radio|checkbox
	private String dictTable;// 自定义字典表
	private String dictField;// 自定义字典表的匹配字段-字典的编码值
	private String dictText;// 自定义字典表的显示文本-字典的显示值
	private String extendParams;//扩展参数


//	@Autowired
//	private static SystemService systemService;

	public int doStartTag() throws JspTagException {
		return EVAL_PAGE;
	}

	public int doEndTag() throws JspTagException {
		try {
			JspWriter out = this.pageContext.getOut();
			out.print(end().toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return EVAL_PAGE;
	}

	public StringBuffer end() {
		StringBuffer sb = new StringBuffer();
		if (StringUtils.isBlank(divClass)) {
			divClass = "form"; // 默认form样式
		}
		if (StringUtils.isBlank(labelClass)) {
			labelClass = "Validform_label"; // 默认label样式
		}
		if (dictTable != null) {
			List<Map<String, Object>> list = queryDic();
			if ("radio".equals(type)) {
				for (Map<String, Object> map : list) {
					radio(map.get("text").toString(), map.get("field")
							.toString(), sb);
				}
			} else if ("checkbox".equals(type)) {
				for (Map<String, Object> map : list) {
					checkbox(map.get("text").toString(), map.get("field")
							.toString(), sb);
				}
			} else if("text".equals(type)){
				for (Map<String, Object> map : list) {
					text(map.get("text").toString(), map.get("field")
							.toString(), sb);
				}
			}else {
				sb.append("<select name=\"" + field + "\"");
				//增加扩展属性
				if (!StringUtils.isBlank(this.extendParams)) {
//					Gson gson = new Gson();
//					Map<String, String> mp = gson.fromJson(extendParams, Map.class);
//					for(Map.Entry<String, String> entry: mp.entrySet()) { 
//						sb.append(entry.getKey()+"=\"" + entry.getValue() + "\"");
//						} 
				}
				if (!StringUtils.isBlank(this.id)) {
					sb.append(" id=\"" + id + "\"");
				}
				sb.append(">");
				for (Map<String, Object> map : list) {
					select(map.get("text").toString(), map.get("field")
							.toString(), sb);
				}
				sb.append("</select>");
			}
		} else {
		/*	TSTypegroup typeGroup = TSTypegroup.allTypeGroups
					.get(this.typeGroupCode.toLowerCase());
			List<TSType> types = TSTypegroup.allTypes.get(this.typeGroupCode
					.toLowerCase());
			if (hasLabel) {
				sb.append("<div class=\"" + divClass + "\">");
				sb.append("<label class=\"" + labelClass + "\" >");
			}
			if (typeGroup != null) {
				if (hasLabel) {
					if (StringUtils.isBlank(this.title)) {
						this.title = typeGroup.getTypegroupname();
					}
					sb.append(this.title + ":");
					sb.append("</label>");
				}
				if ("radio".equals(type)) {
					for (TSType type : types) {
						radio(type.getTypename(), type.getTypecode(), sb);
					}
				} else if ("checkbox".equals(type)) {
					for (TSType type : types) {
						checkbox(type.getTypename(), type.getTypecode(), sb);
					}
				}else if ("text".equals(type)) {
					for (TSType type : types) {
						text(type.getTypename(), type.getTypecode(), sb);
					}
				} else {
					sb.append("<select name=\"" + field + "\"");
					//增加扩展属性
					if (!StringUtils.isBlank(this.extendParams)) {
						Gson gson = new Gson();
						Map<String, String> mp = gson.fromJson(extendParams, Map.class);
						for(Map.Entry<String, String> entry: mp.entrySet()) { 
							sb.append(" "+entry.getKey()+"=\"" + entry.getValue() + "\"");
							} 
					}
					if (!StringUtils.isBlank(this.id)) {
						sb.append(" id=\"" + id + "\"");
					}
					sb.append(">");
					for (TSType type : types) {
						select(type.getTypename(), type.getTypecode(), sb);
					}

					sb.append("</select>");
				}
				if (hasLabel) {
					sb.append("</div>");
				}
			}*/
		}

		return sb;
	}
	/**
	 * 文本框方法
	 * @param name
	 * @param code
	 * @param sb
	 */
	private void text(String name, String code, StringBuffer sb) {
		if (code.equals(this.defaultVal)) {
			sb.append("<input name='"+field+"'"+" id='"+id+"' value='"+name+"' readOnly = 'readOnly' />");
		} else {
		}
	}


	/**
	 * 单选框方法
	 * 
	 * @作者：Alexander
	 * 
	 * @param name
	 * @param code
	 * @param sb
	 */
	private void radio(String name, String code, StringBuffer sb) {
		if (code.equals(this.defaultVal)) {
			sb.append("<input type=\"radio\" name=\"" + field
					+ "\" checked=\"checked\" value=\"" + code + "\"");
			if (!StringUtils.isBlank(this.id)) {
				sb.append(" id=\"" + id + "\"");
			}
			sb.append(" />");
		} else {
			sb.append("<input type=\"radio\" name=\"" + field + "\" value=\""
					+ code + "\"");
			if (!StringUtils.isBlank(this.id)) {
				sb.append(" id=\"" + id + "\"");
			}
			sb.append(" />");
		}
		sb.append(name);
	}

	/**
	 * 复选框方法
	 * 
	 * @作者：Alexander
	 * 
	 * @param name
	 * @param code
	 * @param sb
	 */
	private void checkbox(String name, String code, StringBuffer sb) {
		String[] values = this.defaultVal.split(",");
		Boolean checked = false;
		for (int i = 0; i < values.length; i++) {
			String value = values[i];
			if (code.equals(value)) {
				checked = true;
				break;
			}
			checked = false;
		}
		if(checked){
			sb.append("<input type=\"checkbox\" name=\"" + field
					+ "\" checked=\"checked\" value=\"" + code + "\"");
			if (!StringUtils.isBlank(this.id)) {
				sb.append(" id=\"" + id + "\"");
			}
			sb.append(" />");
		} else {
			sb.append("<input type=\"checkbox\" name=\"" + field
					+ "\" value=\"" + code + "\"");
			if (!StringUtils.isBlank(this.id)) {
				sb.append(" id=\"" + id + "\"");
			}
			sb.append(" />");
		}
		sb.append(name);
	}

	/**
	 * 选择框方法
	 * 
	 * @作者：Alexander
	 * 
	 * @param name
	 * @param code
	 * @param sb
	 */
	private void select(String name, String code, StringBuffer sb) {
		if (code.equals(this.defaultVal)) {
			sb.append(" <option value=\"" + code + "\" selected=\"selected\">");
		} else {
			sb.append(" <option value=\"" + code + "\">");
		}
		sb.append(name);
		sb.append(" </option>");
	}

	/**
	 * 查询自定义数据字典
	 * 
	 * @作者：Alexander
	 */
	private List<Map<String, Object>> queryDic() {
//		String sql = "select " + dictField + " as field," + dictText
//				+ " as text from " + dictTable;
//		systemService = ApplicationContextUtil.getContext().getBean(
//				SystemService.class);
//		List<Map<String, Object>> list = systemService.findForJdbc(sql);
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();//update by li.le
		return list;
	}

	public String getTypeGroupCode() {
		return typeGroupCode;
	}

	public void setTypeGroupCode(String typeGroupCode) {
		this.typeGroupCode = typeGroupCode;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDefaultVal() {
		return defaultVal;
	}

	public void setDefaultVal(String defaultVal) {
		this.defaultVal = defaultVal;
	}

	public String getDivClass() {
		return divClass;
	}

	public void setDivClass(String divClass) {
		this.divClass = divClass;
	}

	public String getLabelClass() {
		return labelClass;
	}

	public void setLabelClass(String labelClass) {
		this.labelClass = labelClass;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isHasLabel() {
		return hasLabel;
	}

	public void setHasLabel(boolean hasLabel) {
		this.hasLabel = hasLabel;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDictTable() {
		return dictTable;
	}

	public void setDictTable(String dictTable) {
		this.dictTable = dictTable;
	}

	public String getDictField() {
		return dictField;
	}

	public void setDictField(String dictField) {
		this.dictField = dictField;
	}

	public String getDictText() {
		return dictText;
	}

	public void setDictText(String dictText) {
		this.dictText = dictText;
	}
	public String getExtendParams() {
		return extendParams;
	}

	public void setExtendParams(String extendParams) {
		this.extendParams = extendParams;
	}
}
