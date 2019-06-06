package cn.bcf.bootstrap.service;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

public interface BaseService<T> {

    public boolean add(T entity);

    public T findById(Integer id);

    public List<T> findAll();

    public List<T> findByEntity(T entity);

    public JSONObject findAllByPage(int limit, int offset);

    public List<T> findAllByPage(int limit, int offset, String searchText);


}
