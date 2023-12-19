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
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import logica.Vendedor;
import logica.Producto;
import java.util.ArrayList;
import java.util.List;
import logica.DetallesVenta;

/**
 *
 * @author 3714N
 */
public class DetallesVentaJpaController implements Serializable {

    public DetallesVentaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(DetallesVenta detallesVenta) {
        if (detallesVenta.getProducto() == null) {
            detallesVenta.setProducto(new ArrayList<Producto>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Vendedor vend = detallesVenta.getVend();
            if (vend != null) {
                vend = em.getReference(vend.getClass(), vend.getIdVendedor());
                detallesVenta.setVend(vend);
            }
            List<Producto> attachedProducto = new ArrayList<Producto>();
            for (Producto productoProductoToAttach : detallesVenta.getProducto()) {
                productoProductoToAttach = em.getReference(productoProductoToAttach.getClass(), productoProductoToAttach.getIdProducto());
                attachedProducto.add(productoProductoToAttach);
            }
            detallesVenta.setProducto(attachedProducto);
            em.persist(detallesVenta);
            if (vend != null) {
                vend.getDetallesVeta().add(detallesVenta);
                vend = em.merge(vend);
            }
            for (Producto productoProducto : detallesVenta.getProducto()) {
                productoProducto.getDetallesVentas().add(detallesVenta);
                productoProducto = em.merge(productoProducto);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(DetallesVenta detallesVenta) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            DetallesVenta persistentDetallesVenta = em.find(DetallesVenta.class, detallesVenta.getIdDetallesVenta());
            Vendedor vendOld = persistentDetallesVenta.getVend();
            Vendedor vendNew = detallesVenta.getVend();
            List<Producto> productoOld = persistentDetallesVenta.getProducto();
            List<Producto> productoNew = detallesVenta.getProducto();
            if (vendNew != null) {
                vendNew = em.getReference(vendNew.getClass(), vendNew.getIdVendedor());
                detallesVenta.setVend(vendNew);
            }
            List<Producto> attachedProductoNew = new ArrayList<Producto>();
            for (Producto productoNewProductoToAttach : productoNew) {
                productoNewProductoToAttach = em.getReference(productoNewProductoToAttach.getClass(), productoNewProductoToAttach.getIdProducto());
                attachedProductoNew.add(productoNewProductoToAttach);
            }
            productoNew = attachedProductoNew;
            detallesVenta.setProducto(productoNew);
            detallesVenta = em.merge(detallesVenta);
            if (vendOld != null && !vendOld.equals(vendNew)) {
                vendOld.getDetallesVeta().remove(detallesVenta);
                vendOld = em.merge(vendOld);
            }
            if (vendNew != null && !vendNew.equals(vendOld)) {
                vendNew.getDetallesVeta().add(detallesVenta);
                vendNew = em.merge(vendNew);
            }
            for (Producto productoOldProducto : productoOld) {
                if (!productoNew.contains(productoOldProducto)) {
                    productoOldProducto.getDetallesVentas().remove(detallesVenta);
                    productoOldProducto = em.merge(productoOldProducto);
                }
            }
            for (Producto productoNewProducto : productoNew) {
                if (!productoOld.contains(productoNewProducto)) {
                    productoNewProducto.getDetallesVentas().add(detallesVenta);
                    productoNewProducto = em.merge(productoNewProducto);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = detallesVenta.getIdDetallesVenta();
                if (findDetallesVenta(id) == null) {
                    throw new NonexistentEntityException("The detallesVenta with id " + id + " no longer exists.");
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
            DetallesVenta detallesVenta;
            try {
                detallesVenta = em.getReference(DetallesVenta.class, id);
                detallesVenta.getIdDetallesVenta();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The detallesVenta with id " + id + " no longer exists.", enfe);
            }
            Vendedor vend = detallesVenta.getVend();
            if (vend != null) {
                vend.getDetallesVeta().remove(detallesVenta);
                vend = em.merge(vend);
            }
            List<Producto> producto = detallesVenta.getProducto();
            for (Producto productoProducto : producto) {
                productoProducto.getDetallesVentas().remove(detallesVenta);
                productoProducto = em.merge(productoProducto);
            }
            em.remove(detallesVenta);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<DetallesVenta> findDetallesVentaEntities() {
        return findDetallesVentaEntities(true, -1, -1);
    }

    public List<DetallesVenta> findDetallesVentaEntities(int maxResults, int firstResult) {
        return findDetallesVentaEntities(false, maxResults, firstResult);
    }

    private List<DetallesVenta> findDetallesVentaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(DetallesVenta.class));
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

    public DetallesVenta findDetallesVenta(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(DetallesVenta.class, id);
        } finally {
            em.close();
        }
    }

    public int getDetallesVentaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<DetallesVenta> rt = cq.from(DetallesVenta.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
