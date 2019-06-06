package cn.bcf.bootstrap.dao;

import java.util.List;

public interface BaseDao<T> {

    public Integer getCount(String tableName);

    public boolean add(T entity);

    public T findById(String tableName, Integer id);

    public List<T> findAll(String tableName);

    public List<T> findAllByEntity(T entity);

    public List<T> findAllByPage(String tableName, Integer limit, Integer offset);

    public List<T> findAllByPage(String tableName, Integer limit, Integer offset, String searchText);

    public List<T> findAllByPage(String tableName, Integer limit, Integer offset, T entity);
}
