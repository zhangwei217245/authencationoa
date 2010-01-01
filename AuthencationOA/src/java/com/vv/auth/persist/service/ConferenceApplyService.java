/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vv.auth.persist.service;

import com.vv.auth.persist.entity.ConferenceApply;
import com.vv.auth.persist.entity.Documenttype;
import com.vv.auth.persist.entity.IEntity;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import org.springframework.orm.jpa.JpaCallback;
import org.springframework.orm.jpa.support.JpaDaoSupport;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author X-Spirit
 */
@Transactional
public class ConferenceApplyService extends JpaDaoSupport implements IEntityService {

    /**
     * 查询不需要事务操作
     * 使用实体ID查询实体
     * @param id
     * @return
     */
    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public IEntity findOneEntityById(Integer id) {
        return getJpaTemplate().find(ConferenceApply.class, id);
    }

    /**
     * 使用实体ID查询实体
     * @param id
     * @return
     */
    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public IEntity findOneEntityById(String sid) {
        return getJpaTemplate().find(ConferenceApply.class, sid);
    }

    /**
     * 使用命名查询和命名参数进行查询
     * @param queryName
     * @param params
     * @return
     */
    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public List<IEntity> findByNamedQueryAndNamedParams(String queryName, Map params) {
        return getJpaTemplate().findByNamedQueryAndNamedParams(queryName, params);

    }

    /**
     * 查询实体列表。可以指定查询语句和命名参数，all为true时表示查询全部，否则，指定firstResult指定其实位置，maxResults指定查询记录数
     * @param jpql
     * @param params
     * @param all
     * @param firstResult
     * @param maxResults
     * @return
     */
    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public List<IEntity> findEntities(final String jpql, final Map params, final boolean all, final int firstResult, final int maxResults) {

        return getJpaTemplate().executeFind(new JpaCallback() {

            public Object doInJpa(EntityManager em) throws PersistenceException {
                try {
                    String ql = jpql;
                    if (jpql == null || jpql.equals("")) {
                        ql = "select object(o) from ConferenceApply as o";
                    }

                    Query q = em.createQuery(ql);
                    //给q设定参数
                    if (params != null && params.size() > 0) {
                        for (Object obj : params.keySet()) {
                            String str = (String) obj;
                            q.setParameter(str, params.get(str));
                        }
                    }

                    if (!all) {
                        q.setMaxResults(maxResults);
                        q.setFirstResult(firstResult);
                    }
                    return q.getResultList();
                } finally {
                    em.close();
                }
            }
        });

    }

    /**
     * 查询实体个数，可以指定查询语句和查询参数
     * @param jpql
     * @param params
     * @return
     */
    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public int getEntityCount(final String jpql, final Map params) {
        return ((Long) getJpaTemplate().execute(new JpaCallback() {

            public Object doInJpa(EntityManager em) throws PersistenceException {
                try {
                    String ql = jpql;
                    if (jpql == null || jpql.equals("")) {
                        ql = "select count(o) from ConferenceApply as o";
                    }

                    Query q = em.createQuery(ql);
                    if (params != null && params.size() > 0) {
                        for (Object obj : params.keySet()) {
                            String str = (String) obj;
                            q.setParameter(str, params.get(str));
                        }
                    }
                    return (Long) q.getSingleResult();
                } finally {
                    em.close();
                }
            }
        })).intValue();
    }

    /**
     * 创建实体
     * @param entity
     */
    public void create(IEntity entity) {
        getJpaTemplate().persist(entity);
    }

    /**
     * 更新实体
     * @param entity
     * @return
     */
    public IEntity edit(IEntity entity) {
        return getJpaTemplate().merge(entity);
    }

    /**
     * Can be used when a delete statement or an update statement will be called.
     * @param jpql
     * @param params
     * @return
     */
    public int executeUpdate(final String jpql, final Map params) {
        return (Integer) getJpaTemplate().execute(new JpaCallback() {

            public Object doInJpa(EntityManager em) throws PersistenceException {
                try {
                    String ql = jpql;
                    Query q = em.createQuery(ql);
                    if (params != null && params.size() > 0) {
                        for (Object obj : params.keySet()) {
                            String str = (String) obj;
                            q.setParameter(str, params.get(str));
                        }
                    }
                    return q.executeUpdate();
                } finally {
                    em.close();
                }
            }
        });
    }

    /**
     * 删除实体
     * @param id
     */
    public void destroy(Integer id) {
        getJpaTemplate().remove(findOneEntityById(id));
    }

    /**
     * 删除实体
     * @param id
     */
    public void destroy(String sid) {
        getJpaTemplate().remove(findOneEntityById(sid));
    }
}
