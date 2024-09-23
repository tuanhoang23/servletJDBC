package service;

import java.util.ArrayList;
import java.util.List;

import model.newsModel;
import paging.Pageable;

public interface iNewsService {
	
	ArrayList<newsModel> findByCatagoryId(Long catagoryId);
	void delete(long[] ids);
	newsModel save(newsModel news);
	newsModel update(newsModel newsUpdate);
	List<newsModel> findAll(Pageable pageable);
	int countItem();
	newsModel findOne(long id);

}
