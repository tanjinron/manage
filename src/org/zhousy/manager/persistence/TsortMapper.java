package org.zhousy.manager.persistence;

import java.util.List;

import org.zhousy.manager.domain.Tsort;

/***********
 * 
 * @author zhousy
 *  产品类别操作
 */
public interface TsortMapper {
	
	//添加类别
	void addTsort(Tsort tsort);
	
	//删除类别     修改状态
	void deleteTsort(int bid);
	
	//修改类别信息
	void updateTsort(Tsort tsort);
	
	//查询所有类别
	List<Tsort> findTsort();

}
