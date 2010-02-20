package com.agac.services;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


/**
 *
 * @author Carlos Aguirre 17 Feb 2010
 */
public class DbServices {

    
    private static EntityManagerFactory emf;

    public static <U> U saveObject(U u) throws Exception {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("ElectroFacBOPU");
        }
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            u = em.merge(u);
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            if (em.getTransaction().isActive())
                    em.getTransaction().rollback();
            em.close();
            throw new Exception(
                    "Ocurrio un error al guadar los datos, verifique que todos los campos requeridos estan llenos",
                    e);
        }
        return u;
    }

    public static void closeDbServices(){
        if((emf != null) && (emf.isOpen())){
            emf.close();
        }
    }
}