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
public class JpaDaoService extends JpaDaoSupport implements IJpaDaoService{

    public <T extends Object> void create(T entity) {
        getJpaTemplate().persist(entity);
    }

    public <T extends Object> void destroy(Class<T> t,Integer id) {
        getJpaTemplate().remove(getJpaTemplate().find(t, id));
    }

    public <T extends Object> void destroy(Class<T> t,String id) {
        getJpaTemplate().remove(getJpaTemplate().find(t, new Integer(id)));
    }

    public <T extends Object> T edit(T entity) {
        return getJpaTemplate().merge(entity);
    }

    public int executeUpdate(final String jpql, final Map<String,? extends Object> params) {
        return (Integer)getJpaTemplate().execute(new JpaCallback() {

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
    public List findByNamedQueryAndNamedParams(String queryName, Map<String,? extends Object> params) {
        return getJpaTemplate().findByNamedQueryAndNamedParams(queryName, params);
    }
    @Deprecated
    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public List findByNamedQueryAndNamedParams(final String queryName, final Map<String,? extends Object> params, final boolean all, final int firstResult, final int maxResults) {
        return getJpaTemplate().executeFind(new JpaCallback() {

            public Object doInJpa(EntityManager em) throws PersistenceException {

                try {
                    String ql = queryName;
                    if (queryName == null || queryName.equals("")) {
                        //ql = "select object(o) from Document as o";
                        return null;
                    }

                    Query q = em.createNamedQuery(ql);
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
    public List findEntities(final String jpql, final Map<String,? extends Object> params, final boolean all, final int firstResult, final int maxResults) {
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
    public <T extends Object> T findOneEntityById(Class<T> t,Integer id) {
        return getJpaTemplate().find(t, id);
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public <T extends Object> T findOneEntityById(Class<T> t,String id) {
        return getJpaTemplate().find(t, new Integer(id));
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public Integer getEntityCount(final String jpql,final Map<String,? extends Object> params) {
        return ((Long)getJpaTemplate().execute(new JpaCallback() {

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
                    return q.getSingleResult();
                } finally {
                    em.close();
                }
            }
        })).intValue();

    }
    @Deprecated
    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public Integer getNamedQueryEntityCount(final String queryName,final Map<String,? extends Object> params) {
        return (Integer)getJpaTemplate().execute(new JpaCallback() {

            public Object doInJpa(EntityManager em) throws PersistenceException {
                try {
                    String ql = queryName;
                    if (queryName == null || queryName.equals("")) {
                        return 0L;
                    }

                    Query q = em.createNamedQuery(ql);
                    if (params != null && params.size() > 0) {
                        for (Object obj : params.keySet()) {
                            String str = (String) obj;
                            q.setParameter(str, params.get(str));
                        }
                    }
                    return q.getResultList().size();
                } finally {
                    em.close();
                }
            }
        });
    }

}
