/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vv.auth.persist.service.controller;

import com.vv.auth.persist.entity.TRight;
import com.vv.auth.persist.service.controller.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import com.vv.auth.persist.entity.TGroup;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author X-Spirit
 */
public class TRightJpaController {

    public TRightJpaController() {
        emf = Persistence.createEntityManagerFactory("AuthencationOAPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TRight TRight) {
        if (TRight.getTGroupCollection() == null) {
            TRight.setTGroupCollection(new HashSet<TGroup>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Set<TGroup> attachedTGroupCollection = new HashSet<TGroup>();
            for (TGroup TGroupCollectionTGroupToAttach : TRight.getTGroupCollection()) {
                TGroupCollectionTGroupToAttach = em.getReference(TGroupCollectionTGroupToAttach.getClass(), TGroupCollectionTGroupToAttach.getTgId());
                attachedTGroupCollection.add(TGroupCollectionTGroupToAttach);
            }
            TRight.setTGroupCollection(attachedTGroupCollection);
            em.persist(TRight);
            for (TGroup TGroupCollectionTGroup : TRight.getTGroupCollection()) {
                TGroupCollectionTGroup.getTRightCollection().add(TRight);
                TGroupCollectionTGroup = em.merge(TGroupCollectionTGroup);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TRight TRight) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TRight persistentTRight = em.find(TRight.class, TRight.getTrId());
            Set<TGroup> TGroupCollectionOld = persistentTRight.getTGroupCollection();
            Set<TGroup> TGroupCollectionNew = TRight.getTGroupCollection();
            Set<TGroup> attachedTGroupCollectionNew = new HashSet<TGroup>();
            for (TGroup TGroupCollectionNewTGroupToAttach : TGroupCollectionNew) {
                TGroupCollectionNewTGroupToAttach = em.getReference(TGroupCollectionNewTGroupToAttach.getClass(), TGroupCollectionNewTGroupToAttach.getTgId());
                attachedTGroupCollectionNew.add(TGroupCollectionNewTGroupToAttach);
            }
            TGroupCollectionNew = attachedTGroupCollectionNew;
            TRight.setTGroupCollection(TGroupCollectionNew);
            TRight = em.merge(TRight);
            for (TGroup TGroupCollectionOldTGroup : TGroupCollectionOld) {
                if (!TGroupCollectionNew.contains(TGroupCollectionOldTGroup)) {
                    TGroupCollectionOldTGroup.getTRightCollection().remove(TRight);
                    TGroupCollectionOldTGroup = em.merge(TGroupCollectionOldTGroup);
                }
            }
            for (TGroup TGroupCollectionNewTGroup : TGroupCollectionNew) {
                if (!TGroupCollectionOld.contains(TGroupCollectionNewTGroup)) {
                    TGroupCollectionNewTGroup.getTRightCollection().add(TRight);
                    TGroupCollectionNewTGroup = em.merge(TGroupCollectionNewTGroup);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = TRight.getTrId();
                if (findTRight(id) == null) {
                    throw new NonexistentEntityException("The tRight with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TRight TRight;
            try {
                TRight = em.getReference(TRight.class, id);
                TRight.getTrId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The TRight with id " + id + " no longer exists.", enfe);
            }
            Collection<TGroup> TGroupCollection = TRight.getTGroupCollection();
            for (TGroup TGroupCollectionTGroup : TGroupCollection) {
                TGroupCollectionTGroup.getTRightCollection().remove(TRight);
                TGroupCollectionTGroup = em.merge(TGroupCollectionTGroup);
            }
            em.remove(TRight);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TRight> findTRightEntities() {
        return findTRightEntities(true, -1, -1);
    }

    public List<TRight> findTRightEntities(int maxResults, int firstResult) {
        return findTRightEntities(false, maxResults, firstResult);
    }

    private List<TRight> findTRightEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select object(o) from TRight as o");
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public TRight findTRight(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TRight.class, id);
        } finally {
            em.close();
        }
    }

    public int getTRightCount() {
        EntityManager em = getEntityManager();
        try {
            return ((Long) em.createQuery("select count(o) from TRight as o").getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
}
