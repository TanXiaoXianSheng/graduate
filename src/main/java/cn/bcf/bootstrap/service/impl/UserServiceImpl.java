package cn.bcf.bootstrap.service.impl;

import cn.bcf.bootstrap.dao.UserDao;
import cn.bcf.bootstrap.dao.impl.UserDaoImpl;
import cn.bcf.bootstrap.entity.UserEntity;
import cn.bcf.bootstrap.service.UserService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public boolean add(UserEntity entity) {
        return userDao.add(entity);
    }

    @Override
    public UserEntity findById(Integer id) {
        return null;
    }

    @Override
    public List<UserEntity> findAll() {
        return null;
    }

    @Override
    public List<UserEntity> findByEntity(UserEntity entity) {
        return null;
    }

    @Override
    public JSONObject findAllByPage(int limit, int offset) {
        return null;
    }

    @Override
    public List<UserEntity> findAllByPage(int limit, int offset, String searchText) {
        return null;
    }

    @Override
    public UserEntity findUsernameAndPassword(UserEntity entity) {
        return (UserEntity) userDao.findUsernameAndPassword(entity);
    }
}
