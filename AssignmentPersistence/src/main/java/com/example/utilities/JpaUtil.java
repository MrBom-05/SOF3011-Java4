package com.example.utilities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {
    private static EntityManagerFactory factory;
    private static EntityManager entityManager;

    private static EntityManagerFactory getFactory() {
        if (factory == null || factory.isOpen() == false) {
            factory = Persistence.createEntityManagerFactory("SOF3011");
        }

        return factory;
    }

    public static EntityManager getEntityManager() {
        if (entityManager == null || entityManager.isOpen() == false) {
            entityManager = getFactory().createEntityManager();
        }

        return entityManager;
    }
}
