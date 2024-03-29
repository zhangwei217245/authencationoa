/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vv.auth.persist.service;

import java.util.List;
import java.util.Map;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author x-spirit
 */
public interface IJpaDaoService {

    <T extends Object> void create(T entity);

    <T extends Object> void destroy(Class<T> t, Integer id);

    <T extends Object> void destroy(Class<T> t, String id);

    <T extends Object> T edit(T entity);

    int executeUpdate(final String jpql, final Map<String, ? extends Object> params);

    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    List findByNamedQueryAndNamedParams(String queryName, Map<String, ? extends Object> params);

    @Deprecated
    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    List findByNamedQueryAndNamedParams(final String queryName, final Map<String, ? extends Object> params, final boolean all, final int firstResult, final int maxResults);

    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    List findEntities(final String jpql, final Map<String, ? extends Object> params, final boolean all, final int firstResult, final int maxResults);

    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    <T extends Object> T findOneEntityById(Class<T> t, Integer id);

    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    <T extends Object> T findOneEntityById(Class<T> t, String id);

    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    Integer getEntityCount(final String jpql, final Map<String, ? extends Object> params);

    @Deprecated
    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    Integer getNamedQueryEntityCount(final String queryName, final Map<String, ? extends Object> params);

}
