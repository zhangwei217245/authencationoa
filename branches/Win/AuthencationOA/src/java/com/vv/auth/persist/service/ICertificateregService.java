/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vv.auth.persist.service;

import com.vv.auth.persist.entity.Certificatereg;
import com.vv.auth.persist.service.exceptions.PreexistingEntityException;
import java.util.List;
import java.util.Map;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author hp
 */
public interface ICertificateregService {

    void deleteCertificate(Integer id);

    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    Certificatereg findByCertificateregId(Integer id);

    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    List<Certificatereg> findCertificateRegExpire();

    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    List<Certificatereg> findCertificateRegNotExpire();

    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    List<Certificatereg> findCertificateregByName(String name);

    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    List<Certificatereg> findCertificateregByNameAndLocation(String name, String location);

    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    List<Certificatereg> findCertificateregs();

    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    List<Certificatereg> searchCertificateregs(final String jpql, final Map params);

    void saveCertificatereg(Certificatereg cr) throws PreexistingEntityException;
}
