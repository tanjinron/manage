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

	@Override  //��¼
	public Tuser loginTuser(Tuser tuser) {
		
		return tuserMapper.loginTuser(tuser);
	}

	@Override   //��ӹ���Ա
	public void addTuser(Tuser tuser) {
		
		tuserMapper.addTuser(tuser);
	}

	@Override   //�޸Ĺ���Ա��Ϣ
	public void updateTuser(Tuser tuser) {

		tuserMapper.updateTuser(tuser);

	}

	@Override   //��ѯ���й���Ա   ����ѯ��ǰ����Ա
	public List<Tuser> checkTuser(Integer gid) {
		
		return tuserMapper.checkTuser(gid);
	}

	@Override	//���ݱ�Ų�ѯ����Ա��Ϣ
	public Tuser getidTuser(int gid) {
		
		return tuserMapper.getidTuser(gid);
	}

}
