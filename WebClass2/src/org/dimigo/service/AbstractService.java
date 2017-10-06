/**
 * 
 */
package org.dimigo.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * <pre>
 * org.dimigo.dao
 *  |_ DataSource
 * 
 * 1. 개요 :
 * 2. 작성일 : 2017. 10. 6.
 * </pre>
 *
 * @author : teacher
 * @version : 1.0
 */
public abstract class AbstractService {

    public Connection getConnection() throws SQLException, NamingException {
    	Context context = new InitialContext();
    	DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mysql");
    	return dataSource.getConnection();	
    }
    
}
