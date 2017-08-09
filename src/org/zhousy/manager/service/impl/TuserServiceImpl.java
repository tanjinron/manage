package org.zhousy.manager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zhousy.manager.domain.Tuser;
import org.zhousy.manager.persistence.TuserMapper;
import org.zhousy.manager.service.TuserService;

@Service
public class TuserServiceImpl implements TuserService {
	
	@Autowired
	private TuserMapper tuserMapper;

	@Override  //登录
	public Tuser loginTuser(Tuser tuser) {
		
		return tuserMapper.loginTuser(tuser);
	}

	@Override   //添加管理员
	public void addTuser(Tuser tuser) {
		
		tuserMapper.addTuser(tuser);
	}

	@Override   //修改管理员信息
	public void updateTuser(Tuser tuser) {

		tuserMapper.updateTuser(tuser);

	}

	@Override   //查询所有管理员   不查询当前管理员
	public List<Tuser> checkTuser(Integer gid) {
		
		return tuserMapper.checkTuser(gid);
	}

	@Override	//根据编号查询管理员信息
	public Tuser getidTuser(int gid) {
		
		return tuserMapper.getidTuser(gid);
	}

}
