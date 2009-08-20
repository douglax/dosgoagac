/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.com.twogo.services;

import javax.activation.DataSource;
import javax.servlet.ServletContext;
import mx.com.twogo.dao.CategoriaDao;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 *
 * @author caguirre
 */
public class DaoServices {

    private BeanFactory bf;

    public DaoServices(ServletContext sc) {
        bf = WebApplicationContextUtils.getWebApplicationContext(sc);
    }

    public  CategoriaDao getCategoriaDao(){
        try{
            return (CategoriaDao)bf.getBean("categoriaDao");
        }catch(BeansException be){
            return null;
        }
    }
}
