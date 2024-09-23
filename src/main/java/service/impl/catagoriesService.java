package service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;

import javax.inject.Inject;

import dao.icatagoriesDAO;
import dao.impl.catagoriesDAO;
import model.catagoriesModel;
import service.iCatagoriesService;

public class catagoriesService implements iCatagoriesService {
	
	// kiểu cũ
//	private icatagoriesDAO catagoryDAO;
//	
//	public catagoriesService() {
//		catagoryDAO = new catagoriesDAO();
//	}
	
	//sử dụng weld
	@Inject
	private icatagoriesDAO catagoryDAO;
	
	@Override
	public ArrayList<catagoriesModel> findAll() {
		
		return catagoryDAO.findAll();
	}

	@Override
	public catagoriesModel save(catagoriesModel catagorySave) {
		catagorySave.setCreateAt(new Timestamp(System.currentTimeMillis()));
		catagorySave.setCreateBy("hoang dep trai");
		long catagoryId = catagoryDAO.save(catagorySave);
		return catagoryDAO.findOne(catagoryId);
	}

	@Override
	public catagoriesModel update(catagoriesModel catagoryupdate) {
		catagoriesModel oldcatagory = catagoryDAO.findOne(catagoryupdate.getId());
		catagoryupdate.setCreateAt(oldcatagory.getCreateAt());
		catagoryupdate.setCreateBy(oldcatagory.getCreateBy());
		catagoryupdate.setModifileAt(new Timestamp(System.currentTimeMillis()));
		catagoryupdate.setModifileBy("hoang rat dep trai");
		catagoryDAO.update(catagoryupdate);
		return catagoryDAO.findOne(catagoryupdate.getId());
	}

	@Override
	public void delete(long[] ids) {
		for(long id: ids) {
			catagoryDAO.delete(id);
		}
		
	}
	
}
