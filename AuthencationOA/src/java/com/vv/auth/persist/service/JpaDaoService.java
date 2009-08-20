/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vv.auth.persist.service;


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
 * @author x-spirit
 */
@Transactional
public class JpaDaoService extends JpaDaoSupport{

    public <T extends IEntity> void create(T entity) {
        getJpaTemplate().persist(entity);
    }

    public <T extends IEntity> void destroy(Class<T> t,Integer id) {
        getJpaTemplate().remove(getJpaTemplate().find(t, id));
    }

    public <T extends IEntity> void destroy(Class<T> t,String id) {
        getJpaTemplate().remove(getJpaTemplate().find(t, new Integer(id)));
    }

    public <T extends IEntity> T edit(T entity) {
        return getJpaTemplate().merge(entity);
    }

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

    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public List<IEntity> findByNamedQueryAndNamedParams(String queryName, Map params) {
        return getJpaTemplate().findByNamedQueryAndNamedParams(queryName, params);
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public List<IEntity> findEntities(final String jpql, final Map params, final boolean all, final int firstResult, final int maxResults) {
        return getJpaTemplate().executeFind(new JpaCallback() {

            public Object doInJpa(EntityManager em) throws PersistenceException {

                try {
                    String ql = jpql;
                    if (jpql == null || jpql.equals("")) {
                        //ql = "select object(o) from Document as o";
                        return null;
                    }

                    Query q = em.createQuery(ql);
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

    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public <T extends IEntity> T findOneEntityById(Class<T> t,Integer id) {
        return getJpaTemplate().find(t, id);
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public <T extends IEntity> T findOneEntityById(Class<T> t,String id) {
        return getJpaTemplate().find(t, new Integer(id));
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public int getEntityCount(final String jpql,final Map params) {
        return ((Long) getJpaTemplate().execute(new JpaCallback() {

            public Object doInJpa(EntityManager em) throws PersistenceException {
                try {
                    String ql = jpql;
                    if (jpql == null || jpql.equals("")) {


                        return 0L;

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

}
