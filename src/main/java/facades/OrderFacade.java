package facades;

import entities.Customer;
import entities.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Set;

public class OrderFacade {
    private static OrderFacade instance;
    private static EntityManagerFactory emf;

    public OrderFacade() {
    }

    public static OrderFacade getInstance(EntityManagerFactory _emf){
        if(instance == null){
            emf = _emf;
            instance = new OrderFacade();
        }
        return instance;
    }

    public Customer createCustomer(String name, String email){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Customer customer = new Customer(name,email);
        em.persist(customer);
        em.getTransaction().commit();
        em.close();
        return customer;

    }
    public Customer findCustomer(long customerId){
        EntityManager em = emf.createEntityManager();
        Customer customer = em.find(Customer.class,customerId);
        return customer;
    }

    public List<Customer> getAllCustomers(){
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Customer> q1 = em.createQuery("SELECT c from Customer c", Customer.class);
            return q1.getResultList();
        }finally {
            em.close();
        }
    }

    public Product createProduct(String name, String description, long price){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Product product = new Product(name,description,price);
        em.persist(product);
        em.getTransaction().commit();
        em.close();
        return product;
    }

    public Product findProduct(long productId){
        EntityManager em = emf.createEntityManager();
        Product product = em.find(Product.class,productId);
        return product;
    }

    public void createOrder(){

    }


}
