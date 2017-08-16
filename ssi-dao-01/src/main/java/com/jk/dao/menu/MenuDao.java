/** 
 * <pre>项目名称:ssi-dao-01 
 * 文件名称:MenuDao.java 
 * 包名:com.jk.dao.menu 
 * 创建日期:2017年7月27日上午11:35:23 
 * Copyright (c) 2017, chenjh123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.dao.menu;

import java.util.List;

import com.jk.pojo.menu.MenuRequest;
import com.jk.pojo.menu.MenuResponse;

/** 
 * <pre>项目名称：ssi-dao-01    
 * 类名称：MenuDao    
 * 类描述：    
 * 创建人：陈教授 chenjh123@gmail.com    
 * 创建时间：2017年7月27日 上午11:35:23    
 * 修改人：陈教授 chenjh123@gmail.com     
 * 修改时间：2017年7月27日 上午11:35:23    
 * 修改备注：       
 * @version </pre>    
 */
public interface MenuDao {

	/** <pre>selectMenuListJson(这里用一句话描述这个方法的作用)   
	 * 创建人：陈教授 chenjh123@gmail.com    
	 * 创建时间：2017年7月27日 上午11:38:08    
	 * 修改人：陈教授 chenjh123@gmail.com     
	 * 修改时间：2017年7月27日 上午11:38:08    
	 * 修改备注： 
	 * @param menuRequest
	 * @return</pre>    
	 */
	List<MenuResponse> selectMenuListJson(MenuRequest menuRequest);

	/** <pre>selectFirstMenuList(这里用一句话描述这个方法的作用)   
	 * 创建人：陈教授 chenjh123@gmail.com    
	 * 创建时间：2017年7月27日 下午2:31:51    
	 * 修改人：陈教授 chenjh123@gmail.com     
	 * 修改时间：2017年7月27日 下午2:31:51    
	 * 修改备注： 
	 * @param menuRequest
	 * @return</pre>    
	 */
	List<MenuResponse> selectFirstMenuList(MenuRequest menuRequest);

	/** <pre>insertMenu(这里用一句话描述这个方法的作用)   
	 * 创建人：陈教授 chenjh123@gmail.com    
	 * 创建时间：2017年7月27日 下午2:47:19    
	 * 修改人：陈教授 chenjh123@gmail.com     
	 * 修改时间：2017年7月27日 下午2:47:19    
	 * 修改备注： 
	 * @param menuRequest</pre>    
	 */
	void insertMenu(MenuRequest menuRequest);

}
