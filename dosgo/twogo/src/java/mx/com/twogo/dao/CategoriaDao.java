/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.com.twogo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import mx.com.twogo.domain.Categoria;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;

/**
 *
 * @author caguirre
 */
public class CategoriaDao extends SimpleJdbcDaoSupport{

    public List getAllCategorias(){
      return getJdbcTemplate().query("Select * from categoria order by desc_categoria",
              new ParameterizedRowMapper<Categoria>(){
            public Categoria mapRow(ResultSet arg0, int arg1) throws SQLException {
                Categoria c = new Categoria();
                c.setId(arg0.getInt("id_categoria"));
                c.setDescripcion(arg0.getString("desc_categoria"));
                return c;
            }
      });
    }
}
