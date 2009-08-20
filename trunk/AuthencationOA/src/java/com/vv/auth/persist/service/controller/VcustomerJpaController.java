/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vv.auth.persist.service.controller;

import com.vv.auth.persist.entity.Vcustomer;
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

/**
 *
 * @author X-Spirit
 */
public class VcustomerJpaController {

    public VcustomerJpaController() {
        emf = Persistence.createEntityManagerFactory("AuthencationOAPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Vcustomer vcustomer) {
        if (vcustomer.getTGroupCollection() == null) {
            vcustomer.setTGroupCollection(new ArrayList<TGroup>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<TGroup> attachedTGroupCollection = new ArrayList<TGroup>();
            for (TGroup TGroupCollectionTGroupToAttach : vcustomer.getTGroupCollection()) {
                TGroupCollectionTGroupToAttach = em.getReference(TGroupCollectionTGroupToAttach.getClass(), TGroupCollectionTGroupToAttach.getTgId());
                attachedTGroupCollection.add(TGroupCollectionTGroupToAttach);
            }
            vcustomer.setTGroupCollection(attachedTGroupCollection);
            em.persist(vcustomer);
            for (TGroup TGroupCollectionTGroup : vcustomer.getTGroupCollection()) {
                TGroupCollectionTGroup.getVcustomerCollection().add(vcustomer);
                TGroupCollectionTGroup = em.merge(TGroupCollectionTGroup);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Vcustomer vcustomer) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Vcustomer persistentVcustomer = em.find(Vcustomer.class, vcustomer.getUserid());
            Collection<TGroup> TGroupCollectionOld = persistentVcustomer.getTGroupCollection();
            Collection<TGroup> TGroupCollectionNew = vcustomer.getTGroupCollection();
            Collection<TGroup> attachedTGroupCollectionNew = new ArrayList<TGroup>();
            for (TGroup TGroupCollectionNewTGroupToAttach : TGroupCollectionNew) {
                TGroupCollectionNewTGroupToAttach = em.getReference(TGroupCollectionNewTGroupToAttach.getClass(), TGroupCollectionNewTGroupToAttach.getTgId());
                attachedTGroupCollectionNew.add(TGroupCollectionNewTGroupToAttach);
            }
            TGroupCollectionNew = attachedTGroupCollectionNew;
            vcustomer.setTGroupCollection(TGroupCollectionNew);
            vcustomer = em.merge(vcustomer);
            for (TGroup TGroupCollectionOldTGroup : TGroupCollectionOld) {
                if (!TGroupCollectionNew.contains(TGroupCollectionOldTGroup)) {
                    TGroupCollectionOldTGroup.getVcustomerCollection().remove(vcustomer);
                    TGroupCollectionOldTGroup = em.merge(TGroupCollectionOldTGroup);
                }
            }
            for (TGroup TGroupCollectionNewTGroup : TGroupCollectionNew) {
                if (!TGroupCollectionOld.contains(TGroupCollectionNewTGroup)) {
                    TGroupCollectionNewTGroup.getVcustomerCollection().add(vcustomer);
                    TGroupCollectionNewTGroup = em.merge(TGroupCollectionNewTGroup);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = vcustomer.getUserid();
                if (findVcustomer(id) == null) {
                    throw new NonexistentEntityException("The vcustomer with id " + id + " no longer exists.");
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
            Vcustomer vcustomer;
            try {
                vcustomer = em.getReference(Vcustomer.class, id);
                vcustomer.getUserid();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The vcustomer with id " + id + " no longer exists.", enfe);
            }
            Collection<TGroup> TGroupCollection = vcustomer.getTGroupCollection();
            for (TGroup TGroupCollectionTGroup : TGroupCollection) {
                TGroupCollectionTGroup.getVcustomerCollection().remove(vcustomer);
                TGroupCollectionTGroup = em.merge(TGroupCollectionTGroup);
            }
            em.remove(vcustomer);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Vcustomer> findVcustomerEntities() {
        return findVcustomerEntities(true, -1, -1);
    }

    public List<Vcustomer> findVcustomerEntities(int maxResults, int firstResult) {
        return findVcustomerEntities(false, maxResults, firstResult);
    }

    private List<Vcustomer> findVcustomerEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select object(o) from Vcustomer as o");
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public List<Vcustomer> findVcustomerByName(String username) {
        EntityManager em = getEntityManager();
        try {

            Query query = em.createNamedQuery("Vcustomer.findByName");
            query.setParameter("name", username);
            List<Vcustomer> reslist = query.getResultList();
            return reslist;

        } finally {
            em.close();
        }
    }

    public Vcustomer findVcustomer(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Vcustomer.class, id);
        } finally {
            em.close();
        }
    }

    public int getVcustomerCount() {
        EntityManager em = getEntityManager();
        try {
            return ((Long) em.createQuery("select count(o) from Vcustomer as o").getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
}
