package dao;

import java.util.ArrayList;
import java.util.List;

import model.newsModel;
import paging.Pageable;

public interface iNewDAO extends genericDAO<newsModel> {
	
	ArrayList<newsModel> findByCatagoryId(Long catagoryId);
	Long save(newsModel news);
	void update(newsModel newsUpdate);
	void delete(long ids);
	newsModel findOne(Long id);
	List<newsModel> findAll(Pageable pageable);
	Integer countItem();
	
}
