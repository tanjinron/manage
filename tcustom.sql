/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50612
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50612
File Encoding         : 65001

Date: 2016-08-22 16:01:31
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `tpart`   部门表
-- ----------------------------
DROP TABLE IF EXISTS `tpart`;
CREATE TABLE `tpart` (
  `pid` int(8) NOT NULL AUTO_INCREMENT,  
  `pname` varchar(20) DEFAULT NULL,  
  `premark` varchar(50) DEFAULT NULL,
  `pstatus` int DEFAULT NULL,    #默认 0为正常  1 为删除
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into tpart values(pid,'销售部','销售部欢迎你！',0);
insert into tpart values(pid,'研发部','研发部欢迎你！',0);
insert into tpart values(pid,'测试部','测试部欢迎你！',0);
insert into tpart values(pid,'营销部','营销部欢迎你！',0);
insert into tpart values(pid,'技术部','技术部欢迎你！',0);
insert into tpart values(pid,'生产部','生产部欢迎你！',0);
insert into tpart values(pid,'运营部','运营部欢迎你！',0);
insert into tpart values(pid,'财务部','技术部欢迎你！',0);
#-- -update tpart set pstatus=0 where pid=4;
select * from tpart where pstatus=0;
#select * from tpart where pid=1
#select * from (select * from tpart where pid=2)tpart left join temp on tpart.pid=temp.tpid

-- ----------------------------
-- Records of tpart
-- ----------------------------

-- ----------------------------
-- Table structure for `temp`  员工表
-- ----------------------------
DROP TABLE IF EXISTS `temp`;
CREATE TABLE `temp` (
  `tid` int(8) NOT NULL AUTO_INCREMENT,
  `trealname` varchar(20) DEFAULT NULL,
  `tpid` int(8) DEFAULT NULL,     #部门外键
  `tsex` int(2) DEFAULT NULL,     #0为男  1为女
  `taddress` varchar(20) DEFAULT NULL,
  `tage` int(4) DEFAULT NULL,
  `ttel` varchar(20) DEFAULT NULL,
  `tstatus` int DEFAULT NULL,    # 状态 默认 0为正常  1 为删除   2为部门删除的员工
  PRIMARY KEY (`tid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#select max(tid) from temp;
insert into temp values(tid,'小明0',1,0,'湖北省武汉市','26','12311231213',0);
insert into temp values(tid,'小明1',1,0,'湖北省武汉市','26','12311231213',0);
insert into temp values(tid,'小明2',2,0,'湖北省武汉市','26','12311231213',0);
insert into temp values(tid,'小明3',1,0,'湖北省武汉市','26','12311231213',0);
insert into temp values(tid,'小明4',2,1,'湖北省武汉市','26','12311231213',0);
insert into temp values(tid,'小明5',1,0,'湖北省武汉市','26','12311231213',0);
insert into temp values(tid,'小明6',1,0,'湖北省武汉市','26','12311231213',0);
insert into temp values(tid,'小明7',2,0,'湖北省武汉市','26','12311231213',0);
insert into temp values(tid,'小明8',1,0,'湖北省武汉市','26','12311231213',0);
insert into temp values(tid,'小明9',2,1,'湖北省武汉市','26','12311231213',0);
insert into temp values(tid,'小明10',1,0,'湖北省武汉市','26','12311231213',0);
insert into temp values(tid,'小明11',1,0,'湖北省武汉市','26','12311231213',0);
insert into temp values(tid,'小明12',2,0,'湖北省武汉市','26','12311231213',0);
insert into temp values(tid,'小明13',1,0,'湖北省武汉市','26','12311231213',0);
insert into temp values(tid,'小明14',2,1,'湖北省武汉市','26','12311231213',0);
#select temp.*,tpart.pname from (select * from temp where temp.tstatus=0 and tid=3)temp left join tpart on temp.tpid=tpart.pid ;#查询所有员工信息 和 部门名称
#update temp set tstatus=0 where tid=1;   删除   修改员工状态
#update temp set trealname='张三',tpid='2',tsex=1,taddress='湖北',tage=23,ttel='123123' where tid=1;  修改员工信息
#select * from (select * from temp where temp.tstatus=0 and tpid=2)temp left join tpart on temp.tpid=tpart.pid   根据部门查询员工
select * from temp;
#    select * from temp where tid=2
#select temp.*,tpart.pname from (select * from temp where temp.tstatus=0)temp left join tpart on temp.tpid=tpart.pid  limit #{page.dbIndex},#{page.dbNumber} 

#select count(*) from temp where tstatus=0

#update tpart set pstatus=1 where pid=#{pid}

-- ----------------------------
-- Records of temp
-- ----------------------------

-- ----------------------------
-- Table structure for `tsort`   产品类别表
-- ----------------------------
DROP TABLE IF EXISTS `tsort`;
CREATE TABLE `tsort` (
  `bid` int(8) NOT NULL AUTO_INCREMENT,
  `bname` varchar(20) DEFAULT NULL,
  `bremark` text,      #类别描述
  `bstatus` int,      #0为正常   1为删除
  PRIMARY KEY (`bid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert into tsort values(bid,'三星','xxx',0);
insert into tsort values(bid,'小米','xxx',0);
insert into tsort values(bid,'oppo','xxx',0);
insert into tsort values(bid,'vivo','xxx',0);
insert into tsort values(bid,'金立','xxx',0);
insert into tsort values(bid,'华为','xxx',0);
insert into tsort values(bid,'360','xxx',0);
insert into tsort values(bid,'中兴','xxx',0);
insert into tsort values(bid,'魅族','xxx',0);
insert into tsort values(bid,'联想','xxx',0);
insert into tsort values(bid,'酷派','xxx',0);
select * from tsort;
select * from tsort where bid=3;
#select * from tsort where bstatus=0
#  insert into tsort values(bid,'xx','xxxxxxxxxxx',0);
#  update tsort set bstatus=0 where bid=1


-- ----------------------------
-- Records of tsort
-- ----------------------------

-- ----------------------------
-- Table structure for `tproducts`  产品信息表
-- ----------------------------
DROP TABLE IF EXISTS `tproducts`;
CREATE TABLE `tproducts` (
  `did` int(8) NOT NULL AUTO_INCREMENT,
  `bid` int(8) NOT NULL,           #产品类别外键
  `dname` varchar(20) DEFAULT NULL,
  `dprice` double(8,0) DEFAULT NULL,
  `dremark` text,
  `dstatus` int DEFAULT NULL,    #默认 0为正常(在售)  1 为删除(下架)  2(缺货)
  `dcount` int DEFAULT NULL,    #产品库存量 
  PRIMARY KEY (`did`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into tproducts values(did,1,'手机',3600,'打电话',0,2300);
insert into tproducts values(did,3,'手机',3600,'打电话',0,2300);
insert into tproducts values(did,2,'手机',3600,'打电话',0,2300);

#select * from tproducts where bid=1
select tproducts.*,tsort.bname from (select * from tproducts where dstatus=0)tproducts left join tsort on tproducts.bid=tsort.bid ;
#update tproducts set dstatus=0 where did=2
#update tproducts set bid=2,dname='xx',dprice=3500,dremark='xxxx',dcount=200  where did=2
#select tproducts.*,tsort.bname from (select * from tproducts where did=2)tproducts left join tsort on tproducts.bid=tsort.bid ;
-- ----------------------------
-- Records of tproducts
-- ----------------------------

-- ----------------------------
-- Table structure for `torders` 销售订单表
-- ----------------------------
DROP TABLE IF EXISTS `torders`;
CREATE TABLE `torders` (
  `jid` int(8) NOT NULL AUTO_INCREMENT,
  `kid` int(8) NOT NULL,          #客户编号外键
  `jtime` date DEFAULT NULL,      #下单时间
  `jremark` text,                 #备注
  `jstatus` int DEFAULT NULL,    #默认 0为无值  1 为删除   2为有值
  PRIMARY KEY (`jid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into torders values(jid,2,'2016-06-05','备注1',0);
#update torders set jstatus=1 where jid=1;
select * from torders;
#select torders.*,tcustom.kname from (select * from torders where jstatus=2)torders left join tcustom on torders.kid=tcustom.kid order by jid desc
#  select max(jid) from torders;
#  select torders.*,tcustom.kname from torders left join tcustom on torders.kid=tcustom.kid order by jtime desc
#select torders.*,tcustom.kname from (select * from torders where kid=2)torders left join tcustom on torders.kid=tcustom.kid

-- ----------------------------
-- Records of torders
-- ----------------------------

-- ----------------------------
-- Table structure for `tordermx`  销售订单明细表
-- ----------------------------
DROP TABLE IF EXISTS `tordermx`;
CREATE TABLE `tordermx` (
  `mid` int(8) NOT NULL AUTO_INCREMENT,
  `jid` int(8) DEFAULT NULL,     #订单编号   外键
  `did` int(8) DEFAULT NULL,      #产品编号   外键
  `mcount` int(4) DEFAULT NULL,   #产品数量
  `mstatus` int DEFAULT NULL,    #默认 0为正常  1 为删除
  PRIMARY KEY (`mid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into tordermx values(mid,2,2,23,0);

select * from tordermx;    #根据订单编号查询
#select tordermx.*,tproducts.dname from tordermx left join tproducts on tordermx.did=tproducts.did;  #联合查询
#select tordermx.*,tproducts.dname from (select * from tordermx where jid=2 )tordermx left join tproducts on tordermx.did=tproducts.did; #根据订单编号查询详情
select * from tordermx;

#触发器   订单添加商品信息后修改产品的库存
CREATE TRIGGER tordermx_update_tproducts
AFTER INSERT ON tordermx
FOR EACH ROW
BEGIN
    update tproducts set dcount=(dcount-new.mcount) where tproducts.did=new.did;
END;

-- ----------------------------
-- Records of tordermx
-- ----------------------------

-- ----------------------------
-- Table structure for `tcustom`  客户信息表
-- ----------------------------
DROP TABLE IF EXISTS `tcustom`;
CREATE TABLE `tcustom` (
  `kid` int(8) NOT NULL AUTO_INCREMENT,
  `klogin` varchar(50) DEFAULT NULL,
  `kpass` varchar(50) DEFAULT NULL,
  `kname` varchar(20) DEFAULT NULL,
  `kaddress` varchar(20) DEFAULT NULL,
  `ktel` varchar(20) DEFAULT NULL,
  `gid` int(8) DEFAULT NULL,     #销售员编号  外键
  `kremark` text,
  `kstatus` int DEFAULT NULL,    #默认 0为正常  1 为删除
  PRIMARY KEY (`kid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into tcustom values(kid,'aa','aa','张总','湖北','12546254785',2,'备注',0);

#select * from tcustom where gid=2
#select tcustom.*,tuser.grealname from (select * from tcustom where gid=1)tcustom left join tuser on tcustom.gid=tuser.gid
#select tcustom.*,tuser.grealname from tcustom left join tuser on tcustom.gid=tuser.gid
-- ----------------------------
-- Records of tcustom
-- ----------------------------

-- ----------------------------
-- Records of tsort
-- ----------------------------

-- ----------------------------
-- Table structure for `tuser`  管理员表
-- ----------------------------
DROP TABLE IF EXISTS `tuser`;
CREATE TABLE `tuser` (
  `gid` int(8) NOT NULL AUTO_INCREMENT,
  `grealname` varchar(20) DEFAULT NULL,
  `gusername` varchar(20) DEFAULT NULL,
  `gpassword` varchar(20) DEFAULT NULL,
  `bstatus` int DEFAULT NULL,   #  0 为管理员   1位员工
  PRIMARY KEY (`gid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into tuser values(gid,'小明','admin','svse',0);
select * from tuser;
#update tuser set grealname='aaa' where gid=1;
#select * from tuser where gusername='admin' and gpassword='svse';

-- ----------------------------
-- Records of tuser
-- ----------------------------
