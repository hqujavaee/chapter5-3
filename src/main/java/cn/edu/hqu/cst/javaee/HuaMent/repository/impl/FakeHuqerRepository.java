package cn.edu.hqu.cst.javaee.HuaMent.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import cn.edu.hqu.cst.javaee.HuaMent.entity.Hquer;
import cn.edu.hqu.cst.javaee.HuaMent.repository.HquerRepository;
@Repository
public class FakeHuqerRepository implements HquerRepository {
	private List<Hquer> hquerList=new ArrayList<Hquer>();

	@Override
	public Hquer save(Hquer hquer) {
		// TODO Auto-generated method stub
		hquerList.add(hquer);
		return hquer;

	}

	@Override
	public Hquer findByUserName(String userName) {
		// TODO Auto-generated method stub
		for(Hquer hquer:hquerList) {
			if(userName.equalsIgnoreCase(hquer.getUserName()))
				return hquer;
		}
		return null;
	}

}
