package cn.bcf.bootstrap.service;

import cn.bcf.bootstrap.entity.UserEntity;

public interface UserService extends BaseService<UserEntity> {

    public UserEntity findUsernameAndPassword(UserEntity entity);
}
