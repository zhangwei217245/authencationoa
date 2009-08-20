/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vv.auth.persist.service;

import com.vv.auth.persist.entity.Certificatereg;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.vv.auth.persist.service.exceptions.PreexistingEntityException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import org.springframework.orm.jpa.JpaCallback;
import org.springframework.orm.jpa.support.JpaDaoSupport;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author hp
 */
@Transactional
public class CertificateregService extends JpaDaoSupport implements ICertificateregService {

    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public List<Certificatereg> findCertificateregByNameAndLocation(String name, String location) {
        Map params = new HashMap();
        params.put("name", name);
        params.put("location", location);
        return getJpaTemplate().findByNamedQueryAndNamedParams("Certificatereg.findByNameAndLocation", params);
    }

    public void deleteCertificate(Integer id) {
        getJpaTemplate().remove(getJpaTemplate().find(Certificatereg.class, id));
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public List<Certificatereg> findCertificateRegExpire() {
        return getJpaTemplate().findByNamedQuery("Certificatereg.findRegExpired");
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public List<Certificatereg> findCertificateRegNotExpire() {
        return getJpaTemplate().findByNamedQuery("Certificatereg.findRegNotExpired");
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public List<Certificatereg> findCertificateregByName(String name) {
        Map params = new HashMap();
        params.put("name", name);
        return getJpaTemplate().findByNamedQueryAndNamedParams("Certificatereg.findByName", params);
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public List<Certificatereg> searchCertificateregs(final String jpql, final Map params) {
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

    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public Certificatereg findByCertificateregId(Integer id) {
        return getJpaTemplate().find(Certificatereg.class, id);
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public List<Certificatereg> findCertificateregs() {
        return getJpaTemplate().findByNamedQuery("Certificatereg.findAll");
    }

    public void saveCertificatereg(Certificatereg cr) throws PreexistingEntityException {
        if (findCertificateregByNameAndLocation(cr.getName(), cr.getLocation()).size() > 0) {
            throw new PreexistingEntityException("Such right already exists in your database");
        } else {
            getJpaTemplate().persist(cr);
        }
    }
}
