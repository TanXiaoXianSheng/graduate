package cn.bcf.bootstrap.dao.impl;

import cn.bcf.bootstrap.dao.LabelDao;
import cn.bcf.bootstrap.entity.LabelEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "labelDao")
public class LabelDaoImpl extends BaseDaoImpl<LabelEntity> implements LabelDao<LabelEntity> {

    String tableName = "LabelEntity";

    @Override
    public Integer getCount() {
        return null;
    }

    @Override
    public LabelEntity findById(Integer id) {
        return findById(tableName,id);
    }

    @Override
    public List<LabelEntity> findAll() {
        return findAll(tableName);
    }

    @Override
    public List<LabelEntity> findAllByPage(Integer limit, Integer offset) {
        return null;
    }

    @Override
    public List<LabelEntity> findAllByPage(Integer limit, Integer offset, String searchText) {
        return null;
    }

    @Override
    public String findLabelById(int id) {
        String hql = " select t.label from " + tableName + " t where t.id = " + id;
        List<String> list = entityManager.createQuery(hql).getResultList();
        String entity = list.get(0);
        return entity;
    }
}
