package cn.bcf.bootstrap.dao;

import cn.bcf.bootstrap.entity.RatingEntity;

import java.util.List;

public interface RatingDao<T> extends CommonDao<T>{

    public List<T> findByUserId(int userId);

}
