package cn.bcf.bootstrap.dao;

import java.util.List;

public interface CommonDao<T> extends BaseDao<T> {

    public Integer getCount();

    public T findById(Integer id);

    public List<T> findAll();

    public List<T> findAllByPage(Integer limit, Integer offset);

    public List<T> findAllByPage(Integer limit, Integer offset, String searchText);
}
