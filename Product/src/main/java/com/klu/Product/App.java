package com.klu.Product;

import java.util.List;
import com.klu.dao.ProductDao;
import com.klu.entity.Product;

//import org.product.SessionFactory;
//import com.klu.util.ProductUtil;
/**
 * Hello world!
 */
public class App {
	public static void main(String[] args) {
		// System.out.println("Hello World!");

		// SessionFactory pf=UserUtil.getSessionFactory();
		/*
		 * Product pt2=new Product(); pt2.setId(2); pt2.setName("Cleanser");
		 * pt2.setQuantity(70); pt2.setPrice(607); pdao.updateProduct(pt2);
		 */

		Product pt3 = new Product();
		pt3.setId(3);
		pt3.setName("Serum");
		pt3.setQuantity(30);
		pt3.setPrice(455);
		ProductDao pdao = new ProductDao();
		pdao.saveProduct(pt3);

		Product pt4 = new Product();
		pt4.setId(4);
		pt4.setName("Sunscreen");
		pt4.setQuantity(50);
		pt4.setPrice(250);
		pdao.saveProduct(pt4);

		List<Product> li = pdao.getAllUsers();
		for (Product pt : li) {
			System.out.println(pt);
		}

		Product pt1 = pdao.getById(1);
		System.out.println(pt1);

		Product pt2 = new Product();
		pt2.setName("Moisturizer");
		pt2.setId(2);
		pt2.setPrice(400);
		pt2.setQuantity(50);
		pdao.updateProduct(pt2);

		pdao.deleteProduct(2);

		List<Product> li1 = pdao.getAllUsers();
		for (Product pt : li1) {
			System.out.println(pt);
		}
	}
}