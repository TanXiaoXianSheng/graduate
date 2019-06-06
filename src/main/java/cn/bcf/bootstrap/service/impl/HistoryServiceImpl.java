package cn.bcf.bootstrap.service.impl;

import cn.bcf.bootstrap.dao.HistoryDao;
import cn.bcf.bootstrap.entity.HistoryEntity;
import cn.bcf.bootstrap.service.HistoryService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service("historyService")
public class HistoryServiceImpl implements HistoryService {

    @Autowired
    private HistoryDao historyDao;

    @Override
    public boolean add(HistoryEntity entity) {
        return historyDao.add(entity);
    }

    @Override
    public HistoryEntity findById(Integer id) {
        return null;
    }

    @Override
    public List<HistoryEntity> findAll() {
        return null;
    }

    @Override
    public List<HistoryEntity> findByEntity(HistoryEntity entity) {
        return null;
    }

    @Override
    public JSONObject findAllByPage(int limit, int offset) {
        return null;
    }

    @Override
    public List<HistoryEntity> findAllByPage(int limit, int offset, String searchText) {
        return null;
    }

    @Override
    public HistoryEntity findByUserId(int userId) {
        return (HistoryEntity) historyDao.findByUserId(userId);
    }
}
