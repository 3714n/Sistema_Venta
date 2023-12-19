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
import logica.Producto;
import java.util.ArrayList;
import java.util.List;
import logica.Categoria;

/**
 *
 * @author 3714N
 */
public class CategoriaJpaController implements Serializable {

    public CategoriaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Categoria categoria) {
        if (categoria.getProducto() == null) {
            categoria.setProducto(new ArrayList<Producto>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Producto> attachedProducto = new ArrayList<Producto>();
            for (Producto productoProductoToAttach : categoria.getProducto()) {
                productoProductoToAttach = em.getReference(productoProductoToAttach.getClass(), productoProductoToAttach.getIdProducto());
                attachedProducto.add(productoProductoToAttach);
            }
            categoria.setProducto(attachedProducto);
            em.persist(categoria);
            for (Producto productoProducto : categoria.getProducto()) {
                Categoria oldProdOfProductoProducto = productoProducto.getProd();
                productoProducto.setProd(categoria);
                productoProducto = em.merge(productoProducto);
                if (oldProdOfProductoProducto != null) {
                    oldProdOfProductoProducto.getProducto().remove(productoProducto);
                    oldProdOfProductoProducto = em.merge(oldProdOfProductoProducto);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Categoria categoria) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Categoria persistentCategoria = em.find(Categoria.class, categoria.getIdCategoria());
            List<Producto> productoOld = persistentCategoria.getProducto();
            List<Producto> productoNew = categoria.getProducto();
            List<Producto> attachedProductoNew = new ArrayList<Producto>();
            for (Producto productoNewProductoToAttach : productoNew) {
                productoNewProductoToAttach = em.getReference(productoNewProductoToAttach.getClass(), productoNewProductoToAttach.getIdProducto());
                attachedProductoNew.add(productoNewProductoToAttach);
            }
            productoNew = attachedProductoNew;
            categoria.setProducto(productoNew);
            categoria = em.merge(categoria);
            for (Producto productoOldProducto : productoOld) {
                if (!productoNew.contains(productoOldProducto)) {
                    productoOldProducto.setProd(null);
                    productoOldProducto = em.merge(productoOldProducto);
                }
            }
            for (Producto productoNewProducto : productoNew) {
                if (!productoOld.contains(productoNewProducto)) {
                    Categoria oldProdOfProductoNewProducto = productoNewProducto.getProd();
                    productoNewProducto.setProd(categoria);
                    productoNewProducto = em.merge(productoNewProducto);
                    if (oldProdOfProductoNewProducto != null && !oldProdOfProductoNewProducto.equals(categoria)) {
                        oldProdOfProductoNewProducto.getProducto().remove(productoNewProducto);
                        oldProdOfProductoNewProducto = em.merge(oldProdOfProductoNewProducto);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = categoria.getIdCategoria();
                if (findCategoria(id) == null) {
                    throw new NonexistentEntityException("The categoria with id " + id + " no longer exists.");
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
            Categoria categoria;
            try {
                categoria = em.getReference(Categoria.class, id);
                categoria.getIdCategoria();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The categoria with id " + id + " no longer exists.", enfe);
            }
            List<Producto> producto = categoria.getProducto();
            for (Producto productoProducto : producto) {
                productoProducto.setProd(null);
                productoProducto = em.merge(productoProducto);
            }
            em.remove(categoria);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Categoria> findCategoriaEntities() {
        return findCategoriaEntities(true, -1, -1);
    }

    public List<Categoria> findCategoriaEntities(int maxResults, int firstResult) {
        return findCategoriaEntities(false, maxResults, firstResult);
    }

    private List<Categoria> findCategoriaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Categoria.class));
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

    public Categoria findCategoria(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Categoria.class, id);
        } finally {
            em.close();
        }
    }

    public int getCategoriaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Categoria> rt = cq.from(Categoria.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
