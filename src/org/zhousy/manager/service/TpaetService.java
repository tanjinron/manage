package org.zhousy.manager.service;

import java.util.List;

import org.zhousy.manager.domain.Tpart;

public interface TpaetService {

	//��ѯ���в���
	List<Tpart> findTpaet();
	
	//��Ӳ�����Ϣ
	void addTpaet(Tpart tpart);
	
	//ɾ��������Ϣ  �޸Ĳ���״̬
	void deleteTpaet(Integer pid);
	
	//�޸Ĳ�����Ϣ
	void updateTpaet(Tpart tpart);
	
	//���ݱ�Ų�ѯ������Ϣ
	Tpart IDpart(int pid);
	
}
