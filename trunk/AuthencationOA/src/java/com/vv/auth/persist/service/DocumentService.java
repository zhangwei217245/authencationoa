/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vv.auth.persist.service;

import com.vv.auth.persist.entity.Document;
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
 * @author hp
 */
@Transactional
public class DocumentService extends JpaDaoSupport implements IEntityService {

    public void create(IEntity entity) {

        getJpaTemplate().persist(entity);
    }

    public void destroy(Integer id) {

        getJpaTemplate().remove(getJpaTemplate().find(Document.class, id));

    }

    public void destroy(String sid) {

        Integer id = Integer.parseInt(sid);
        getJpaTemplate().remove(getJpaTemplate().find(Document.class, id));

    }

    public IEntity edit(IEntity entity) {

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


                        ql = "select object(o) from Document as o";

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
    public IEntity findOneEntityById(Integer id) {

        return getJpaTemplate().find(Document.class, id);
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public IEntity findOneEntityById(String id) {

        return getJpaTemplate().find(Document.class, Integer.parseInt(id));

    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public int getEntityCount(final String jpql, final Map params) {

        return ((Long) getJpaTemplate().execute(new JpaCallback() {

            public Object doInJpa(EntityManager em) throws PersistenceException {
                try {
                    String ql = jpql;
                    if (jpql == null || jpql.equals("")) {


                        ql = "select count(o) from Document as o";

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
