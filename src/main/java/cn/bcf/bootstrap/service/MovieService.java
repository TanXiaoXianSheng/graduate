package cn.bcf.bootstrap.service;

import cn.bcf.bootstrap.entity.MovieEntity;

public interface MovieService extends BaseService<MovieEntity> {

    public MovieEntity findByMovieId(int movieId);

}
