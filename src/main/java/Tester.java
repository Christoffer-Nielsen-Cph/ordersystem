import entities.Customer;
import entities.Product;
import facades.OrderFacade;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Tester {

    private static OrderFacade orderFacade;

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        orderFacade = OrderFacade.getInstance(emf);

        List<Customer> customerList = orderFacade.getAllCustomers();
        for (Customer customer : customerList) {
            System.out.println(customer.toString());
        }

        Product product = orderFacade.findProduct(1);
        System.out.println(product.toString());



        emf.close();

    }
}
