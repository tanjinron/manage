package org.zhousy.manager.domain;

/********************************
 * 
 * @author zhousy
 *  ��Ʒ����
 */
public class Tsort {
	  
	private Integer bid;    //��Ʒ�����(������)
	private String bname;   //��Ʒ�������
	private String bremark; // ��Ʒ�������
	private Integer bstatus;  //״̬   0Ϊ����   1Ϊɾ��
	  
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
