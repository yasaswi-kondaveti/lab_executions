import org.hibernate.Session;
import org.hibernate.Transaction;

public class MainApp {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        // INSERT
        Product p1 = new Product("Laptop", "Gaming Laptop", 80000, 10);
        Product p2 = new Product("Mouse", "Wireless Mouse", 500, 50);

        session.save(p1);
        session.save(p2);

        tx.commit();

        // RETRIEVE
        session.beginTransaction();
        Product product = session.get(Product.class, 1);
        System.out.println("Product Name: " + product.getName());
        session.getTransaction().commit();

        // UPDATE
        session.beginTransaction();
        product.setPrice(75000);
        session.update(product);
        session.getTransaction().commit();

        // DELETE
        session.beginTransaction();
        Product deleteProduct = session.get(Product.class, 2);
        session.delete(deleteProduct);
        session.getTransaction().commit();

        session.close();
    }
}