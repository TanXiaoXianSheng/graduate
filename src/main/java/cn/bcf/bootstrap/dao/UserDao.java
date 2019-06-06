package cn.bcf.bootstrap.dao;

import cn.bcf.bootstrap.entity.UserEntity;

public interface UserDao<T> extends CommonDao<T>{

    public T findUsernameAndPassword(UserEntity entity);
}
