package com.klu.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ProductUtil {
	private static SessionFactory pf;
	static {
		try {
			pf = new Configuration().configure().buildSessionFactory();
			
		}
		catch(Throwable e) {
			e.printStackTrace();
			throw new ExceptionInInitializerError();
		}
	}
	public static SessionFactory getSessionFactory(){
		return pf;
	}
}