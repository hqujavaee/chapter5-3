package cn.edu.hqu.cst.javaee.HuaMent.repository;

import java.util.List;

import cn.edu.hqu.cst.javaee.HuaMent.entity.HquerMsg;

public interface HquerMsgRepository {
	
	List<HquerMsg> findHquerMsg(long maxHquerMsgId,int count);

	HquerMsg findOne(long hquerMsgId);

	void save(HquerMsg hquerMsg);
}
