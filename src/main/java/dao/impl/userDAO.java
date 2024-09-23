package dao.impl;

import java.util.ArrayList;
import java.util.List;

import dao.iNewDAO;
import dao.iUserDAO;
import mapper.newMapper;
import mapper.userMapper;
import model.newsModel;
import model.userModel;

public class userDAO extends abstractDAO<userModel> implements iUserDAO  {



	@Override
	public userModel findByUserNameAndPw(String userName, String passWord, int status) {

		StringBuilder sql = new StringBuilder("SELECT * FROM user AS u");
		sql.append(" JOIN role AS r ON r.id = u.role_id");
		sql.append(" WHERE username = ? AND password = ? AND status = ?");
		List<userModel> users = query(sql.toString(),new userMapper(),userName,passWord,status);
		return users.isEmpty() ? null : users.get(0);
		
	}

}
