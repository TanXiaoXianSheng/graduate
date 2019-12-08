package cn.bcf.bootstrap.dao.impl;

import cn.bcf.bootstrap.dao.MovieDao;
import cn.bcf.bootstrap.entity.MovieEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "MovieDao")
public class MovieDaoImpl extends BaseDaoImpl<MovieEntity> implements MovieDao<MovieEntity> {

    String tableName = "MovieEntity";

    @Override
    public Integer getCount() {
        return null;
    }

    @Override
    public MovieEntity findById(Integer id) {
        return findById(tableName,id);
    }

    @Override
    public List<MovieEntity> findAll() {
        return this.findAll(tableName);
    }

    @Override
    public List<MovieEntity> findAllByPage(Integer limit, Integer offset) {
        return null;
    }

    @Override
    public List<MovieEntity> findAllByPage(Integer limit, Integer offset, String searchText) {
        return null;
    }

    @Override
    public MovieEntity findByMovieId(int movieId) {
        String hql = " select t from " + tableName + " t where t.movieId = " + movieId;
        List<MovieEntity> list = entityManager.createQuery(hql).getResultList();
        MovieEntity entity = list.get(0);
        return entity;
    }
}
