package dao;

import java.util.ArrayList;
import java.util.List;

import model.newsModel;
import model.userModel;
import paging.Pageable;

public interface iUserDAO extends genericDAO<userModel> {
	userModel findByUserNameAndPw(String userName , String passWord ,int status); 
	
}
