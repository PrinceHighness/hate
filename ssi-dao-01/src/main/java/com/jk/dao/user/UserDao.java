/** 
 * <pre>项目名称:ssi-01 
 * 文件名称:UserDao.java 
 * 包名:com.jk.dao.user 
 * 创建日期:2017年7月17日上午11:10:04 
 * Copyright (c) 2017, chenjh123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.dao.user;

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
 * 类名称：UserDao    
 * 类描述：    
 * 创建人：陈教授 chenjh123@gmail.com    
 * 创建时间：2017年7月17日 上午11:10:04    
 * 修改人：陈教授 chenjh123@gmail.com     
 * 修改时间：2017年7月17日 上午11:10:04    
 * 修改备注：       
 * @version </pre>    
 */
public interface UserDao {

	/** <pre>insertUser(这里用一句话描述这个方法的作用)   
	 * 创建人：陈教授 chenjh123@gmail.com    
	 * 创建时间：2017年7月17日 上午11:11:52    
	 * 修改人：陈教授 chenjh123@gmail.com     
	 * 修改时间：2017年7月17日 上午11:11:52    
	 * 修改备注： 
	 * @param userRequest</pre>    
	 */
	void insertUser(UserRequest userRequest);

	/** <pre>selectUserList(这里用一句话描述这个方法的作用)   
	 * 创建人：陈教授 chenjh123@gmail.com    
	 * 创建时间：2017年7月17日 上午11:47:04    
	 * 修改人：陈教授 chenjh123@gmail.com     
	 * 修改时间：2017年7月17日 上午11:47:04    
	 * 修改备注： 
	 * @param userRequest
	 * @return</pre>    
	 */
	List<UserResponse> selectUserList(UserRequest userRequest);

	/** <pre>login(这里用一句话描述这个方法的作用)   
	 * 创建人：陈教授 chenjh123@gmail.com    
	 * 创建时间：2017年7月19日 下午3:36:25    
	 * 修改人：陈教授 chenjh123@gmail.com     
	 * 修改时间：2017年7月19日 下午3:36:25    
	 * 修改备注： 
	 * @param userRequest
	 * @return</pre>    
	 */
	UserResponse login(UserRequest userRequest);

	/** <pre>updateLoginFailNum(这里用一句话描述这个方法的作用)   
	 * 创建人：陈教授 chenjh123@gmail.com    
	 * 创建时间：2017年7月20日 下午4:35:16    
	 * 修改人：陈教授 chenjh123@gmail.com     
	 * 修改时间：2017年7月20日 下午4:35:16    
	 * 修改备注： 
	 * @param userRequest</pre>    
	 */
	void updateLoginFailNum(UserRequest userRequest);

	/** <pre>selectUserRoleListJson(这里用一句话描述这个方法的作用)   
	 * 创建人：陈教授 chenjh123@gmail.com    
	 * 创建时间：2017年7月25日 下午12:22:00    
	 * 修改人：陈教授 chenjh123@gmail.com     
	 * 修改时间：2017年7月25日 下午12:22:00    
	 * 修改备注： 
	 * @param roleRequest
	 * @return</pre>    
	 */
	List<RoleResponse> selectUserRoleListJson(RoleRequest roleRequest);

	/** <pre>deleteAllRolesByUserID(这里用一句话描述这个方法的作用)   
	 * 创建人：陈教授 chenjh123@gmail.com    
	 * 创建时间：2017年7月25日 下午3:27:44    
	 * 修改人：陈教授 chenjh123@gmail.com     
	 * 修改时间：2017年7月25日 下午3:27:44    
	 * 修改备注： 
	 * @param roleRequest</pre>    
	 */
	void deleteAllRolesByUserID(RoleRequest roleRequest);

	/** <pre>insertUserRoleList(这里用一句话描述这个方法的作用)   
	 * 创建人：陈教授 chenjh123@gmail.com    
	 * 创建时间：2017年7月25日 下午3:30:40    
	 * 修改人：陈教授 chenjh123@gmail.com     
	 * 修改时间：2017年7月25日 下午3:30:40    
	 * 修改备注： 
	 * @param roleRequestList</pre>    
	 */
	void insertUserRoleList(List<RoleRequest> roleRequestList);

	/** <pre>selectUserCount(这里用一句话描述这个方法的作用)   
	 * 创建人：陈教授 chenjh123@gmail.com    
	 * 创建时间：2017年7月25日 下午4:27:55    
	 * 修改人：陈教授 chenjh123@gmail.com     
	 * 修改时间：2017年7月25日 下午4:27:55    
	 * 修改备注： 
	 * @param userRequest
	 * @return</pre>    
	 */
	int selectUserCount(UserRequest userRequest);

	/** <pre>selectTreeListJson(这里用一句话描述这个方法的作用)   
	 * 创建人：陈教授 chenjh123@gmail.com    
	 * 创建时间：2017年7月26日 下午4:56:08    
	 * 修改人：陈教授 chenjh123@gmail.com     
	 * 修改时间：2017年7月26日 下午4:56:08    
	 * 修改备注： 
	 * @param menuRequest
	 * @return</pre>    
	 */
	List<Map<String, Object>> selectTreeListJson(MenuRequest menuRequest);

	/** <pre>selectUserMenuListJson(这里用一句话描述这个方法的作用)   
	 * 创建人：陈教授 chenjh123@gmail.com    
	 * 创建时间：2017年7月28日 上午11:00:25    
	 * 修改人：陈教授 chenjh123@gmail.com     
	 * 修改时间：2017年7月28日 上午11:00:25    
	 * 修改备注： 
	 * @param menuRequest
	 * @return</pre>    
	 */
	List<MenuResponse> selectUserMenuListJson(MenuRequest menuRequest);

	/** <pre>insertUserRole(这里用一句话描述这个方法的作用)   
	 * 创建人：陈教授 chenjh123@gmail.com    
	 * 创建时间：2017年7月28日 下午2:51:49    
	 * 修改人：陈教授 chenjh123@gmail.com     
	 * 修改时间：2017年7月28日 下午2:51:49    
	 * 修改备注： 
	 * @param userRequest</pre>    
	 */
	void insertUserRole(UserRequest userRequest);

}
