package org.zhousy.manager.persistence;

import java.util.List;

import org.zhousy.manager.domain.Tsort;

/***********
 * 
 * @author zhousy
 *  ��Ʒ������
 */
public interface TsortMapper {
	
	//������
	void addTsort(Tsort tsort);
	
	//ɾ�����     �޸�״̬
	void deleteTsort(int bid);
	
	//�޸������Ϣ
	void updateTsort(Tsort tsort);
	
	//��ѯ�������
	List<Tsort> findTsort();

}
