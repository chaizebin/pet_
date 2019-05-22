/** 
 * <pre>项目名称:easyui_user_nsj 
 * 文件名称:ResultUtil.java 
 * 包名:org.nsj.jk.utils 
 * 创建日期:2019年1月2日上午11:09:23 
 * Copyright (c) 2019, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.utils;

/** 
 * <pre>项目名称：easyui_user_nsj    
 * 类名称：ResultUtil    
 * 类描述：    
 * 创建人：南少杰  
 * 创建时间：2019年1月2日 上午11:09:23    
 * 修改人：南少杰
 * 修改时间：2019年1月2日 上午11:09:23    
 * 修改备注：       
 * @version </pre>    
 */

public class ResultUtil {

	private Integer total;
	
	private Object rows;

	

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Object getRows() {
		return rows;
	}

	public void setRows(Object rows) {
		this.rows = rows;
	}

	/* (non-Javadoc)    
	 * @see java.lang.Object#toString()    
	 */
	@Override
	public String toString() {
		return "ResultUtil [total=" + total + ", rows=" + rows + "]";
	}


	
}
