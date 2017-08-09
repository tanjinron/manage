package org.zhousy.manager.domain;

/****************
 * 
 * @author zhousy
 *  部门表
 */
public class Tpart {
	
	private Integer pid;   //部门编号
	private String pname;  //部门名称 
	private String premark;  //部门介绍
	private Integer pstatus;  //状态   0为正常  1为删除
	
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPremark() {
		return premark;
	}
	public void setPremark(String premark) {
		this.premark = premark;
	}
	public Integer getPstatus() {
		return pstatus;
	}
	public void setPstatus(Integer pstatus) {
		this.pstatus = pstatus;
	}
	
}
