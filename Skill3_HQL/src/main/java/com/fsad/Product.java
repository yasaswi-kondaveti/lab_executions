
package com.fsad;
import javax.persistence.*;

@Entity
public class Product {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int id;
private String name;
private String description;
private double price;
private int quantity;

public Product(){}

public Product(String n,String d,double p,int q){
name=n; description=d; price=p; quantity=q;
}

public int getId(){return id;}
public String getName(){return name;}
public double getPrice(){return price;}
public int getQuantity(){return quantity;}
public void setPrice(double p){price=p;}
public void setQuantity(int q){quantity=q;}
}
