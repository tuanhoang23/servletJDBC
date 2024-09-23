package service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dao.iNewDAO;
import dao.icatagoriesDAO;
import dao.impl.newDAO;
import model.catagoriesModel;
import model.newsModel;
import paging.Pageable;
import service.iNewsService;

public class newService implements iNewsService {
	@Inject
	private iNewDAO newsDAO;

	@Inject
	private icatagoriesDAO catagoriesDAO;

	@Override
	public ArrayList<newsModel> findByCatagoryId(Long catagoryId)  {

		return newsDAO.findByCatagoryId(catagoryId);
	}

	@Override
	public newsModel save(newsModel news) {
		news.setCreateAt(new Timestamp(System.currentTimeMillis()));
		catagoriesModel catagoriesModel = catagoriesDAO.findOneByCode(news.getCatagoryCode());
		news.setCatagory_Id(catagoriesModel.getId());
		Long newId = newsDAO.save(news);
		return newsDAO.findOne(newId);
	}

	@Override
	public newsModel update(newsModel newsUpdate) {
		newsModel oldNews = newsDAO.findOne(newsUpdate.getId());
		newsUpdate.setCreateAt(oldNews.getCreateAt());
		newsUpdate.setCreateBy(oldNews.getCreateBy());
		newsUpdate.setModifileAt(new Timestamp(System.currentTimeMillis()));
		catagoriesModel catagoriesModel = catagoriesDAO.findOneByCode(newsUpdate.getCatagoryCode());
		newsUpdate.setCatagory_Id(catagoriesModel.getId());
		newsDAO.update(newsUpdate);
		return newsDAO.findOne(newsUpdate.getId());
	}

	@Override
	public void delete(long[] ids) {
		for(long id :ids) {
			newsDAO.delete(id);
		}
		
	}

	@Override
	public List<newsModel> findAll(Pageable pageable){

		return newsDAO.findAll(pageable);
	}

	@Override
	public int countItem() {

		return newsDAO.countItem();
	}

	@Override
	public newsModel findOne(long id) {
		newsModel news = newsDAO.findOne(id);
		catagoriesModel category = catagoriesDAO.findOne(news.getCatagory_Id());
		news.setCatagoryCode(category.getCode());
		return news;
	}

//	public newsModel findOne(Long id) {
//		newsModel news = newsDAO.findOne(id);
//		catagoriesModel category = catagoriesDAO.findOne(news.getCatagory_Id());
//		news.setCatagoryCode(category.getCode());
//		return news;
//	}

}
