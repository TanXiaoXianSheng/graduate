package cn.bcf.bootstrap.service.impl;

import cn.bcf.bootstrap.dao.LabelDao;
import cn.bcf.bootstrap.dao.MovieDao;
import cn.bcf.bootstrap.entity.LabelEntity;
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

    @Autowired
    private LabelDao labelDao;

    @Override
    public boolean add(MovieEntity entity) {
        return movieDao.add(entity);
    }

    @Override
    public MovieEntity findById(Integer id) {
        return (MovieEntity) movieDao.findById(id);
    }

    @Override
    public List<MovieEntity> findAll() {
        /*List<MovieEntity> list = movieDao.findAll();
        list.iterator().forEachRemaining(entity -> {
            entity.setMovieLabel(labelDao.findLabelById(Integer.parseInt(entity.getMovieLabel())));
        });*/
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
