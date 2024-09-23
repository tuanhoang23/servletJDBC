package service.impl;

import javax.inject.Inject;

import dao.iUserDAO;
import model.userModel;
import service.iNewsService;
import service.iUserService;

public class userService implements iUserService {
	
	@Inject
	private iUserDAO userDAO;
	
	@Override
	public userModel findByUserNameAndPw(String userName, String passWord, int status) {
		return userDAO.findByUserNameAndPw(userName, passWord, status);
	}

}
