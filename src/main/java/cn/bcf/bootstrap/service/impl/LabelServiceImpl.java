package cn.bcf.bootstrap.service.impl;

import cn.bcf.bootstrap.dao.LabelDao;
import cn.bcf.bootstrap.entity.LabelEntity;
import cn.bcf.bootstrap.service.LabelService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service("labelService")
public class LabelServiceImpl implements LabelService<LabelEntity> {

    @Autowired
    private LabelDao labelDao;

    @Override
    public boolean add(LabelEntity entity) {
        return labelDao.add(entity);
    }

    @Override
    public LabelEntity findById(Integer id) {
        return null;
    }

    @Override
    public List<LabelEntity> findAll() {
        return labelDao.findAll();
    }

    @Override
    public List<LabelEntity> findByEntity(LabelEntity entity) {
        return null;
    }

    @Override
    public JSONObject findAllByPage(int limit, int offset) {
        return null;
    }

    @Override
    public List<LabelEntity> findAllByPage(int limit, int offset, String searchText) {
        return null;
    }

    @Override
    public String findLabelById(int id) {
        return labelDao.findLabelById(id);
    }
}
