package cn.bcf.bootstrap.dao;

public interface LabelDao<T> extends CommonDao<T>{

    public String findLabelById(int id);
}
