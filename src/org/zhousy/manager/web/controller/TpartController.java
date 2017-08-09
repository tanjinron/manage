package org.zhousy.manager.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zhousy.manager.domain.Tpart;
import org.zhousy.manager.service.TpaetService;

@Controller
@RequestMapping("/part")
public class TpartController {

	@Autowired
	private TpaetService tpaetService;
	
	@RequestMapping("/partUI")      //跳转到现实所有部门页面
	public String partUI(){
		
		return "/emp/tpart";
	}
	
	@ResponseBody
	@RequestMapping("/partlist")      //查询所有部门信息
	public List<Tpart> listpart(){
		
		List<Tpart> list = tpaetService.findTpaet();
		
		return list;
	}
	
	@RequestMapping("/addTpaetUI")   //跳转至添加部门信息页面
	public String addTpaetUI(){
		
		return "/emp/addTpart";
	}
	
	@RequestMapping("/addTpart")    //添加部门信息
	public String addTpart(Tpart tpart){
		
		tpaetService.addTpaet(tpart);
	
		return "/emp/tpart";
	}
	
	@ResponseBody
	@RequestMapping("/deleteTpart")  //删除部门信息
	public Boolean deleteTpart(int pid){
		try {
			tpaetService.deleteTpaet(pid);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}
	
	@ResponseBody
	@RequestMapping("/idpart") //根据编号查询部门信息
	public Tpart idpart(int pid){
		
		Tpart tpart = tpaetService.IDpart(pid);
		
		return tpart;
	}
	
	@ResponseBody
	@RequestMapping("/uppart")    //修改部门信息
	public Boolean uppart(Tpart tpart){
		try {
			tpaetService.updateTpaet(tpart);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
}
