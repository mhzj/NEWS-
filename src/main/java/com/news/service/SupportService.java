package com.news.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.news.dao.SupportMapper;
import com.news.entity.Manager;
import com.news.entity.Support;

@Service("supportService")
public class SupportService {
	@Resource
	SupportMapper supportMapper;
	//�������������б�
	public List<Support> findAll(){
		List<Support> list=supportMapper.selectByExample(null);
		return list;
	}
	
	//��������
	public void savaSupport(Support s) {
		supportMapper.insertSelective(s);
    }
	//����������Ϣ
	public boolean updateSupport(Support s) {
		int i=supportMapper.updateByPrimaryKeySelective(s);
		if(i>0){return true;}
		else return false;
    }
	
	//����Idɾ������Ա
	public boolean deleteSupport(int mid) {
		int i=supportMapper.deleteByPrimaryKey(mid);
		if(i>0){return true;}
		else return false;
       
    }
	//����Id���ҹ���Ա
	 public Support  findSupportById(int mid) {
		Support s= supportMapper.selectByPrimaryKey(mid);
	        return s;
	    }

}