/** 
 * <pre>项目名称:ssi-01 
 * 文件名称:UserDaoImpl.java 
 * 包名:com.jk.dao.user.impl 
 * 创建日期:2017年7月17日上午11:10:19 
 * Copyright (c) 2017, chenjh123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.dao.user.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.SqlMapClientCallback;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

import com.ibatis.sqlmap.client.SqlMapExecutor;
import com.jk.dao.user.UserDao;
import com.jk.pojo.menu.MenuRequest;
import com.jk.pojo.menu.MenuResponse;
import com.jk.pojo.role.RoleRequest;
import com.jk.pojo.role.RoleResponse;
import com.jk.pojo.user.UserRequest;
import com.jk.pojo.user.UserResponse;

/** 
 * <pre>项目名称：ssi-01    
 * 类名称：UserDaoImpl    
 * 类描述：    
 * 创建人：陈教授 chenjh123@gmail.com    
 * 创建时间：2017年7月17日 上午11:10:19    
 * 修改人：陈教授 chenjh123@gmail.com     
 * 修改时间：2017年7月17日 上午11:10:19    
 * 修改备注：       
 * @version </pre>    
 */
@Repository
public class UserDaoImpl extends SqlMapClientDaoSupport implements UserDao {

	/* (non-Javadoc)    
	 * @see com.jk.dao.user.UserDao#insertUser(com.jk.pojo.user.UserRequest)    
	 */
	@Override
	public void insertUser(UserRequest userRequest) {
		System.out.println("dao层：" + userRequest.getUserAccount());
		this.getSqlMapClientTemplate().insert("user.insertUser", userRequest);
	}
	
	/* (non-Javadoc)    
	 * @see com.jk.dao.user.UserDao#selectUserList(com.jk.pojo.user.UserRequest)    
	 */
	@Override
	public List<UserResponse> selectUserList(UserRequest userRequest) {
		return this.getSqlMapClientTemplate().queryForList("user.selectUserList", userRequest);
	}
	
	/* (non-Javadoc)    
	 * @see com.jk.dao.user.UserDao#login(com.jk.pojo.user.UserRequest)    
	 */
	@Override
	public UserResponse login(UserRequest userRequest) {
		return (UserResponse) this.getSqlMapClientTemplate().queryForObject("user.login", userRequest);
	}
	
	/* (non-Javadoc)    
	 * @see com.jk.dao.user.UserDao#updateLoginFailNum(com.jk.pojo.user.UserRequest)    
	 */
	@Override
	public void updateLoginFailNum(UserRequest userRequest) {
		this.getSqlMapClientTemplate().update("user.updateLoginFailNum", userRequest);
	}
	
	/* (non-Javadoc)    
	 * @see com.jk.dao.user.UserDao#selectUserRoleListJson(com.jk.pojo.role.RoleRequest)    
	 */
	@Override
	public List<RoleResponse> selectUserRoleListJson(RoleRequest roleRequest) {
		return this.getSqlMapClientTemplate().queryForList("user.selectUserRoleListJson", roleRequest);
	}
	
	/* (non-Javadoc)    
	 * @see com.jk.dao.user.UserDao#deleteAllRolesByUserID(com.jk.pojo.role.RoleRequest)    
	 */
	@Override
	public void deleteAllRolesByUserID(RoleRequest roleRequest) {
		this.getSqlMapClientTemplate().delete("user.deleteAllRolesByUserID", roleRequest);
	}
	
	/* (non-Javadoc)    
	 * @see com.jk.dao.user.UserDao#insertUserRoleList(java.util.List)    
	 */
	@Override
	public void insertUserRoleList(final List<RoleRequest> roleRequestList) {
		this.getSqlMapClientTemplate().execute(new SqlMapClientCallback<Object>() {
			/* (non-Javadoc)    
			 * @see org.springframework.orm.ibatis.SqlMapClientCallback#doInSqlMapClient(com.ibatis.sqlmap.client.SqlMapExecutor)    
			 */
			@Override
			public Object doInSqlMapClient(SqlMapExecutor sqlMap) throws SQLException {
				//开启批量
				sqlMap.startBatch();
				//添加批量操作语句
				for (RoleRequest roleRequest : roleRequestList) {
					sqlMap.insert("user.insertUserRole", roleRequest);
				}
				//执行批量操作
				sqlMap.executeBatch();
				return null;
			}
		});
	}
	
	/* (non-Javadoc)    
	 * @see com.jk.dao.user.UserDao#selectUserCount(com.jk.pojo.user.UserRequest)    
	 */
	@Override
	public int selectUserCount(UserRequest userRequest) {
		return (Integer) this.getSqlMapClientTemplate().queryForObject("user.selectUserCount", userRequest);
	}
	
	/* (non-Javadoc)    
	 * @see com.jk.dao.user.UserDao#selectTreeListJson(com.jk.pojo.menu.MenuRequest)    
	 */
	@Override
	public List<Map<String, Object>> selectTreeListJson(MenuRequest menuRequest) {
		return this.getSqlMapClientTemplate().queryForList("user.selectTreeListJson", menuRequest);
	}
	
	/* (non-Javadoc)    
	 * @see com.jk.dao.user.UserDao#selectUserMenuListJson(com.jk.pojo.menu.MenuRequest)    
	 */
	@Override
	public List<MenuResponse> selectUserMenuListJson(MenuRequest menuRequest) {
		System.out.println(menuRequest.getUserID());
		
		return this.getSqlMapClientTemplate().queryForList("user.selectUserMenuListJson", menuRequest);
	}
	
	/* (non-Javadoc)    
	 * @see com.jk.dao.user.UserDao#insertUserRole(com.jk.pojo.user.UserRequest)    
	 */
	@Override
	public void insertUserRole(UserRequest userRequest) {
		this.getSqlMapClientTemplate().insert("user.insertUserRole", userRequest);
	}
}
