package com.news.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.news.dao.ManagerMapper;
import com.news.entity.Manager;
import com.news.entity.User;


@Service("managerService")
public class ManagerService {
	@Resource
	 ManagerMapper managerMapper;
	//�������й���Ա�б�
	public List<Manager> findAll(){
		List<Manager> list=managerMapper.selectByExample(null);
		return list;
	}
	
	public Manager findManager(Manager m){
		
		return managerMapper.findManager(m);
		
	}
	
	//���ӹ���Ա
	public void saveManager(Manager m) {
		managerMapper.insertSelective(m);
    }
	//���¹���Ա��Ϣ
	public boolean updateUser(Manager m) {
		int i=managerMapper.updateByPrimaryKeySelective(m);
		if(i>0){return true;}
		else return false;
    }
	
	//����Idɾ������Ա
	public boolean deleteManager(int mid) {
		int i=managerMapper.deleteByPrimaryKey(mid);
		if(i>0){return true;}
		else return false;
       
    }
	//����Id���ҹ���Ա
	 public Manager findUserById(int mid) {
		 Manager m = managerMapper.selectByPrimaryKey(mid);
	        return m;
	    }

}
