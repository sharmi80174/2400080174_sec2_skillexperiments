package com.klu.dao;

import org.hibernate.Transaction;
import org.hibernate.Session;
import com.klu.entity.Product;
import com.klu.util.ProductUtil;
import java.util.List;
public class ProductDao {

	//insertion of record
	public void saveProduct(Product pt) {
	try(Session p=ProductUtil.getSessionFactory().openSession()){
		Transaction tx=p.beginTransaction();//for modification of transaction is used
		p.save(pt);
		tx.commit();
	}catch(Exception e) {
		System.out.println(e);
	}
	}
	//selection of all records
	public List<Product> getAllUsers(){
		try(Session p=ProductUtil.getSessionFactory().openSession()){
			return p.createQuery("from Product",Product.class).list();
		}
	}
	//selecting a record
		public Product getById(int id) {
			try(Session p=ProductUtil.getSessionFactory().openSession()){
				return p.get(Product.class, id);
			}
	}
	//updating a record
	public void updateProduct(Product pt) {
		Transaction tx=null;
		try(Session p=ProductUtil.getSessionFactory().openSession()){
			tx=p.beginTransaction();//for modification of transaction is used
			p.merge(pt);
			tx.commit();
		}catch(Exception e) {
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
	}
	//deleting a record
	public void deleteProduct(int id) {
		Transaction tx=null;
		try(Session p=ProductUtil.getSessionFactory().openSession()){
			tx=p.beginTransaction();//for modification of transaction is used
			p.delete(id);
			tx.commit();
		}catch(Exception e) {
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
	}
}