/** 
 * <pre>项目名称:ssi-service-01 
 * 文件名称:MenuService.java 
 * 包名:com.jk.service.menu 
 * 创建日期:2017年7月27日上午11:33:47 
 * Copyright (c) 2017, chenjh123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.service.menu;

import java.util.List;

import com.jk.pojo.menu.MenuRequest;
import com.jk.pojo.menu.MenuResponse;

/** 
 * <pre>项目名称：ssi-service-01    
 * 类名称：MenuService    
 * 类描述：    
 * 创建人：陈教授 chenjh123@gmail.com    
 * 创建时间：2017年7月27日 上午11:33:47    
 * 修改人：陈教授 chenjh123@gmail.com     
 * 修改时间：2017年7月27日 上午11:33:47    
 * 修改备注：       
 * @version </pre>    
 */
public interface MenuService {

	/** <pre>selectMenuListJson(这里用一句话描述这个方法的作用)   
	 * 创建人：陈教授 chenjh123@gmail.com    
	 * 创建时间：2017年7月27日 上午11:37:37    
	 * 修改人：陈教授 chenjh123@gmail.com     
	 * 修改时间：2017年7月27日 上午11:37:37    
	 * 修改备注： 
	 * @param menuRequest
	 * @return</pre>    
	 */
	List<MenuResponse> selectMenuListJson(MenuRequest menuRequest);

	/** <pre>selectFirstMenuList(这里用一句话描述这个方法的作用)   
	 * 创建人：陈教授 chenjh123@gmail.com    
	 * 创建时间：2017年7月27日 下午2:31:23    
	 * 修改人：陈教授 chenjh123@gmail.com     
	 * 修改时间：2017年7月27日 下午2:31:23    
	 * 修改备注： 
	 * @param menuRequest
	 * @return</pre>    
	 */
	List<MenuResponse> selectFirstMenuList(MenuRequest menuRequest);

	/** <pre>insertMenu(这里用一句话描述这个方法的作用)   
	 * 创建人：陈教授 chenjh123@gmail.com    
	 * 创建时间：2017年7月27日 下午2:45:17    
	 * 修改人：陈教授 chenjh123@gmail.com     
	 * 修改时间：2017年7月27日 下午2:45:17    
	 * 修改备注： 
	 * @param menuRequest</pre>    
	 */
	void insertMenu(MenuRequest menuRequest);

}
