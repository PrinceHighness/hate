/** 
 * <pre>项目名称:ssi-01 
 * 文件名称:UserService.java 
 * 包名:com.jk.service.user 
 * 创建日期:2017年7月17日上午11:05:10 
 * Copyright (c) 2017, chenjh123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.service.user;

import java.util.List;
import java.util.Map;

import com.jk.pojo.menu.MenuRequest;
import com.jk.pojo.menu.MenuResponse;
import com.jk.pojo.role.RoleRequest;
import com.jk.pojo.role.RoleResponse;
import com.jk.pojo.user.UserRequest;
import com.jk.pojo.user.UserResponse;

/** 
 * <pre>项目名称：ssi-01    
 * 类名称：UserService    
 * 类描述：    
 * 创建人：陈教授 chenjh123@gmail.com    
 * 创建时间：2017年7月17日 上午11:05:10    
 * 修改人：陈教授 chenjh123@gmail.com     
 * 修改时间：2017年7月17日 上午11:05:10    
 * 修改备注：       
 * @version </pre>    
 */
public interface UserService {

	/** <pre>insertUser(这里用一句话描述这个方法的作用)   
	 * 创建人：陈教授 chenjh123@gmail.com    
	 * 创建时间：2017年7月17日 上午11:06:27    
	 * 修改人：陈教授 chenjh123@gmail.com     
	 * 修改时间：2017年7月17日 上午11:06:27    
	 * 修改备注： 
	 * @param userRequest</pre>    
	 */
	void insertUser(UserRequest userRequest);

	/** <pre>selectUserList(这里用一句话描述这个方法的作用)   
	 * 创建人：陈教授 chenjh123@gmail.com    
	 * 创建时间：2017年7月17日 上午11:46:41    
	 * 修改人：陈教授 chenjh123@gmail.com     
	 * 修改时间：2017年7月17日 上午11:46:41    
	 * 修改备注： 
	 * @param userRequest
	 * @return</pre>    
	 */
	List<UserResponse> selectUserList(UserRequest userRequest);

	/** <pre>login(这里用一句话描述这个方法的作用)   
	 * 创建人：陈教授 chenjh123@gmail.com    
	 * 创建时间：2017年7月19日 下午3:18:24    
	 * 修改人：陈教授 chenjh123@gmail.com     
	 * 修改时间：2017年7月19日 下午3:18:24    
	 * 修改备注： 
	 * @param userRequest
	 * @return</pre>    
	 */
	Map<String, Object> login(UserRequest userRequest);

	/** <pre>selectUserRoleListJson(这里用一句话描述这个方法的作用)   
	 * 创建人：陈教授 chenjh123@gmail.com    
	 * 创建时间：2017年7月25日 下午12:21:30    
	 * 修改人：陈教授 chenjh123@gmail.com     
	 * 修改时间：2017年7月25日 下午12:21:30    
	 * 修改备注： 
	 * @param roleRequest
	 * @return</pre>    
	 */
	List<RoleResponse> selectUserRoleListJson(RoleRequest roleRequest);

	/** <pre>insertUserRoleList(这里用一句话描述这个方法的作用)   
	 * 创建人：陈教授 chenjh123@gmail.com    
	 * 创建时间：2017年7月25日 下午3:25:29    
	 * 修改人：陈教授 chenjh123@gmail.com     
	 * 修改时间：2017年7月25日 下午3:25:29    
	 * 修改备注： 
	 * @param roleRequestList</pre>    
	 */
	void insertUserRoleList(List<RoleRequest> roleRequestList);

	/** <pre>selectUserCount(这里用一句话描述这个方法的作用)   
	 * 创建人：陈教授 chenjh123@gmail.com    
	 * 创建时间：2017年7月25日 下午4:27:30    
	 * 修改人：陈教授 chenjh123@gmail.com     
	 * 修改时间：2017年7月25日 下午4:27:30    
	 * 修改备注： 
	 * @param userRequest
	 * @return</pre>    
	 */
	int selectUserCount(UserRequest userRequest);

	/** <pre>selectTreeListJson(这里用一句话描述这个方法的作用)   
	 * 创建人：陈教授 chenjh123@gmail.com    
	 * 创建时间：2017年7月26日 下午4:39:03    
	 * 修改人：陈教授 chenjh123@gmail.com     
	 * 修改时间：2017年7月26日 下午4:39:03    
	 * 修改备注： 
	 * @param userRequest
	 * @return</pre>    
	 */
	List<Map<String, Object>> selectTreeListJson(MenuRequest menuRequest);

	/** <pre>selectUserMenuListJson(这里用一句话描述这个方法的作用)   
	 * 创建人：陈教授 chenjh123@gmail.com    
	 * 创建时间：2017年7月28日 上午10:59:39    
	 * 修改人：陈教授 chenjh123@gmail.com     
	 * 修改时间：2017年7月28日 上午10:59:39    
	 * 修改备注： 
	 * @param menuRequest
	 * @return</pre>    
	 */
	List<MenuResponse> selectUserMenuListJson(MenuRequest menuRequest);

}
