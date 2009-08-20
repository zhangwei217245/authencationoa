/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vv.auth.persist.service.controller;

import com.vv.auth.persist.entity.TUser;
import com.vv.auth.persist.service.controller.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;

/**
 *
 * @author X-Spirit
 */
public class TUserJpaController {

    public TUserJpaController() {
        emf = Persistence.createEntityManagerFactory("AuthencationOAPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TUser TUser) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(TUser);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TUser TUser) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TUser = em.merge(TUser);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = TUser.getTuId();
                if (findTUser(id) == null) {
                    throw new NonexistentEntityException("The tUser with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TUser TUser;
            try {
                TUser = em.getReference(TUser.class, id);
                TUser.getTuId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The TUser with id " + id + " no longer exists.", enfe);
            }
            em.remove(TUser);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TUser> findTUserEntities() {
        return findTUserEntities(true, -1, -1);
    }

    public List<TUser> findTUserEntities(int maxResults, int firstResult) {
        return findTUserEntities(false, maxResults, firstResult);
    }

    private List<TUser> findTUserEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select object(o) from TUser as o");
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public TUser findTUser(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TUser.class, id);
        } finally {
            em.close();
        }
    }

    public int getTUserCount() {
        EntityManager em = getEntityManager();
        try {
            return ((Long) em.createQuery("select count(o) from TUser as o").getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
}
