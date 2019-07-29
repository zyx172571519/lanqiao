package org.taru.lanqiao.service;

import org.taru.lanqiao.model.User;
import org.taru.lanqiao.util.PageHelper;

public interface UserService {
	//��ѯ�û��б�
	PageHelper userSelectAll(int pageNum,int pageSize, String telphone, String shopName);
	
	//����ID��ѯ�û�
	User userFindById(String id);
	
	//����û�
	int userAdd(User user);
	
	//ɾ���û�
	int userDelete(String id);
	
	//�̳��û��޸�
	int userUpdate(User user);
}
