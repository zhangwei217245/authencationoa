/*
 * JpaDaoService with Generic Support,
 * No need to write specified DAO Service for each Entity.
 */

package com.vv.auth.persist.service;

import java.math.BigDecimal;
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
 * JpaDaoService with Generic Support,
 * No need to write specified DAO Service for each Entity.
 * @author x-spirit
 */
@Transactional
public class JpaDaoService extends JpaDaoSupport implements IJpaDaoService{

    /**
     *
     * @param entity
     * @return
     */
    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public boolean containsEntity(Object entity){
        return getJpaTemplate().contains(entity);
    }

    /**
     *
     * @param <T>
     * @param entity
     */
    public <T extends Object> void create(T entity) {
        getJpaTemplate().persist(entity);
    }

    /**
     *
     * @param <T>
     * @param t
     * @param id
     */
    public <T extends Object> void destroy(Class<T> t,Integer id) {
        getJpaTemplate().remove(getJpaTemplate().find(t, id));
    }

    /**
     *
     * @param <T>
     * @param t
     * @param id
     */
    public <T extends Object> void destroy(Class<T> t,String id) {
        getJpaTemplate().remove(getJpaTemplate().find(t, new Integer(id)));
    }

    /**
     *
     * @param <T>
     * @param t
     * @param id
     */
    public <T extends Object> void destroy(Class<T> t,Object id) {
        getJpaTemplate().remove(getJpaTemplate().find(t, id));
    }

    /**
     *
     * @param <T>
     * @param entity
     * @return
     */
    public <T extends Object> T edit(T entity) {
        return getJpaTemplate().merge(entity);
    }

    /**
     *
     * @param jpql
     * @param params
     * @return
     */
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

    /**
     *
     * @param queryName
     * @param params
     * @return
     */
    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public List findByNamedQueryAndNamedParams(String queryName, Map<String,? extends Object> params) {
        return getJpaTemplate().findByNamedQueryAndNamedParams(queryName, params);
    }
    /**
     *
     * @param queryName
     * @param params
     * @param all
     * @param firstResult
     * @param maxResults
     * @return
     * @deprecated
     */
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

    /**
     *
     * @param jpql
     * @param params
     * @param all
     * @param firstResult
     * @param maxResults
     * @return
     */
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

    /**
     *
     * @param <T>
     * @param t
     * @param id
     * @return
     */
    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public <T extends Object> T findOneEntityById(Class<T> t,Integer id) {
        return getJpaTemplate().find(t, id);
    }

    /**
     *
     * @param <T>
     * @param t
     * @param id
     * @return
     */
    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public <T extends Object> T findOneEntityById(Class<T> t,String id) {
        return getJpaTemplate().find(t, new Integer(id));
    }

    /**
     *
     * @param <T>
     * @param t
     * @param id
     * @return
     */
    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public <T extends Object> T findOneEntityById(Class<T> t,Object id) {
        return getJpaTemplate().find(t, id);
    }

    /**
     *
     * @param jpql
     * @param params
     * @return
     */
    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public Object getSingleResult(final String jpql,final Map<String,? extends Object> params){
        return getJpaTemplate().execute(new JpaCallback() {

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
        });
    }

    /**
     *
     * @param jpql
     * @param params
     * @return
     */
    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public BigDecimal getEntityCount(final String jpql,final Map<String,? extends Object> params) {
        return (BigDecimal)getJpaTemplate().execute(new JpaCallback() {

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
                    return new BigDecimal(q.getSingleResult().toString());
                } finally {
                    em.close();
                }
            }
        });

    }
    /**
     *
     * @param queryName
     * @param params
     * @return
     * @deprecated
     */
    @Deprecated
    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public BigDecimal getNamedQueryEntityCount(final String queryName,final Map<String,? extends Object> params) {
        return (BigDecimal)getJpaTemplate().execute(new JpaCallback() {

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
                    return new BigDecimal(q.getResultList().size());
                } finally {
                    em.close();
                }
            }
        });
    }

    /**
     * 传入SQL语句或者存储过程调用字串，传入对应的参数，返回多个列的结果集。<br/>
     * <br/>
     * 说明：<br/>
     * <ol>
     * <li>如果传入的参数t不为null，则执行查询的返回结果List中每一个元素是代表查询结果中一行的一个Object数组。<br/>
     * 通过遍历数组可以得到该行各个列的值。</li>
     * <li>如果希望使用某个pojo类或者实体类来映射查询结果，则可以将他们的CLASS类型对象传入其中。<br/>
     * 注意传入的pojo类或者实体类的各个字段应该符合查询结果中的列名称。
     * </li>
     * </ol><br/><br/>
     * 适用的具体情况：
     * <ol>
     *  <li>执行单一的SQL查询语句（），返回多个列的结果集。</li>
     * <li>执行存储过程，返回多个列的结果集。例如执行存储过程a()，则传入如下字符串：{call a()}。<br/>
     *   对于有参数的存储过程b(c int,b int)可以传入{call b(?,?)},然后在Map中按顺序传入参数</li>
     * </ol>
     * @param <T> 可以是任意实体类或者简单的POJO类。用来映射多列或者全部列的查询结果。
     * @param t 实体类或者POJO类的CLASS类型对象。
     * @param sql SQL语句或者存储过程调用字串
     * @param params 查询参数Map
     * @param all 是否查询所有结果，如传入false，则后面两个参数firstResult和maxResults无效。
     * @param firstResult 用于分页查询。第一条记录的起始位置。设置为-1则表示无效
     * @param maxResults 用于分页查询。单页最大条数。设置为-1则表示无效
     * @return
     */
    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public <T extends Object> List executeNativeQuery(final Class<T> t,final String sql,final Map<Integer,? extends Object> params,final boolean all, final int firstResult, final int maxResults){
        return getJpaTemplate().executeFind(new JpaCallback() {

            public Object doInJpa(EntityManager em) throws PersistenceException {
                try{
                    if(sql==null||sql.length()<=0){
                        return null;
                    }
                    Query q = em.createNativeQuery(sql);
                    if(t!=null){
                        q = em.createNativeQuery(sql, t);
                    }
                    if (params != null && params.size() > 0) {
                        for (Integer idx : params.keySet()) {
                            q.setParameter(idx.intValue(), params.get(idx));
                        }
                    }
                    if(!all){
                        q.setFirstResult(firstResult);
                        q.setMaxResults(maxResults);
                    }
                    return q.getResultList();
                }finally{
                    em.close();
                }
            }
        });
    }

    /**
     * 执行SQL语句，返回数值型查询结果。<br/>
     * 适用情况：<br/>
     * <ol>
     * <li>执行一条SQL查询语句，返回一个数值型的查询语句。例如:select count(*) from tables; select max(s.score) from score s;</li>
     * <li>执行一个存储过程，返回数值型的查询结果。</li>
     * </ol>
     * @param sql 传入的SQL语句
     * @param params 参数Map
     * @return
     */
    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public BigDecimal getCountByNativeQuery(final String sql,final Map<Integer,? extends Object> params){
        return (BigDecimal)getJpaTemplate().execute(new JpaCallback() {

            public Object doInJpa(EntityManager em) throws PersistenceException {
                if(sql==null||sql.length()<=0){
                    return 0L;
                }
                Query q = em.createNativeQuery(sql);
                if (params != null && params.size() > 0) {
                    for (Integer idx : params.keySet()) {
                        q.setParameter(idx.intValue(), params.get(idx));
                    }
                }
                return new BigDecimal(q.getSingleResult().toString());
            }
        });
    }

    /**
     * 传入sql语句和params参数Map，执行更新，更新的行数。
     * <br/>
     * 适用的具体情况：
     * <ol>
     *  <li>执行单一的SQL更新语句（增删改），返回更新行数。</li>
     * <li>执行存储过程，返回更新行数。例如执行存储过程a()，则传入如下字符串：{call a()}。<br/>
     *   对于有参数的存储过程b(c int,b int)可以传入{call b(?,?)},然后在Map中按顺序传入参数</li>
     * </ol>
     * 注意：由于存储过程返回的更新记录数往往只是最后一条语句执行所影响的条数，故不推荐通过此方法执行存储过程。
     * @param sql 传入的SQL语句
     * @param params 参数Map
     * @return
     */
    public int executeNativeUpdate(final String sql,final Map<Integer,? extends Object> params){
        return (Integer)getJpaTemplate().execute(new JpaCallback() {

            public Object doInJpa(EntityManager em) throws PersistenceException {
                if(sql==null||sql.length()<=0){
                    return 0;
                }
                Query q = em.createNativeQuery(sql);
                if (params != null && params.size() > 0) {
                    for (Integer idx : params.keySet()) {
                        q.setParameter(idx.intValue(), params.get(idx));
                    }
                }
                return q.executeUpdate();
            }
        });
    }

    /**
     * 传入sql语句和params参数Map，返回单列值的结果。<br/>
     * 由于返回值是Object，所以可以根据具体的返回值类型来进行适当的类型转换<br/>
     * 适用的具体情况：<br/>
     * <ol>
     * <li>执行单一的SQL语句，返回单列值。例如: select count(*) from tables; select s.name from student s;</li>
     * <li>执行存储过程，返回单一记录。例如执行存储过程a()，则传入如下字符串：{call a()}</li>
     * </ol>
     * @param sql 传入的SQL语句
     * @param params 参数Map
     * @return
     */
    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public Object getNativeSingleResult(final String sql,final Map<Integer,? extends Object> params){
        return getJpaTemplate().execute(new JpaCallback() {

            public Object doInJpa(EntityManager em) throws PersistenceException {
                if(sql==null||sql.length()<=0){
                    return 0L;
                }
                Query q = em.createNativeQuery(sql);
                if (params != null && params.size() > 0) {
                    for (Integer idx : params.keySet()) {
                        q.setParameter(idx.intValue(), params.get(idx));
                    }
                }
                return q.getSingleResult();
            }
        });
    }
}
