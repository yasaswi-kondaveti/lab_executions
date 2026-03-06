
package com.fsad;
import org.hibernate.*;

public class App {
public static void main(String[] args) {
Session s = HibernateUtil.getSessionFactory().openSession();
Transaction tx = s.beginTransaction();

Product p1 = new Product("Laptop","Electronics",60000,5);
Product p2 = new Product("Mouse","Electronics",500,20);

s.save(p1);
s.save(p2);

Product pr = s.get(Product.class,1);
System.out.println("Product: "+pr.getName());

pr.setPrice(55000);
s.update(pr);

s.delete(p2);

tx.commit();
s.close();
System.out.println("CRUD Done");
}
}
