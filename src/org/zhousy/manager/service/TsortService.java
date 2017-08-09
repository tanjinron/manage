package org.zhousy.manager.service;

import java.util.List;

import org.zhousy.manager.domain.Tsort;

public interface TsortService {

	//添加类别
	void addTsort(Tsort tsort);
	
	//删除类别
	void deleteTsort(int bid);
	
	//修改类别信息
	void updateTsort(Tsort tsort);
	
	//查询所有类别
	List<Tsort> findTsort();
	
}
