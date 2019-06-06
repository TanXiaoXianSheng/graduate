package cn.bcf.bootstrap.dao.impl;

import cn.bcf.bootstrap.dao.HistoryDao;
import cn.bcf.bootstrap.entity.HistoryEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "historyDao")
public class HistoryDaoImpl extends BaseDaoImpl<HistoryEntity> implements HistoryDao<HistoryEntity> {

    String tableName = "HistoryEntity";

    @Override
    public Integer getCount() {
        return null;
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
    public List<HistoryEntity> findAllByPage(Integer limit, Integer offset) {
        return null;
    }

    @Override
    public List<HistoryEntity> findAllByPage(Integer limit, Integer offset, String searchText) {
        return null;
    }

    @Override
    public HistoryEntity findByUserId(int userId) {
        String hql = "select t from " + tableName + " t where t.startTime = (select max(a.startTime) from " + tableName + " a where a.userId = " + userId + ")";
        List<HistoryEntity> list = entityManager.createQuery(hql).getResultList();
        HistoryEntity entity = null;
        if (list.size() > 0){
            entity = list.get(0);
        }
        return entity;
    }
}
