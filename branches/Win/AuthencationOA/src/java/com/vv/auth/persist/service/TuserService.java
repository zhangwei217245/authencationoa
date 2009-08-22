/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vv.auth.persist.service;

import com.vv.auth.persist.entity.TGroup;
import com.vv.auth.persist.entity.Vcustomer;
import com.vv.auth.persist.service.exceptions.PreexistingEntityException;
import java.util.Date;
import java.util.HashMap;
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
public class TuserService extends JpaDaoSupport implements IUserService {

    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public List<Vcustomer> queryUserList() {
        return getJpaTemplate().findByNamedQuery("Vcustomer.findAll");
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public Vcustomer findUserById(Integer id) {
        return getJpaTemplate().find(Vcustomer.class, id);
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public List<Vcustomer> findUserExpired() {
        return getJpaTemplate().findByNamedQuery("Vcustomer.findUserExpired");
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public List<Vcustomer> findUserNotExpired() {
        return getJpaTemplate().findByNamedQuery("Vcustomer.findUserNotExpired");
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public List<Vcustomer> findUserByName(String name) {
        Map param = new HashMap();
        param.put("name", name);
        return getJpaTemplate().findByNamedQueryAndNamedParams("Vcustomer.findByName", param);
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public List<Vcustomer> searchVcustomer(final String jpql, final Map params) {
        return getJpaTemplate().executeFind(new JpaCallback() {

            public Object doInJpa(EntityManager em) throws PersistenceException {
                Query q = em.createQuery(jpql);
                if (params != null && params.size() > 0) {
                    for (Object obj : params.keySet()) {
                        String str = (String) obj;
                        q.setParameter(str, params.get(str));
                    }
                }
                return q.getResultList();
            }
        });
    }

    public void saveUser(Vcustomer user) throws PreexistingEntityException {
        if (findUserByName(user.getName()).size() > 0) {
            throw new PreexistingEntityException("E-mail duplicated with existing user");
        } else {
            Map params = new HashMap();
            params.put("groupName", "Innocent");
            List<TGroup> groupList = getJpaTemplate().findByNamedQueryAndNamedParams("TGroup.findByGroupName", params);
            TGroup group = groupList.get(0);
            group.getVcustomerCollection().add(user);
            user.getTGroupCollection().add(group);
            user.setDdaybeg(new Date());
            getJpaTemplate().persist(user);
        }

    }

    public Vcustomer updateUser(Vcustomer user) {
        return getJpaTemplate().merge(user);
    }

    public void deleteUser(Integer userid) {
        getJpaTemplate().remove(findUserById(userid));
    }
}
