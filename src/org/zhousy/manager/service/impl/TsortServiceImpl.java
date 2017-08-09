package org.zhousy.manager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zhousy.manager.domain.Tsort;
import org.zhousy.manager.persistence.TsortMapper;
import org.zhousy.manager.service.TsortService;

@Service
public class TsortServiceImpl implements TsortService {
	
	@Autowired
	private TsortMapper tsortMapper;

	@Override  //������
	public void addTsort(Tsort tsort) {
		
		tsortMapper.addTsort(tsort);
	}

	@Override  //ɾ�����
	public void deleteTsort(int bid) {
		
		tsortMapper.deleteTsort(bid);
	}

	@Override  //�޸������Ϣ
	public void updateTsort(Tsort tsort) {
		
		tsortMapper.updateTsort(tsort);
	}

	@Override  //��ѯ�������
	public List<Tsort> findTsort() {
		
		return tsortMapper.findTsort();
	}

}
