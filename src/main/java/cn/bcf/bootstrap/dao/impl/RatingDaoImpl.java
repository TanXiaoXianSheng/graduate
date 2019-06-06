package cn.bcf.bootstrap.dao.impl;

import cn.bcf.bootstrap.dao.RatingDao;
import cn.bcf.bootstrap.entity.RatingEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "ratingDao")
public class RatingDaoImpl extends BaseDaoImpl<RatingEntity> implements RatingDao<RatingEntity> {

    String tableName = "RatingEntity";

    @Override
    public Integer getCount() {
        return null;
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
    public List<RatingEntity> findAllByPage(Integer limit, Integer offset) {
        return null;
    }

    @Override
    public List<RatingEntity> findAllByPage(Integer limit, Integer offset, String searchText) {
        return null;
    }

    @Override
    public List<RatingEntity> findByUserId(int userId) {
        String hql = " select t from " + tableName + " t where t.userId = " + userId;
        List<RatingEntity> list = entityManager.createQuery(hql).getResultList();
        return list;
    }
}
