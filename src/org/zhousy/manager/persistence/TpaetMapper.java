package org.zhousy.manager.persistence;

import java.util.List;

import org.zhousy.manager.domain.Tpart;

/****************
 * 
 * @author zhousy
 *  ���Ź���   ��ɾ���
 */
public interface TpaetMapper {

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
