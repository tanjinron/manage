package org.zhousy.manager.domain;

/********************************
 * 
 * @author zhousy
 *  产品类别表
 */
public class Tsort {
	  
	private Integer bid;    //产品类别编号(自增列)
	private String bname;   //产品类别名称
	private String bremark; // 产品类别描述
	private Integer bstatus;  //状态   0为正常   1为删除
	  
	public Integer getBid() {
		return bid;
	}
	public void setBid(Integer bid) {
		this.bid = bid;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getBremark() {
		return bremark;
	}
	public void setBremark(String bremark) {
		this.bremark = bremark;
	}
	public Integer getBstatus() {
		return bstatus;
	}
	public void setBstatus(Integer bstatus) {
		this.bstatus = bstatus;
	}

	  

}
