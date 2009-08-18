/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.twogo.dao;

/**
 *
 * @author Carlos Aguirre
 */
public class GenericDao {

    protected Object execute(ExecuteCallback callback) {
        Log log = LogFactory.getLog(getClass());
        Connection cn = EMF.get().createEntityManager();
        try {
            Object o = callback.execute(cn);
            return o;
        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        } finally {
            if (em.isOpen()) {
                em.close();
            }
        }
    }

    @SuppressWarnings("unchecked")
    public List<T> findList(final String qry, final Map<String, ?> params) {
        return (List<T>) find(qry, params);
    }

    public Object find(final String qry, final Map<String, ?> params) {

        return execute(new ExecuteCallback() {

            @SuppressWarnings("unchecked")
            @Override
            public Object execute(EntityManager em) throws Exception {
                Query query = em.createQuery(qry);
                if (params != null) {
                    for (Map.Entry<String, ?> entry : params.entrySet()) {
                        query.setParameter(entry.getKey(), entry.getValue());
                    }
                }
                List<T> l = query.getResultList();
                l.size();
                return l;
            }
        });
    }

    public void save(final Object object) {
        execute(new ExecuteCallback() {

            @Override
            public Object execute(EntityManager em) throws Exception {
                em.persist(object);
                return null;
            }
        });
    }

    public void delete(final Object object) {
        execute(new ExecuteCallback() {

            @Override
            public Object execute(EntityManager em) throws Exception {
                em.remove(object);
                return null;
            }
        });
    }
}
