package dao;

import java.util.ArrayList;

import model.catagoriesModel;


public interface icatagoriesDAO extends genericDAO<catagoriesModel>  {

	ArrayList<catagoriesModel> findAll();
	Long save(catagoriesModel catagorySave);
	void update(catagoriesModel catagoryUpdate);
	void delete(long ids);
	catagoriesModel findOne(long id);
	catagoriesModel findOneByCode(String code);
}
