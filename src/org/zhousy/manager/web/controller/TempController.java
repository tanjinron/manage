package org.zhousy.manager.web.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zhousy.manager.bean.PageBean;
import org.zhousy.manager.domain.Temp;
import org.zhousy.manager.service.TempService;

@Controller
@RequestMapping("emp")
public class TempController {

	@Autowired
	private TempService tempService;
	
	@RequestMapping("/TpaetANDTemp/{pid}")      //根据部门编号查询员工信息
	public String TpaetANDTemp(@PathVariable int pid,ModelMap model){
		
		List<Temp> list = tempService.TpaetANDTemp(pid);
		model.addAttribute("list", list);
		if(list.size()>0){
			Temp temp = list.get(0);
			model.addAttribute("pname", temp.getTpid().getPname());
		}
		
		return "/emp/pemp";
	}
	
	@RequestMapping("/empUI")  //跳转到显示所有员工信息页面
	public String empUI(Integer pageNo){
		
		return "/emp/emp";
	}
	
	//查询所有员工信息 并分页
	@RequestMapping("/pageTemp")
	@ResponseBody
	public PageBean<Temp> pageEmp(Integer pageNo){
		pageNo += pageNo;
		PageBean<Temp> temp = tempService.pageTemp(pageNo);
		
		return temp;
	}
	
	@RequestMapping("/deleteEmp")   //删除员工信息
	@ResponseBody
	public Boolean deleteEmp(Integer tid){
		try {
			tempService.deleteTemp(tid);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	@RequestMapping("/getIDemp")    //根据编号查询员工详细信息    和  所有部门
	@ResponseBody
	public Map<String, Object> getIDemp(Integer tid){
		
		Map<String, Object> map = tempService.empidANDpart(tid);
		
		return map;
	}
	
	//修改员工信息功能
	@RequestMapping("/eduitEmp")
	@ResponseBody
	public boolean eduitEmp(Temp temp){
		try {
			tempService.updateTemp(temp);
			return true;
		} catch (Exception e) {
			return false;
		}
		
		
	}
	
}
