/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vv.auth.persist.service;

import com.vv.auth.persist.entity.TGroup;
import com.vv.auth.persist.service.exceptions.PreexistingEntityException;
import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author X-Spirit
 */
public interface IGroupService {

    void deleteGroup(Integer groupid);

    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    List<TGroup> findGroupByDesc(String tgDesc);

    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    TGroup findGroupById(Integer id);

    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    List<TGroup> findGroupByName(String groupName);

    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    List<TGroup> queryGroupList();

    void saveGroup(TGroup group) throws PreexistingEntityException;

    TGroup updateGroup(TGroup group);
}
