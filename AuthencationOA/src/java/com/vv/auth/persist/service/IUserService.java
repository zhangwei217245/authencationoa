/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vv.auth.persist.service;

import com.vv.auth.persist.entity.Vcustomer;
import com.vv.auth.persist.service.exceptions.PreexistingEntityException;
import java.util.List;
import java.util.Map;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author hp
 */
public interface IUserService {

    void deleteUser(Integer userid);

    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    Vcustomer findUserById(Integer id);

    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    List<Vcustomer> findUserByName(String name);

    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    List<Vcustomer> findUserExpired();

    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    List<Vcustomer> findUserNotExpired();

    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    List<Vcustomer> queryUserList();

    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public List<Vcustomer> searchVcustomer(final String jpql, final Map params);

    void saveUser(Vcustomer user) throws PreexistingEntityException;

    Vcustomer updateUser(Vcustomer user);
}
