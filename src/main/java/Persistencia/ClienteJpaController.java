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
import logica.CabeceraVenta;
import java.util.ArrayList;
import java.util.List;
import logica.Cliente;

/**
 *
 * @author 3714N
 */
public class ClienteJpaController implements Serializable {
    private EntityManagerFactory emf = null;
    public ClienteJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    public ClienteJpaController() {
        emf = Persistence.createEntityManagerFactory("sistemaVentaPu");
     }
    public void create(Cliente cliente) {
        if (cliente.getCabeceraVenta() == null) {
            cliente.setCabeceraVenta(new ArrayList<CabeceraVenta>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<CabeceraVenta> attachedCabeceraVenta = new ArrayList<CabeceraVenta>();
            for (CabeceraVenta cabeceraVentaCabeceraVentaToAttach : cliente.getCabeceraVenta()) {
                cabeceraVentaCabeceraVentaToAttach = em.getReference(cabeceraVentaCabeceraVentaToAttach.getClass(), cabeceraVentaCabeceraVentaToAttach.getIdCabeceraVenta());
                attachedCabeceraVenta.add(cabeceraVentaCabeceraVentaToAttach);
            }
            cliente.setCabeceraVenta(attachedCabeceraVenta);
            em.persist(cliente);
            for (CabeceraVenta cabeceraVentaCabeceraVenta : cliente.getCabeceraVenta()) {
                Cliente oldCabeceraOfCabeceraVentaCabeceraVenta = cabeceraVentaCabeceraVenta.getCabecera();
                cabeceraVentaCabeceraVenta.setCabecera(cliente);
                cabeceraVentaCabeceraVenta = em.merge(cabeceraVentaCabeceraVenta);
                if (oldCabeceraOfCabeceraVentaCabeceraVenta != null) {
                    oldCabeceraOfCabeceraVentaCabeceraVenta.getCabeceraVenta().remove(cabeceraVentaCabeceraVenta);
                    oldCabeceraOfCabeceraVentaCabeceraVenta = em.merge(oldCabeceraOfCabeceraVentaCabeceraVenta);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Cliente cliente) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cliente persistentCliente = em.find(Cliente.class, cliente.getIdCliente());
            List<CabeceraVenta> cabeceraVentaOld = persistentCliente.getCabeceraVenta();
            List<CabeceraVenta> cabeceraVentaNew = cliente.getCabeceraVenta();
            List<CabeceraVenta> attachedCabeceraVentaNew = new ArrayList<CabeceraVenta>();
            for (CabeceraVenta cabeceraVentaNewCabeceraVentaToAttach : cabeceraVentaNew) {
                cabeceraVentaNewCabeceraVentaToAttach = em.getReference(cabeceraVentaNewCabeceraVentaToAttach.getClass(), cabeceraVentaNewCabeceraVentaToAttach.getIdCabeceraVenta());
                attachedCabeceraVentaNew.add(cabeceraVentaNewCabeceraVentaToAttach);
            }
            cabeceraVentaNew = attachedCabeceraVentaNew;
            cliente.setCabeceraVenta(cabeceraVentaNew);
            cliente = em.merge(cliente);
            for (CabeceraVenta cabeceraVentaOldCabeceraVenta : cabeceraVentaOld) {
                if (!cabeceraVentaNew.contains(cabeceraVentaOldCabeceraVenta)) {
                    cabeceraVentaOldCabeceraVenta.setCabecera(null);
                    cabeceraVentaOldCabeceraVenta = em.merge(cabeceraVentaOldCabeceraVenta);
                }
            }
            for (CabeceraVenta cabeceraVentaNewCabeceraVenta : cabeceraVentaNew) {
                if (!cabeceraVentaOld.contains(cabeceraVentaNewCabeceraVenta)) {
                    Cliente oldCabeceraOfCabeceraVentaNewCabeceraVenta = cabeceraVentaNewCabeceraVenta.getCabecera();
                    cabeceraVentaNewCabeceraVenta.setCabecera(cliente);
                    cabeceraVentaNewCabeceraVenta = em.merge(cabeceraVentaNewCabeceraVenta);
                    if (oldCabeceraOfCabeceraVentaNewCabeceraVenta != null && !oldCabeceraOfCabeceraVentaNewCabeceraVenta.equals(cliente)) {
                        oldCabeceraOfCabeceraVentaNewCabeceraVenta.getCabeceraVenta().remove(cabeceraVentaNewCabeceraVenta);
                        oldCabeceraOfCabeceraVentaNewCabeceraVenta = em.merge(oldCabeceraOfCabeceraVentaNewCabeceraVenta);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = cliente.getIdCliente();
                if (findCliente(id) == null) {
                    throw new NonexistentEntityException("The cliente with id " + id + " no longer exists.");
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
            Cliente cliente;
            try {
                cliente = em.getReference(Cliente.class, id);
                cliente.getIdCliente();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The cliente with id " + id + " no longer exists.", enfe);
            }
            List<CabeceraVenta> cabeceraVenta = cliente.getCabeceraVenta();
            for (CabeceraVenta cabeceraVentaCabeceraVenta : cabeceraVenta) {
                cabeceraVentaCabeceraVenta.setCabecera(null);
                cabeceraVentaCabeceraVenta = em.merge(cabeceraVentaCabeceraVenta);
            }
            em.remove(cliente);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Cliente> findClienteEntities() {
        return findClienteEntities(true, -1, -1);
    }

    public List<Cliente> findClienteEntities(int maxResults, int firstResult) {
        return findClienteEntities(false, maxResults, firstResult);
    }

    private List<Cliente> findClienteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Cliente.class));
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

    public Cliente findCliente(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Cliente.class, id);
        } finally {
            em.close();
        }
    }

    public int getClienteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Cliente> rt = cq.from(Cliente.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
