/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vv.auth.persist.service;

import com.vv.auth.persist.entity.Documenttype;
import com.vv.auth.persist.entity.IEntity;
import java.util.List;
import java.util.Map;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Administrator
 */
public interface IEntityService {

    /**
     * 创建实体
     * @param entity
     */
    void create(IEntity entity);

    /**
     * 删除实体
     * @param id
     */
    void destroy(Integer id);

    /**
     * 删除实体
     * @param entiry
     */
    void destroy(String sid);

    /**
     * 更新实体
     * @param entity
     * @return
     */
    IEntity edit(IEntity entity);

    /**
     * Can be used when a delete statement or an update statement will be called.
     * @param jpql
     * @param params
     * @return
     */
    int executeUpdate(final String jpql, final Map params);

    /**
     * 使用命名查询和命名参数进行查询
     * @param queryName
     * @param params
     * @return
     */
    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    List<IEntity> findByNamedQueryAndNamedParams(String queryName, Map params);

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
    List<IEntity> findEntities(final String jpql, final Map params, final boolean all, final int firstResult, final int maxResults);

    /**
     * 使用实体ID查询实体
     * @param id
     * @return
     */
    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    IEntity findOneEntityById(Integer id);

    /**
     * 使用实体ID查询实体
     * @param id
     * @return
     */
    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    IEntity findOneEntityById(String id);

    /**
     * 查询实体个数，可以指定查询语句和查询参数
     * @param jpql
     * @param params
     * @return
     */
    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    int getEntityCount(final String jpql, final Map params);
}
