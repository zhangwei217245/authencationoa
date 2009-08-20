/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vv.auth.persist.service;

import com.vv.auth.persist.entity.TGroup;
import com.vv.auth.persist.entity.TRight;
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
public class TrightService extends JpaDaoSupport implements IRightService {

    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public List<TRight> queryRightList() {
        return getJpaTemplate().findByNamedQuery("TRight.findAll");
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public TRight findRightById(Integer id) {
        return getJpaTemplate().find(TRight.class, id);
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public List<TRight> findRightByName(String rightName) {
        Map param = new HashMap();
        param.put("rightName", rightName);
        return getJpaTemplate().findByNamedQueryAndNamedParams("TRight.findByRightName", param);
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public List<TRight> findRightByType(String rightType) {
        Map param = new HashMap();
        param.put("rightType", rightType);
        return getJpaTemplate().findByNamedQueryAndNamedParams("TRight.findByRightType", param);
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public List<TRight> findRightByTypeAndPath(String rightType, String rightPath) {
        Map param = new HashMap();
        param.put("rightType", rightType);
        param.put("rightPath", rightPath);
        return getJpaTemplate().findByNamedQueryAndNamedParams("TRight.findByRightTypeAndRightPath", param);
    }

    public void saveRight(TRight right) throws PreexistingEntityException {
        if (findRightByTypeAndPath(right.getRightType(), right.getRightPath()).size() > 0) {
            throw new PreexistingEntityException("Such right already exists in your database");
        } else {
            Map params = new HashMap();
            params.put("groupName", "SuperAdmin");
            List<TGroup> grouplist = getJpaTemplate().findByNamedQueryAndNamedParams("TGroup.findByGroupName", params);
            if (grouplist.size() > 0) {
                TGroup group = grouplist.get(0);
                group.getTRightCollection().add(right);
                System.out.println("!@#!@$@#%$!@$@#!@#$@#%" + grouplist.get(0).getGroupName());
                right.getTGroupCollection().add(group);
            }

            getJpaTemplate().persist(right);
        }

    }

    public TRight updateRight(TRight right) {
        return getJpaTemplate().merge(right);
    }

    public void deleteRight(Integer rightid) {
        getJpaTemplate().remove(findRightById(rightid));
    }
}
