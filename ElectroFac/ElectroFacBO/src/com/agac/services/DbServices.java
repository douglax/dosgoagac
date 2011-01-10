package com.agac.services;

import com.agac.bo.Emisor;
import com.agac.bo.Serie;
import java.io.File;
import java.sql.Connection;
import java.util.Calendar;
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
            if (forUpdate) {
                u = em.merge(u);
            } else {
                em.persist(u);
            }
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            em.close();
            throw new Exception(
                    "Ocurrio un error al guardar los datos, verifique que todos los campos requeridos estan llenos",
                    e);
        }
        return u;
    }

    public static <U> List<U> getList(String s) {
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

    public static <U> List<U> getListWithParameters(String s, Object... params) {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("ElectroFacBOPU");
        }
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Query qry = em.createQuery(s);
        for (int i = 0; i < params.length; i++) {
            qry = qry.setParameter(i + 1, params[i]);
        }
        List<U> l = qry.getResultList();
        em.getTransaction().commit();
        em.close();
        return l;
    }

    public static int getSiguienteFolio(Emisor emisor, Serie serie) {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("ElectroFacBOPU");
        }
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Query qry = em.createQuery(
                "Select MAX(c.folio) from Comprobante c where c.emisor = ?1 "
                + "and c.anoAprobacion = ?2 and c.serie = ?3 and c.noAprobacion = ?4");
        qry = qry.setParameter(1, emisor).setParameter(2, serie.getAnoAprob()).setParameter(
                3, serie.getNumSerie()).setParameter(4, Integer.parseInt(serie.getNumAutorización()));
        Object num = qry.getSingleResult();
        em.getTransaction().commit();
        em.close();
        if (num == null) {
            num = serie.getFolioInicial().intValue();
            return (Integer) num;
        } else {
            return ((Integer) num) + 1;
        }
    }

    public static void ActualizaEmitidos() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("ElectroFacBOPU");
        }
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Query qry = em.createQuery(
                "Select MAX(l.emitidos) from Licencia l");

        Object num = qry.getSingleResult();


        Long siguiente = (Long) num + 1;

        Query upd = em.createNativeQuery("Update Licencia set emitidos=" + siguiente);

        int x = upd.executeUpdate();
        em.getTransaction().commit();
        em.close();




    }

    public static <U> List<U> getComprobantesDelMes(String rfcEmisor, int mes, int ano) {

        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("ElectroFacBOPU");
        }
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();


        //Version 1
//        Query query = em.createNativeQuery(
//
//
//                "select * from COMPROBANTE c inner join app.EMISOR e on (c.EMISOR_ID = e.ID) where e.RFC = '" +
//                rfcEmisor + "' and MONTH(c.FECHA) = " + mes + "and YEAR(c.fecha) = " + ano);


        //Version 2
        Query query = em.createNativeQuery(
                "select r.rfc, c.serie, c.folio, c.noaprobacion, c.fecha, c.total,'IVA' as \"IVA\", '1' as \"Estado\", c.ID "
                + "from   COMPROBANTE c inner join EMISOR e on (c.EMISOR_ID = e.ID) inner join Receptor r on (c.receptor_id = r.ID) "
                + "where e.RFC = '" + rfcEmisor + "' and MONTH(c.FECHA) = " + mes + " and YEAR(c.fecha) = " + ano);


        //List resultRows = query.getResultList();

        List<U> l = query.getResultList();
        em.getTransaction().commit();
        em.close();
        return l;

    }

    public static <U> List<U> getComprobantesDelMesPrueba(String rfcEmisor, int mes, int ano) {

        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("ElectroFacBOPU");
        }
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();


        //Version 1
//        Query query = em.createNativeQuery(
//
//
//       "select * from COMPROBANTE c inner join app.EMISOR e on (c.EMISOR_ID = e.ID) where e.RFC = '" +
//        rfcEmisor + "' and MONTH(c.FECHA) = " + mes + "and YEAR(c.fecha) = " + ano);


        //Version 2
        Query query = em.createNativeQuery(
                "select r.rfc, c.serie, c.folio, c.noaprobacion, c.fecha, c.total,'IVA' as \"IVA\", '1' as \"Estado\", c.ID "
                + "from   COMPROBANTE c inner join EMISOR e on (c.EMISOR_ID = e.ID) inner join Receptor r on (c.receptor_id = r.ID) "
                + "where e.RFC = '" + rfcEmisor + "' and MONTH(c.FECHA) = " + mes + " and YEAR(c.fecha) = " + ano);


        //List resultRows = query.getResultList();

        List<U> l = query.getResultList();
        em.getTransaction().commit();
        em.close();
        return l;

    }

    public static List getNativeQueryResult(String qry) {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("ElectroFacBOPU");
        }
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Query query = em.createNativeQuery(qry);
        List l = query.getResultList();
        em.getTransaction().commit();
        em.close();
        return l;
    }

    public static void closeDbServices() {
        if ((emf != null) && (emf.isOpen())) {
            emf.close();
        }
    }

    public static void openDbServices() {
        try {
            if (emf == null) {
                emf = Persistence.createEntityManagerFactory("ElectroFacBOPU");
            }
            EntityManager em = emf.createEntityManager();
            em.close();
        } catch (Exception e) {
        }
    }

    public static <U> U find(Class<U> u, Object pk) {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("ElectroFacBOPU");
        }
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        U obj = em.find(u, pk);
        em.getTransaction().commit();
        em.close();
        return obj;

    }

    public static <U> U getSingleObjectWithParameters(String s, Object... params) {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("ElectroFacBOPU");
        }
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Query qry = em.createQuery(s);
        for (int i = 0; i < params.length; i++) {
            qry = qry.setParameter(i + 1, params[i]);
        }
        U obj = (U) qry.getSingleResult();
        em.getTransaction().commit();
        em.close();
        return obj;
    }

    public static Connection getDBconnection() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("ElectroFacBOPU");
        }

        oracle.toplink.essentials.ejb.cmp3.EntityManager em =
                (oracle.toplink.essentials.ejb.cmp3.EntityManager) emf.createEntityManager().getDelegate();
        Connection conn = (Connection) em.getSession().getLogin().connectToDatasource(null);

        //System.out.println(emf.createEntityManager().getDelegate());
        return conn;
    }

    public static void backupDB(String s, String ruta) {
        System.out.println("Entrando a backupDB");
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("ElectroFacBOPU");
        }
        System.out.println("checamos si emf == null");
        EntityManager em = emf.createEntityManager();
        System.out.println("creamos entitymanager em");
        em.getTransaction().begin();
        System.out.println("Inicia transacción");
        Query qry = em.createNativeQuery(s);
        System.out.println("creamos nativequery");
        qry = qry.setParameter(1, ruta);
        qry.executeUpdate();
        System.out.println("Ejecutamos query");
        em.getTransaction().commit();
        em.close();
        //return obj;
        ZipBuilder zip = new ZipBuilder();
        zip.setSourceFolder(ruta + File.separator + "efactura");
        Calendar fecha = Calendar.getInstance();
        zip.zip(ruta + File.separator + fecha.get(Calendar.YEAR) + (fecha.get(Calendar.MONTH) + 1)
                + fecha.get(Calendar.DAY_OF_MONTH) + ".zip");
        //Borramos el directorio
        deleteDir(new File(ruta + File.separator + "efactura"));

    }

    private static boolean deleteDir(File dir) {
        if (dir.isDirectory()) {
            String[] children = dir.list();
            for (int i = 0; i < children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
        }
        return dir.delete();
    }
}
