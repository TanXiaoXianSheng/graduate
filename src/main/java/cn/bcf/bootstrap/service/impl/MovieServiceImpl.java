package cn.bcf.bootstrap.service.impl;

import cn.bcf.bootstrap.dao.MovieDao;
import cn.bcf.bootstrap.entity.MovieEntity;
import cn.bcf.bootstrap.service.MovieService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service("movieService")
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieDao movieDao;

    @Override
    public boolean add(MovieEntity entity) {
        return false;
    }

    @Override
    public MovieEntity findById(Integer id) {
        return null;
    }

    @Override
    public List<MovieEntity> findAll() {
        return movieDao.findAll();
    }

    @Override
    public List<MovieEntity> findByEntity(MovieEntity entity) {
        return null;
    }

    @Override
    public JSONObject findAllByPage(int limit, int offset) {
        return null;
    }

    @Override
    public List<MovieEntity> findAllByPage(int limit, int offset, String searchText) {
        return null;
    }

    @Override
    public MovieEntity findByMovieId(int movieId) {
        return (MovieEntity) movieDao.findByMovieId(movieId);
    }
}
