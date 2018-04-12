package cn.edu.hqu.cst.javaee.HuaMent.repository.impl;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import cn.edu.hqu.cst.javaee.HuaMent.entity.HquerMsg;
import cn.edu.hqu.cst.javaee.HuaMent.repository.HquerMsgRepository;

@Repository
public class FakeDataRepository implements HquerMsgRepository {

	private List<HquerMsg> hquerMsgList=new ArrayList<HquerMsg>();
	public FakeDataRepository() {
			for(int i=0;i<100;i++) {
				//由于页面采用utf-8编码，String也必须采用utf-8编码，不然会出现乱码
				String str=new String("消息"+i);
				try {
					str=new String(str.getBytes(),"utf-8");
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				hquerMsgList.add(new HquerMsg((long) i,str,new Date(),null,null));
			}
		}
	@Override
	public List<HquerMsg> findHquerMsg(long maxHquerMsgId, int count) {
		// TODO Auto-generated method stub
		int num=0;
		List<HquerMsg> tmphquerMsgList=new ArrayList<HquerMsg>();
		for(int i=hquerMsgList.size()-1;i>=0;i--){
			HquerMsg hquerMsg=hquerMsgList.get(i);
			if(hquerMsg.getId()<=maxHquerMsgId && num<count) {
				tmphquerMsgList.add(hquerMsg);
				num++;
			}else 
				break;
			
		}
		
		return tmphquerMsgList;
	}

	@Override
	public HquerMsg findOne(long hquerMsgId) {
		// TODO Auto-generated method stub
		for(HquerMsg hquerMsg:hquerMsgList) {
			if(hquerMsg.getId()==hquerMsgId)
				return hquerMsg;
		}
		return null;
	}

	@Override
	public void save(HquerMsg hquerMsg) {
		// TODO Auto-generated method stub
		hquerMsgList.add(hquerMsg);

	}

}
