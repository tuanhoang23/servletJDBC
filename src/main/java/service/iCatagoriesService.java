package service;

import java.util.ArrayList;

import model.catagoriesModel;

public interface iCatagoriesService {
	
	ArrayList<catagoriesModel> findAll();
	catagoriesModel save(catagoriesModel catagorySave);
	catagoriesModel update(catagoriesModel catagoryupdate);
	void delete(long[] ids);
	
}
