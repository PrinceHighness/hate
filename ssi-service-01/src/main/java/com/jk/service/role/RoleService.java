/** 
 * <pre>项目名称:ssi-service-01 
 * 文件名称:RoleService.java 
 * 包名:com.jk.service.role 
 * 创建日期:2017年7月26日下午2:38:36 
 * Copyright (c) 2017, chenjh123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.service.role;

import java.util.List;

import com.jk.pojo.menu.MenuRequest;
import com.jk.pojo.menu.MenuResponse;
import com.jk.pojo.role.RoleRequest;
import com.jk.pojo.role.RoleResponse;

/** 
 * <pre>项目名称：ssi-service-01    
 * 类名称：RoleService    
 * 类描述：    
 * 创建人：陈教授 chenjh123@gmail.com    
 * 创建时间：2017年7月26日 下午2:38:36    
 * 修改人：陈教授 chenjh123@gmail.com     
 * 修改时间：2017年7月26日 下午2:38:36    
 * 修改备注：       
 * @version </pre>    
 */
public interface RoleService {

	/** <pre>selectRoleCount(这里用一句话描述这个方法的作用)   
	 * 创建人：陈教授 chenjh123@gmail.com    
	 * 创建时间：2017年7月26日 下午2:48:55    
	 * 修改人：陈教授 chenjh123@gmail.com     
	 * 修改时间：2017年7月26日 下午2:48:55    
	 * 修改备注： 
	 * @param roleRequest
	 * @return</pre>    
	 */
	int selectRoleCount(RoleRequest roleRequest);

	/** <pre>selectRoleList(这里用一句话描述这个方法的作用)   
	 * 创建人：陈教授 chenjh123@gmail.com    
	 * 创建时间：2017年7月26日 下午2:49:01    
	 * 修改人：陈教授 chenjh123@gmail.com     
	 * 修改时间：2017年7月26日 下午2:49:01    
	 * 修改备注： 
	 * @param roleRequest
	 * @return</pre>    
	 */
	List<RoleResponse> selectRoleList(RoleRequest roleRequest);

	/** <pre>selectRoleMenuListJson(这里用一句话描述这个方法的作用)   
	 * 创建人：陈教授 chenjh123@gmail.com    
	 * 创建时间：2017年7月26日 下午3:41:34    
	 * 修改人：陈教授 chenjh123@gmail.com     
	 * 修改时间：2017年7月26日 下午3:41:34    
	 * 修改备注： 
	 * @param menuRequest
	 * @return</pre>    
	 */
	List<MenuResponse> selectRoleMenuListJson(MenuRequest menuRequest);

	/** <pre>insertRoleMenuList(这里用一句话描述这个方法的作用)   
	 * 创建人：陈教授 chenjh123@gmail.com    
	 * 创建时间：2017年7月26日 下午4:10:12    
	 * 修改人：陈教授 chenjh123@gmail.com     
	 * 修改时间：2017年7月26日 下午4:10:12    
	 * 修改备注： 
	 * @param menuRequestList</pre>    
	 */
	void insertRoleMenuList(List<MenuRequest> menuRequestList);

}
