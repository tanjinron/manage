package org.zhousy.manager.persistence;

import java.util.List;

import org.zhousy.manager.domain.Tuser;

/*********************
 * 
 * @author zhousy
 *  ����Ա����
 */
public interface TuserMapper {

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
