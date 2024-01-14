/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Persistencia.exceptions.NonexistentEntityException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import java.io.Serializable;
import jakarta.persistence.Query;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.Persistence;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import java.util.List;
import logica.CabeceraVenta;
import logica.Cliente;

/**
 *
 * @author 3714N
 */
public class CabeceraVentaJpaController implements Serializable {
    private EntityManagerFactory emf = null;
    public CabeceraVentaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
     public CabeceraVentaJpaController() {
        emf = Persistence.createEntityManagerFactory("sistemaVentaPu");
    }

    public void create(CabeceraVenta cabeceraVenta) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cliente cabecera = cabeceraVenta.getCabecera();
            if (cabecera != null) {
                cabecera = em.getReference(cabecera.getClass(), cabecera.getIdCliente());
                cabeceraVenta.setCabecera(cabecera);
            }
            em.persist(cabeceraVenta);
            if (cabecera != null) {
                cabecera.getCabeceraVenta().add(cabeceraVenta);
                cabecera = em.merge(cabecera);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(CabeceraVenta cabeceraVenta) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            CabeceraVenta persistentCabeceraVenta = em.find(CabeceraVenta.class, cabeceraVenta.getIdCabeceraVenta());
            Cliente cabeceraOld = persistentCabeceraVenta.getCabecera();
            Cliente cabeceraNew = cabeceraVenta.getCabecera();
            if (cabeceraNew != null) {
                cabeceraNew = em.getReference(cabeceraNew.getClass(), cabeceraNew.getIdCliente());
                cabeceraVenta.setCabecera(cabeceraNew);
            }
            cabeceraVenta = em.merge(cabeceraVenta);
            if (cabeceraOld != null && !cabeceraOld.equals(cabeceraNew)) {
                cabeceraOld.getCabeceraVenta().remove(cabeceraVenta);
                cabeceraOld = em.merge(cabeceraOld);
            }
            if (cabeceraNew != null && !cabeceraNew.equals(cabeceraOld)) {
                cabeceraNew.getCabeceraVenta().add(cabeceraVenta);
                cabeceraNew = em.merge(cabeceraNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = cabeceraVenta.getIdCabeceraVenta();
                if (findCabeceraVenta(id) == null) {
                    throw new NonexistentEntityException("The cabeceraVenta with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            CabeceraVenta cabeceraVenta;
            try {
                cabeceraVenta = em.getReference(CabeceraVenta.class, id);
                cabeceraVenta.getIdCabeceraVenta();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The cabeceraVenta with id " + id + " no longer exists.", enfe);
            }
            Cliente cabecera = cabeceraVenta.getCabecera();
            if (cabecera != null) {
                cabecera.getCabeceraVenta().remove(cabeceraVenta);
                cabecera = em.merge(cabecera);
            }
            em.remove(cabeceraVenta);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<CabeceraVenta> findCabeceraVentaEntities() {
        return findCabeceraVentaEntities(true, -1, -1);
    }

    public List<CabeceraVenta> findCabeceraVentaEntities(int maxResults, int firstResult) {
        return findCabeceraVentaEntities(false, maxResults, firstResult);
    }

    private List<CabeceraVenta> findCabeceraVentaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(CabeceraVenta.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public CabeceraVenta findCabeceraVenta(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(CabeceraVenta.class, id);
        } finally {
            em.close();
        }
    }

    public int getCabeceraVentaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<CabeceraVenta> rt = cq.from(CabeceraVenta.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
