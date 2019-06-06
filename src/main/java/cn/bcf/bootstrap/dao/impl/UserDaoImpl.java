package cn.bcf.bootstrap.dao.impl;

import cn.bcf.bootstrap.dao.UserDao;
import cn.bcf.bootstrap.entity.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "userDao")
public class UserDaoImpl extends BaseDaoImpl<UserEntity> implements UserDao<UserEntity> {

    String tableName = "UserEntity";

    @Override
    public Integer getCount() {
        return this.getCount(tableName);
    }

    @Override
    public UserEntity findById(Integer id) {
        return this.findById(tableName,id);
    }

    @Override
    public List<UserEntity> findAll() {
        return null;
    }

    @Override
    public List<UserEntity> findAllByPage(Integer limit, Integer offset) {
        return null;
    }

    @Override
    public List<UserEntity> findAllByPage(Integer limit, Integer offset, String searchText) {
        return null;
    }

    @Override
    public UserEntity findUsernameAndPassword(UserEntity entity) {
        String hql = " select t from " + tableName + " t where t.username = " + entity.getUsername() + " and t.password = " + entity.getPassword();
        List<UserEntity> list =  entityManager.createQuery(hql).getResultList();
        entity = list.get(0);
        return entity;
    }
}
