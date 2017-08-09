package org.zhousy.manager.service;

import java.util.List;

import org.zhousy.manager.domain.Tsort;

public interface TsortService {

	//������
	void addTsort(Tsort tsort);
	
	//ɾ�����
	void deleteTsort(int bid);
	
	//�޸������Ϣ
	void updateTsort(Tsort tsort);
	
	//��ѯ�������
	List<Tsort> findTsort();
	
}
