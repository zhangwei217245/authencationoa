/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vv.auth.persist.service;

import com.vv.auth.persist.entity.Rcustomer;
import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author hp
 */
public interface IRcustomerService {

    void deleteRegCustomer(Integer id);

    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    Rcustomer findRcustomerById(Integer id);

    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    List<Rcustomer> findRcustomers();

    void saveRegCustomer(Rcustomer rc);
}
