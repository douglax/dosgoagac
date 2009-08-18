/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.twogo.dao;

import java.sql.Connection;

/**
 *
 * @author carlos
 */
public interface ExecuteCallback {

    Object execute(Connection cn) throws Exception;
}
