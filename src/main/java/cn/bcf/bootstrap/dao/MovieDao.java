package cn.bcf.bootstrap.dao;

public interface MovieDao<T> extends CommonDao<T>{

    public T findByMovieId(int movieId);
}
