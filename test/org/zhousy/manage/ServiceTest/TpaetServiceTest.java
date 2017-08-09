package org.zhousy.manage.ServiceTest;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.zhousy.manager.domain.Tpart;
import org.zhousy.manager.service.TpaetService;

/********************
 * 
 * @author zhousy
 *  员工管理测试类
 */
public class TpaetServiceTest {
	
	private TpaetService tpaetService;

	@Before
	public void init() {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		tpaetService = ctx.getBean(TpaetService.class);
	}
	
	@Test     //查询所有部门
	public void findTpaetTest(){
		
		List<Tpart> list = tpaetService.findTpaet();
		
		for (Tpart tpart : list) {
			
			System.out.println(tpart.getPname());
		}
	}
	
	@Test  //添加部门信息
	public void addTpaetTest(){
		
		Tpart tpart = new Tpart();
		tpart.setPname("销售2部");
		tpart.setPremark("研发部欢迎你！");
		
		tpaetService.addTpaet(tpart);
	}
	
	@Test   //删除部门信息  修改部门状态
	public void deleteTpaet(){
		
		tpaetService.deleteTpaet(4);
	}
	
	@Test  //修改部门信息
	public void updateTpaet(){
		
		Tpart tpart = new Tpart();
		tpart.setPid(2);
		tpart.setPname("销售1部");
		tpart.setPremark("销售1部欢迎你！");
		tpaetService.updateTpaet(tpart);
	}

}
