/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vv.auth.persist.service.controller;

import com.vv.auth.persist.entity.TGroup;
import com.vv.auth.persist.service.controller.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import com.vv.auth.persist.entity.TRight;
import java.util.ArrayList;
import java.util.Collection;
import com.vv.auth.persist.entity.Vcustomer;

/**
 *
 * @author X-Spirit
 */
public class TGroupJpaController {

    public TGroupJpaController() {
        emf = Persistence.createEntityManagerFactory("AuthencationOAPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TGroup TGroup) {
        if (TGroup.getTRightCollection() == null) {
            TGroup.setTRightCollection(new ArrayList<TRight>());
        }
        if (TGroup.getVcustomerCollection() == null) {
            TGroup.setVcustomerCollection(new ArrayList<Vcustomer>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<TRight> attachedTRightCollection = new ArrayList<TRight>();
            for (TRight TRightCollectionTRightToAttach : TGroup.getTRightCollection()) {
                TRightCollectionTRightToAttach = em.getReference(TRightCollectionTRightToAttach.getClass(), TRightCollectionTRightToAttach.getTrId());
                attachedTRightCollection.add(TRightCollectionTRightToAttach);
            }
            TGroup.setTRightCollection(attachedTRightCollection);
            Collection<Vcustomer> attachedVcustomerCollection = new ArrayList<Vcustomer>();
            for (Vcustomer vcustomerCollectionVcustomerToAttach : TGroup.getVcustomerCollection()) {
                vcustomerCollectionVcustomerToAttach = em.getReference(vcustomerCollectionVcustomerToAttach.getClass(), vcustomerCollectionVcustomerToAttach.getUserid());
                attachedVcustomerCollection.add(vcustomerCollectionVcustomerToAttach);
            }
            TGroup.setVcustomerCollection(attachedVcustomerCollection);
            em.persist(TGroup);
            for (TRight TRightCollectionTRight : TGroup.getTRightCollection()) {
                TRightCollectionTRight.getTGroupCollection().add(TGroup);
                TRightCollectionTRight = em.merge(TRightCollectionTRight);
            }
            for (Vcustomer vcustomerCollectionVcustomer : TGroup.getVcustomerCollection()) {
                vcustomerCollectionVcustomer.getTGroupCollection().add(TGroup);
                vcustomerCollectionVcustomer = em.merge(vcustomerCollectionVcustomer);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TGroup TGroup) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TGroup persistentTGroup = em.find(TGroup.class, TGroup.getTgId());
            Collection<TRight> TRightCollectionOld = persistentTGroup.getTRightCollection();
            Collection<TRight> TRightCollectionNew = TGroup.getTRightCollection();
            Collection<Vcustomer> vcustomerCollectionOld = persistentTGroup.getVcustomerCollection();
            Collection<Vcustomer> vcustomerCollectionNew = TGroup.getVcustomerCollection();
            Collection<TRight> attachedTRightCollectionNew = new ArrayList<TRight>();
            for (TRight TRightCollectionNewTRightToAttach : TRightCollectionNew) {
                TRightCollectionNewTRightToAttach = em.getReference(TRightCollectionNewTRightToAttach.getClass(), TRightCollectionNewTRightToAttach.getTrId());
                attachedTRightCollectionNew.add(TRightCollectionNewTRightToAttach);
            }
            TRightCollectionNew = attachedTRightCollectionNew;
            TGroup.setTRightCollection(TRightCollectionNew);
            Collection<Vcustomer> attachedVcustomerCollectionNew = new ArrayList<Vcustomer>();
            for (Vcustomer vcustomerCollectionNewVcustomerToAttach : vcustomerCollectionNew) {
                vcustomerCollectionNewVcustomerToAttach = em.getReference(vcustomerCollectionNewVcustomerToAttach.getClass(), vcustomerCollectionNewVcustomerToAttach.getUserid());
                attachedVcustomerCollectionNew.add(vcustomerCollectionNewVcustomerToAttach);
            }
            vcustomerCollectionNew = attachedVcustomerCollectionNew;
            TGroup.setVcustomerCollection(vcustomerCollectionNew);
            TGroup = em.merge(TGroup);
            for (TRight TRightCollectionOldTRight : TRightCollectionOld) {
                if (!TRightCollectionNew.contains(TRightCollectionOldTRight)) {
                    TRightCollectionOldTRight.getTGroupCollection().remove(TGroup);
                    TRightCollectionOldTRight = em.merge(TRightCollectionOldTRight);
                }
            }
            for (TRight TRightCollectionNewTRight : TRightCollectionNew) {
                if (!TRightCollectionOld.contains(TRightCollectionNewTRight)) {
                    TRightCollectionNewTRight.getTGroupCollection().add(TGroup);
                    TRightCollectionNewTRight = em.merge(TRightCollectionNewTRight);
                }
            }
            for (Vcustomer vcustomerCollectionOldVcustomer : vcustomerCollectionOld) {
                if (!vcustomerCollectionNew.contains(vcustomerCollectionOldVcustomer)) {
                    vcustomerCollectionOldVcustomer.getTGroupCollection().remove(TGroup);
                    vcustomerCollectionOldVcustomer = em.merge(vcustomerCollectionOldVcustomer);
                }
            }
            for (Vcustomer vcustomerCollectionNewVcustomer : vcustomerCollectionNew) {
                if (!vcustomerCollectionOld.contains(vcustomerCollectionNewVcustomer)) {
                    vcustomerCollectionNewVcustomer.getTGroupCollection().add(TGroup);
                    vcustomerCollectionNewVcustomer = em.merge(vcustomerCollectionNewVcustomer);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = TGroup.getTgId();
                if (findTGroup(id) == null) {
                    throw new NonexistentEntityException("The tGroup with id " + id + " no longer exists.");
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
            TGroup TGroup;
            try {
                TGroup = em.getReference(TGroup.class, id);
                TGroup.getTgId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The TGroup with id " + id + " no longer exists.", enfe);
            }
            Collection<TRight> TRightCollection = TGroup.getTRightCollection();
            for (TRight TRightCollectionTRight : TRightCollection) {
                TRightCollectionTRight.getTGroupCollection().remove(TGroup);
                TRightCollectionTRight = em.merge(TRightCollectionTRight);
            }
            Collection<Vcustomer> vcustomerCollection = TGroup.getVcustomerCollection();
            for (Vcustomer vcustomerCollectionVcustomer : vcustomerCollection) {
                vcustomerCollectionVcustomer.getTGroupCollection().remove(TGroup);
                vcustomerCollectionVcustomer = em.merge(vcustomerCollectionVcustomer);
            }
            em.remove(TGroup);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TGroup> findTGroupEntities() {
        return findTGroupEntities(true, -1, -1);
    }

    public List<TGroup> findTGroupEntities(int maxResults, int firstResult) {
        return findTGroupEntities(false, maxResults, firstResult);
    }

    private List<TGroup> findTGroupEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select object(o) from TGroup as o");
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public TGroup findTGroup(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TGroup.class, id);
        } finally {
            em.close();
        }
    }

    public int getTGroupCount() {
        EntityManager em = getEntityManager();
        try {
            return ((Long) em.createQuery("select count(o) from TGroup as o").getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
}
