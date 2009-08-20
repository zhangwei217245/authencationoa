/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vv.auth.persist.service;

import com.vv.auth.persist.entity.Rcustomer;
import java.util.List;
import org.springframework.orm.jpa.support.JpaDaoSupport;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author hp
 */
@Transactional
public class RcustomerService extends JpaDaoSupport implements IRcustomerService {

    public void saveRegCustomer(Rcustomer rc) {
        getJpaTemplate().persist(rc);
    }

    public void deleteRegCustomer(Integer id) {
        getJpaTemplate().remove(getJpaTemplate().find(Rcustomer.class, id));
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public List<Rcustomer> findRcustomers() {
        return getJpaTemplate().findByNamedQuery("Rcustomer.findAll");
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public Rcustomer findRcustomerById(Integer id) {
        return getJpaTemplate().find(Rcustomer.class, id);
    }
}
