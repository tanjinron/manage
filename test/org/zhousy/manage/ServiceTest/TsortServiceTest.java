package org.zhousy.manage.ServiceTest;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.zhousy.manager.domain.Tsort;
import org.zhousy.manager.service.TsortService;

/******************************
 * 
 * @author zhousy
 *   产品类别操作测试
 */
public class TsortServiceTest {
	
	private TsortService tsortService;
	
	@Before
	public void init() {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		tsortService = ctx.getBean(TsortService.class);
	}
	
	@Test     //添加产品类别
	public void addTest(){
		
		Tsort tsort = new Tsort();
		tsort.setBname("华为");
		tsort.setBremark("手机");
		
		tsortService.addTsort(tsort);
		
	}
	
	@Test     //删除类别信息   修改状态
	public void deleteTest(){
		
		tsortService.deleteTsort(1);
	}
	
	@Test    //查询所有部门信息
	public void listTest(){
		
		List<Tsort> list = tsortService.findTsort();
		for (Tsort tsort : list) {
			
			System.out.println(tsort.getBname());
		}
	}
	
	@Test    //修改部门信息
	public void updateTest(){
		
		Tsort tsort = new Tsort();
		tsort.setBid(1);
		tsort.setBname("oppo");
		tsort.setBremark("好好好");
		
		tsortService.updateTsort(tsort);
	}
	

}
