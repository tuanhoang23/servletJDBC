package dao;

import java.util.ArrayList;

import mapper.rowMapper;


public interface genericDAO<T> {
	
	<T> ArrayList<T> query(String sql ,rowMapper<T> rowMapper,Object... parameters);
	void update (String sql,Object... parameters);
	Long insert (String sql,Object... parameters);
	void delete (String sql,Object... parameters);
	int count(String sql,Object... parameters);
}
