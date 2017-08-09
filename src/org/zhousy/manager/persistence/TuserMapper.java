package org.zhousy.manager.persistence;

import java.util.List;

import org.zhousy.manager.domain.Tuser;

/*********************
 * 
 * @author zhousy
 *  管理员操作
 */
public interface TuserMapper {

	//登录
	Tuser loginTuser(Tuser tuser);
	
	//添加管理员
	void addTuser(Tuser tuser);
	
	//修改管理员信息
	void updateTuser(Tuser tuser);
	
	//查询所有管理员   不查询当前管理员
	List<Tuser> checkTuser(Integer gid);
	
	//根据编号查询管理员信息
	Tuser getidTuser(int gid);
	
}
