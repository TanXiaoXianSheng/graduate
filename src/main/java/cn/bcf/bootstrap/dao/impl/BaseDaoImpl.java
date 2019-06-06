package cn.bcf.bootstrap.dao.impl;

import cn.bcf.bootstrap.dao.BaseDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class BaseDaoImpl<T> implements BaseDao<T> {

    @PersistenceContext
    public EntityManager entityManager;

    /**
     * 这个方法要修改，应该可以直接获取记录条数
     * @param tableName
     * @return
     */
    @Override
    public Integer getCount(String tableName) {
        String hql = " from "+ tableName;
        List<T> list = entityManager.createQuery(hql).getResultList();
        return list.size();
    }

    @Override
    public boolean add(T entity) {
        boolean flag = false;
        try {
            entityManager.persist(entity);
            flag = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public T findById(String tableName, Integer id) {
        String hql = " from " + tableName + " t where t.id =" + Integer.toString(id);
        List<T> list = entityManager.createQuery(hql).getResultList();
        T entity = list.get(0);
        return entity;
    }

    @Override
    public List<T> findAll(String tableName) {
        String hql = " from "+ tableName;
        List<T> list = entityManager.createQuery(hql).getResultList();
        entityManager.close();
        return list;
    }

    @Override
    public List<T> findAllByEntity(T entity) {
        return null;
    }

    @Override
    public List<T> findAllByPage(String tableName,Integer limit, Integer offset) {
        String hql = " from " + tableName;
        Query query = entityManager.createQuery(hql);
        query.setFirstResult(limit);
        query.setMaxResults(offset);
        List<T> list = query.getResultList();
        entityManager.close();
        return list;
    }

    @Override
    public List<T> findAllByPage(String tableName, Integer limit, Integer offset, String searchText) {
        return null;
    }

    @Override
    public List<T> findAllByPage(String tableName, Integer limit, Integer offset, T entity) {
        return null;
    }
}
