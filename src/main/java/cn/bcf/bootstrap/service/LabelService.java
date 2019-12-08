package cn.bcf.bootstrap.service;


import cn.bcf.bootstrap.entity.LabelEntity;

public interface LabelService<T> extends BaseService<LabelEntity> {

    public String findLabelById(int id);

}
