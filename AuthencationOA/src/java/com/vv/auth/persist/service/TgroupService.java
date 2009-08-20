/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vv.auth.persist.service;

import com.vv.auth.persist.entity.TGroup;
import com.vv.auth.persist.service.exceptions.PreexistingEntityException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.orm.jpa.support.JpaDaoSupport;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author X-Spirit
 */
@Transactional
public class TgroupService extends JpaDaoSupport implements IGroupService {

    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public List<TGroup> queryGroupList() {
        return getJpaTemplate().findByNamedQuery("TGroup.findAll");
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public TGroup findGroupById(Integer id) {
        return getJpaTemplate().find(TGroup.class, id);
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public List<TGroup> findGroupByName(String groupName) {
        Map param = new HashMap();
        param.put("groupName", groupName);
        return getJpaTemplate().findByNamedQueryAndNamedParams("TGroup.findByGroupName", param);
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public List<TGroup> findGroupByDesc(String tgDesc) {
        Map param = new HashMap();
        param.put("tgDesc", tgDesc);
        return getJpaTemplate().findByNamedQueryAndNamedParams("TGroup.findByTgDesc", param);
    }

    public void saveGroup(TGroup group) throws PreexistingEntityException {
        if (findGroupByName(group.getGroupName()).size() > 0 || findGroupByDesc(group.getTgDesc()).size() > 0) {
            throw new PreexistingEntityException("E-mail duplicated with existing user");
        } else {
            getJpaTemplate().persist(group);
        }

    }

    public TGroup updateGroup(TGroup group) {
        return getJpaTemplate().merge(group);
    }

    public void deleteGroup(Integer groupid) {
        getJpaTemplate().remove(findGroupById(groupid));
    }
}
