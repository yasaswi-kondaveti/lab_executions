
package com.fsad;
import org.hibernate.*;
import java.util.List;

public class HQLDemo {
public static void main(String[] args){
Session s = HibernateUtil.getSessionFactory().openSession();

Query q = s.createQuery("from Product order by price asc");
List<Product> list = q.list();
for(Product p:list)
System.out.println(p.getName()+" "+p.getPrice());

Query count = s.createQuery("select count(*) from Product");
System.out.println("Total Products: "+count.uniqueResult());

s.close();
}
}
