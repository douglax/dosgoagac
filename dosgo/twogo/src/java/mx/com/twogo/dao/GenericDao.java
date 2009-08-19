/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.twogo.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;

/**
 *
 * @author Carlos Aguirre
 */
public class GenericDao {

    private DataSource ds;

    public GenericDao() throws NamingException {
        InitialContext ic = null;
        try {
            ic = new InitialContext();
        } catch (NamingException ex) {
            Logger.getLogger(GenericDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        ds = (DataSource) ic.lookup("java:comp/env/jdbc/TwoGo");
    }

    protected Object execute(ExecuteCallback callback) {
        Log log = LogFactory.getLog(getClass());
        Connection cn = null;
        try {
            cn = ds.getConnection();
            cn.close();
        } catch (SQLException ex) {
            Logger.getLogger(GenericDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Object o = callback.execute(cn);
            return o;
        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        } finally {
            try {
                if (!cn.isClosed()) {
                    cn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(GenericDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public Object find(final String qry, final Map<String, ?> params) {

        return null;
    }

    public void save(final Object object) {
        execute(new ExecuteCallback() {

            @Override
            public Object execute(Connection em) throws Exception {

                return null;
            }
        });
    }

    public void delete(final Object object) {

    }
}
