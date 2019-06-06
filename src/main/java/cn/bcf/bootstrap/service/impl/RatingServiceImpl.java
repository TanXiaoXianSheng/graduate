package cn.bcf.bootstrap.service.impl;

import cn.bcf.bootstrap.dao.RatingDao;
import cn.bcf.bootstrap.entity.RatingEntity;
import cn.bcf.bootstrap.service.RatingService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service("ratingService")
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingDao ratingDao;

    @Override
    public boolean add(RatingEntity entity) {
        return false;
    }

    @Override
    public RatingEntity findById(Integer id) {
        return null;
    }

    @Override
    public List<RatingEntity> findAll() {
        return null;
    }

    @Override
    public List<RatingEntity> findByEntity(RatingEntity entity) {
        return null;
    }

    @Override
    public JSONObject findAllByPage(int limit, int offset) {
        return null;
    }

    @Override
    public List<RatingEntity> findAllByPage(int limit, int offset, String searchText) {
        return null;
    }

    @Override
    public List<RatingEntity> findByUserId(int userId) {
        return ratingDao.findByUserId(userId);
    }
}
