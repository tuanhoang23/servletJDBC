package dao.impl;

import java.util.ArrayList;
import java.util.List;

import dao.iNewDAO;
import mapper.newMapper;
import model.newsModel;
import paging.Pageable;

public class newDAO extends abstractDAO<newsModel> implements iNewDAO {

	@Override
	public ArrayList<newsModel> findByCatagoryId(Long catagoryId) {
		String sql ="SELECT * FROM news WHERE catagory_id = ?";
		return query(sql,new newMapper(),catagoryId);
	}

	@Override
	public Long save(newsModel news) {

		StringBuilder sql = new StringBuilder("INSERT INTO news (title ,thumbnail ,shortdescription ,content ,catagory_id ,create_at ,createby) VAlUES");
				sql.append("(?,?,?,?,?,?,?)");
		return insert(sql.toString(),news.getTitle(),news.getThumbnail(),news.getShortDescription(),
				news.getContent(),news.getCatagory_Id(),news.getCreateAt(),news.getCreateBy());
	}
	
	

	@Override
	public void update(newsModel newsUpdate) {
		StringBuilder sql = new StringBuilder("UPDATE news SET title = ? ,");
				sql.append("thumbnail = ? ,shortdescription = ?, content = ?, catagory_id = ?, ");
				sql.append("create_at = ? ,modifile_at = ? , createby = ? , modifileby = ? WHERE id = ?");
		
		update(sql.toString(),newsUpdate.getTitle(), newsUpdate.getThumbnail(), 
				newsUpdate.getShortDescription(), newsUpdate.getContent(), 
				newsUpdate.getCatagory_Id(), newsUpdate.getCreateAt(), 
				newsUpdate.getModifileAt(), newsUpdate.getCreateBy(), 
				newsUpdate.getModifileBy(), newsUpdate.getId());
		
	}
 
	@Override
	public newsModel findOne(Long id){
		String sql = "SELECT * FROM news WHERE id = ?";
		ArrayList<newsModel> news = query(sql,new newMapper(),id);
		return news.isEmpty() ? null : news.get(0);
	}



	@Override
	public void delete(long ids) {
		String sql = "DELETE FROM news WHERE id = ?";
		delete(sql,ids);
	}

	@Override
	public List<newsModel> findAll(Pageable pageable) {
		StringBuilder sql = new StringBuilder("SELECT * FROM news");
		if(pageable.getSorter() != null) {
			
			sql.append(" ORDER BY "+pageable.getSorter().getSortName()+" "+pageable.getSorter().getSortBy()+"");
		}
		if(pageable.getOffset() != null && pageable.getLimit() !=null) {
			
			sql.append(" LIMIT "+pageable.getOffset()+","+pageable.getLimit()+"");
		}
		return query(sql.toString(),new newMapper());
	}

	@Override
	public Integer countItem() {
		String sql = "SELECT count(*) FROM news";
		return count(sql);
	}

}
