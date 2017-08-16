/** 
 * <pre>项目名称:ssi-dao-01 
 * 文件名称:RoleDao.java 
 * 包名:com.jk.dao.role 
 * 创建日期:2017年7月26日下午2:40:05 
 * Copyright (c) 2017, chenjh123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.dao.role;

import java.util.List;

import com.jk.pojo.menu.MenuRequest;
import com.jk.pojo.menu.MenuResponse;
import com.jk.pojo.role.RoleRequest;
import com.jk.pojo.role.RoleResponse;

/** 
 * <pre>项目名称：ssi-dao-01    
 * 类名称：RoleDao    
 * 类描述：    
 * 创建人：陈教授 chenjh123@gmail.com    
 * 创建时间：2017年7月26日 下午2:40:05    
 * 修改人：陈教授 chenjh123@gmail.com     
 * 修改时间：2017年7月26日 下午2:40:05    
 * 修改备注：       
 * @version </pre>    
 */
public interface RoleDao {

	/** <pre>selectRoleCount(这里用一句话描述这个方法的作用)   
	 * 创建人：陈教授 chenjh123@gmail.com    
	 * 创建时间：2017年7月26日 下午2:49:33    
	 * 修改人：陈教授 chenjh123@gmail.com     
	 * 修改时间：2017年7月26日 下午2:49:33    
	 * 修改备注： 
	 * @param roleRequest
	 * @return</pre>    
	 */
	int selectRoleCount(RoleRequest roleRequest);

	/** <pre>selectRoleList(这里用一句话描述这个方法的作用)   
	 * 创建人：陈教授 chenjh123@gmail.com    
	 * 创建时间：2017年7月26日 下午2:49:54    
	 * 修改人：陈教授 chenjh123@gmail.com     
	 * 修改时间：2017年7月26日 下午2:49:54    
	 * 修改备注： 
	 * @param roleRequest
	 * @return</pre>    
	 */
	List<RoleResponse> selectRoleList(RoleRequest roleRequest);

	/** <pre>selectRoleMenuListJson(这里用一句话描述这个方法的作用)   
	 * 创建人：陈教授 chenjh123@gmail.com    
	 * 创建时间：2017年7月26日 下午3:41:55    
	 * 修改人：陈教授 chenjh123@gmail.com     
	 * 修改时间：2017年7月26日 下午3:41:55    
	 * 修改备注： 
	 * @param menuRequest
	 * @return</pre>    
	 */
	List<MenuResponse> selectRoleMenuListJson(MenuRequest menuRequest);

	/** <pre>deleteAllRoleMenuByRoleID(这里用一句话描述这个方法的作用)   
	 * 创建人：陈教授 chenjh123@gmail.com    
	 * 创建时间：2017年7月26日 下午4:11:18    
	 * 修改人：陈教授 chenjh123@gmail.com     
	 * 修改时间：2017年7月26日 下午4:11:18    
	 * 修改备注： 
	 * @param menuRequest</pre>    
	 */
	void deleteAllRoleMenuByRoleID(MenuRequest menuRequest);

	/** <pre>insertRoleMenuList(这里用一句话描述这个方法的作用)   
	 * 创建人：陈教授 chenjh123@gmail.com    
	 * 创建时间：2017年7月26日 下午4:11:51    
	 * 修改人：陈教授 chenjh123@gmail.com     
	 * 修改时间：2017年7月26日 下午4:11:51    
	 * 修改备注： 
	 * @param menuRequestList</pre>    
	 */
	void insertRoleMenuList(List<MenuRequest> menuRequestList);

}
