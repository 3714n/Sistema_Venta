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
import logica.Usuario;
import logica.DetallesVenta;
import java.util.ArrayList;
import java.util.List;
import logica.Vendedor;

/**
 *
 * @author 3714N
 */
public class VendedorJpaController implements Serializable {

    public VendedorJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
     public VendedorJpaController() {
        emf = Persistence.createEntityManagerFactory("sistemaVentaPu");
     }
    public void create(Vendedor vendedor) {
        if (vendedor.getDetallesVeta() == null) {
            vendedor.setDetallesVeta(new ArrayList<DetallesVenta>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Usuario usuario = vendedor.getUsuario();
            if (usuario != null) {
                usuario = em.getReference(usuario.getClass(), usuario.getIdUsuario());
                vendedor.setUsuario(usuario);
            }
            List<DetallesVenta> attachedDetallesVeta = new ArrayList<DetallesVenta>();
            for (DetallesVenta detallesVetaDetallesVentaToAttach : vendedor.getDetallesVeta()) {
                detallesVetaDetallesVentaToAttach = em.getReference(detallesVetaDetallesVentaToAttach.getClass(), detallesVetaDetallesVentaToAttach.getIdDetallesVenta());
                attachedDetallesVeta.add(detallesVetaDetallesVentaToAttach);
            }
            vendedor.setDetallesVeta(attachedDetallesVeta);
            em.persist(vendedor);
            if (usuario != null) {
                Vendedor oldVendedorOfUsuario = usuario.getVendedor();
                if (oldVendedorOfUsuario != null) {
                    oldVendedorOfUsuario.setUsuario(null);
                    oldVendedorOfUsuario = em.merge(oldVendedorOfUsuario);
                }
                usuario.setVendedor(vendedor);
                usuario = em.merge(usuario);
            }
            for (DetallesVenta detallesVetaDetallesVenta : vendedor.getDetallesVeta()) {
                Vendedor oldVendOfDetallesVetaDetallesVenta = detallesVetaDetallesVenta.getVend();
                detallesVetaDetallesVenta.setVend(vendedor);
                detallesVetaDetallesVenta = em.merge(detallesVetaDetallesVenta);
                if (oldVendOfDetallesVetaDetallesVenta != null) {
                    oldVendOfDetallesVetaDetallesVenta.getDetallesVeta().remove(detallesVetaDetallesVenta);
                    oldVendOfDetallesVetaDetallesVenta = em.merge(oldVendOfDetallesVetaDetallesVenta);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Vendedor vendedor) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Vendedor persistentVendedor = em.find(Vendedor.class, vendedor.getIdVendedor());
            Usuario usuarioOld = persistentVendedor.getUsuario();
            Usuario usuarioNew = vendedor.getUsuario();
            List<DetallesVenta> detallesVetaOld = persistentVendedor.getDetallesVeta();
            List<DetallesVenta> detallesVetaNew = vendedor.getDetallesVeta();
            if (usuarioNew != null) {
                usuarioNew = em.getReference(usuarioNew.getClass(), usuarioNew.getIdUsuario());
                vendedor.setUsuario(usuarioNew);
            }
            List<DetallesVenta> attachedDetallesVetaNew = new ArrayList<DetallesVenta>();
            for (DetallesVenta detallesVetaNewDetallesVentaToAttach : detallesVetaNew) {
                detallesVetaNewDetallesVentaToAttach = em.getReference(detallesVetaNewDetallesVentaToAttach.getClass(), detallesVetaNewDetallesVentaToAttach.getIdDetallesVenta());
                attachedDetallesVetaNew.add(detallesVetaNewDetallesVentaToAttach);
            }
            detallesVetaNew = attachedDetallesVetaNew;
            vendedor.setDetallesVeta(detallesVetaNew);
            vendedor = em.merge(vendedor);
            if (usuarioOld != null && !usuarioOld.equals(usuarioNew)) {
                usuarioOld.setVendedor(null);
                usuarioOld = em.merge(usuarioOld);
            }
            if (usuarioNew != null && !usuarioNew.equals(usuarioOld)) {
                Vendedor oldVendedorOfUsuario = usuarioNew.getVendedor();
                if (oldVendedorOfUsuario != null) {
                    oldVendedorOfUsuario.setUsuario(null);
                    oldVendedorOfUsuario = em.merge(oldVendedorOfUsuario);
                }
                usuarioNew.setVendedor(vendedor);
                usuarioNew = em.merge(usuarioNew);
            }
            for (DetallesVenta detallesVetaOldDetallesVenta : detallesVetaOld) {
                if (!detallesVetaNew.contains(detallesVetaOldDetallesVenta)) {
                    detallesVetaOldDetallesVenta.setVend(null);
                    detallesVetaOldDetallesVenta = em.merge(detallesVetaOldDetallesVenta);
                }
            }
            for (DetallesVenta detallesVetaNewDetallesVenta : detallesVetaNew) {
                if (!detallesVetaOld.contains(detallesVetaNewDetallesVenta)) {
                    Vendedor oldVendOfDetallesVetaNewDetallesVenta = detallesVetaNewDetallesVenta.getVend();
                    detallesVetaNewDetallesVenta.setVend(vendedor);
                    detallesVetaNewDetallesVenta = em.merge(detallesVetaNewDetallesVenta);
                    if (oldVendOfDetallesVetaNewDetallesVenta != null && !oldVendOfDetallesVetaNewDetallesVenta.equals(vendedor)) {
                        oldVendOfDetallesVetaNewDetallesVenta.getDetallesVeta().remove(detallesVetaNewDetallesVenta);
                        oldVendOfDetallesVetaNewDetallesVenta = em.merge(oldVendOfDetallesVetaNewDetallesVenta);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = vendedor.getIdVendedor();
                if (findVendedor(id) == null) {
                    throw new NonexistentEntityException("The vendedor with id " + id + " no longer exists.");
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
            Vendedor vendedor;
            try {
                vendedor = em.getReference(Vendedor.class, id);
                vendedor.getIdVendedor();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The vendedor with id " + id + " no longer exists.", enfe);
            }
            Usuario usuario = vendedor.getUsuario();
            if (usuario != null) {
                usuario.setVendedor(null);
                usuario = em.merge(usuario);
            }
            List<DetallesVenta> detallesVeta = vendedor.getDetallesVeta();
            for (DetallesVenta detallesVetaDetallesVenta : detallesVeta) {
                detallesVetaDetallesVenta.setVend(null);
                detallesVetaDetallesVenta = em.merge(detallesVetaDetallesVenta);
            }
            em.remove(vendedor);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Vendedor> findVendedorEntities() {
        return findVendedorEntities(true, -1, -1);
    }

    public List<Vendedor> findVendedorEntities(int maxResults, int firstResult) {
        return findVendedorEntities(false, maxResults, firstResult);
    }

    private List<Vendedor> findVendedorEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Vendedor.class));
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

    public Vendedor findVendedor(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Vendedor.class, id);
        } finally {
            em.close();
        }
    }

    public int getVendedorCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Vendedor> rt = cq.from(Vendedor.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
