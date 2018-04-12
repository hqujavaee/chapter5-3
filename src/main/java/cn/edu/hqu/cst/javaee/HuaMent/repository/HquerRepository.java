package cn.edu.hqu.cst.javaee.HuaMent.repository;

import cn.edu.hqu.cst.javaee.HuaMent.entity.Hquer;

public interface HquerRepository {

	Hquer save(Hquer hquer);
	Hquer findByUserName(String userName);

}
