package com.example.pl_san_pham.repository;

import com.example.pl_san_pham.model.Product;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;

@Service
public class ProductRepository implements IProductRepository {

    private static SessionFactory sessionFactory;
    private static EntityManager entityManager;

    static {
        try {
            sessionFactory = new Configuration()
                    .configure("hibernate.conf.xml")
                    .buildSessionFactory();
            entityManager = sessionFactory.createEntityManager();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Product> getAllProducts() {
        Session session = sessionFactory.openSession();
        List<Product> products = session.createQuery("FROM Product", Product.class).getResultList();
        session.close();
        return products;
    }


    @Override
    public void addProduct(Product product) {
        Transaction tx = null;
        try (Session session = sessionFactory.openSession()) {
            tx = session.beginTransaction();
            session.save(product); // thêm mới luôn
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            System.out.println("Error when addProduct: " + e.getMessage());
        }
    }

    @Override

    public void deleteProduct(int id) {
        Product orgin = getProduct(id);
        if (orgin != null) {
            Transaction tx = null;
            try {
                Session session = sessionFactory.openSession();
                session.beginTransaction();
                session.delete(orgin);
                session.getTransaction().commit();
                session.close();
            } catch (Exception e) {
                System.out.println("Error when deleteProduct: " + e.getMessage());
                if (tx != null) {
                    tx.rollback();
                }
            }
        }
    }

    @Override
    public void updateProduct(int id, Product updatedProduct) {
        Transaction tx = null;
        try {
            Session session = sessionFactory.openSession();
            Product orgin = getProduct(id);
            if (orgin != null) {
                session.beginTransaction();
                orgin.setName(updatedProduct.getName());
                orgin.setPrice(updatedProduct.getPrice());
                orgin.setQuantity(updatedProduct.getQuantity());
                session.update(orgin);
                session.getTransaction().commit();
            }
            session.close();
        } catch (Exception e) {
            System.out.println("Error when updateProduct: " + e.getMessage());
            if (tx != null) {
                tx.rollback();
            }
        }
    }
    @Override
    public Product getProduct(int id) {
        String queryStr = "select p from Product as p where p.id = :id";
        TypedQuery<Product> query = entityManager.createQuery(queryStr, Product.class);
        query.setParameter("id", id);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

}