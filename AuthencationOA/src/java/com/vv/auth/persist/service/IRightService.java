/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vv.auth.persist.service;

import com.vv.auth.persist.entity.TRight;
import com.vv.auth.persist.service.exceptions.PreexistingEntityException;
import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author X-Spirit
 */
public interface IRightService {

    void deleteRight(Integer rightid);

    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    TRight findRightById(Integer id);

    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    List<TRight> findRightByName(String rightName);

    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    List<TRight> findRightByType(String rightType);

    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    List<TRight> findRightByTypeAndPath(String rightType, String rightPath);

    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    List<TRight> queryRightList();

    void saveRight(TRight right) throws PreexistingEntityException;

    TRight updateRight(TRight right);
}
