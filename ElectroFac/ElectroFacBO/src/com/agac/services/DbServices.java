package com.agac.services;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


/**
 *
 * @author Carlos Aguirre 17 Feb 2010
 */
public class DbServices {

    
    private static EntityManagerFactory emf;

    public static <U> U saveObject(U u, boolean forUpdate) throws Exception {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("ElectroFacBOPU");
        }
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            if(forUpdate)
                u = em.merge(u);
            else
                em.persist(u);
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

    public static <U> List<U> getList(String s){
         if (emf == null) {
            emf = Persistence.createEntityManagerFactory("ElectroFacBOPU");
        }
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        List<U> l = em.createQuery(s).getResultList();
        em.getTransaction().commit();
        em.close();
        return l;
    }

    public static <U> List<U> getListWithParameters(String s, Object ... params){
         if (emf == null) {
            emf = Persistence.createEntityManagerFactory("ElectroFacBOPU");
        }
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Query qry = em.createQuery(s);
        for(int i=0; i<params.length; i++){
            qry = qry.setParameter(i+1, params[i]);
        }
        List<U> l = qry.getResultList();
        em.getTransaction().commit();
        em.close();
        return l;
    }

    public static void closeDbServices(){
        if((emf != null) && (emf.isOpen())){
            emf.close();
        }
    }
    public static void openDbServices(){
        try{
            if (emf == null)
                emf = Persistence.createEntityManagerFactory("ElectroFacBOPU");
        }catch(Exception e){}
    }
}
