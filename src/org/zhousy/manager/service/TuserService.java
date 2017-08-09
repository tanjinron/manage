package org.zhousy.manager.service;

import java.util.List;

import org.zhousy.manager.domain.Tuser;

public interface TuserService {
	
	//��¼
	Tuser loginTuser(Tuser tuser);
	
	//��ӹ���Ա
	void addTuser(Tuser tuser);
	
	//�޸Ĺ���Ա��Ϣ
	void updateTuser(Tuser tuser);
	
	//��ѯ���й���Ա   ����ѯ��ǰ����Ա
	List<Tuser> checkTuser(Integer gid);
	
	//���ݱ�Ų�ѯ����Ա��Ϣ
	Tuser getidTuser(int gid);
	
}
