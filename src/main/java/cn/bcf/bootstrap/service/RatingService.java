package cn.bcf.bootstrap.service;

import cn.bcf.bootstrap.entity.RatingEntity;

import java.util.List;

public interface RatingService extends BaseService<RatingEntity> {

    public List<RatingEntity> findByUserId(int userId);

}
