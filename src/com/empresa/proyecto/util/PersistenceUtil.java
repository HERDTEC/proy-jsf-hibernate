package com.empresa.proyecto.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceUtil {
	private static EntityManagerFactory emf;
	static {
		emf = Persistence.createEntityManagerFactory("WebJpaJsfPU");
	}
	public static EntityManagerFactory getEmf() {
		return emf;
	}
}
