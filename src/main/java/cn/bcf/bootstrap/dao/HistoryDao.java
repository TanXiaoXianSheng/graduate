package cn.bcf.bootstrap.dao;

public interface HistoryDao<T> extends CommonDao<T>{

    public T findByUserId(int userId);
}
