import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import java.util.List;

public class HQLExample {

    public static void main(String[] args) {

        SessionFactory factory =
        new Configuration().configure().addAnnotatedClass(Product.class).buildSessionFactory();

        Session session = factory.openSession();
        session.beginTransaction();

        // Insert additional products
        session.save(new Product("Laptop","Electronics",80000,10));
        session.save(new Product("Mouse","Electronics",500,50));
        session.save(new Product("Keyboard","Electronics",1000,30));
        session.save(new Product("Chair","Furniture",3500,15));
        session.save(new Product("Desk","Furniture",7000,8));
        session.save(new Product("Pen","Stationery",20,200));

        session.getTransaction().commit();

        session.beginTransaction();

        // 1. Sort by price ascending
        List<Product> asc =
        session.createQuery("from Product order by price asc", Product.class).list();

        // 2. Sort by price descending
        List<Product> desc =
        session.createQuery("from Product order by price desc", Product.class).list();

        // 3. Sort by quantity highest first
        List<Product> qty =
        session.createQuery("from Product order by quantity desc", Product.class).list();

        // 4. Pagination (first 3)
        Query<Product> q1 = session.createQuery("from Product", Product.class);
        q1.setFirstResult(0);
        q1.setMaxResults(3);
        List<Product> first3 = q1.list();

        // Next 3
        Query<Product> q2 = session.createQuery("from Product", Product.class);
        q2.setFirstResult(3);
        q2.setMaxResults(3);
        List<Product> next3 = q2.list();

        // Aggregate operations
        Long totalProducts =
        session.createQuery("select count(*) from Product", Long.class).uniqueResult();

        Long availableProducts =
        session.createQuery("select count(*) from Product where quantity>0", Long.class).uniqueResult();

        List<Object[]> grouped =
        session.createQuery("select description,count(*) from Product group by description").list();

        Object[] priceRange =
        (Object[]) session.createQuery("select min(price), max(price) from Product").uniqueResult();

        // WHERE clause
        List<Product> priceRangeProducts =
        session.createQuery("from Product where price between 500 and 10000", Product.class).list();

        // LIKE queries
        List<Product> startPattern =
        session.createQuery("from Product where name like 'L%'", Product.class).list();

        List<Product> endPattern =
        session.createQuery("from Product where name like '%p'", Product.class).list();

        List<Product> containPattern =
        session.createQuery("from Product where name like '%top%'", Product.class).list();

        List<Product> exactLength =
        session.createQuery("from Product where length(name)=5", Product.class).list();

        session.getTransaction().commit();

        session.close();
        factory.close();
    }
}