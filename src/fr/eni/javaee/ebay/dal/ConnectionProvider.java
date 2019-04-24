package fr.eni.javaee.ebay.dal;

import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionProvider {
	
	private static Connection connexion = null;
	
	private ConnectionProvider() throws DALException {
		
		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookupLink("java:comp/env/jdbc/pool_cnx");
			connexion = dataSource.getConnection();
		}
		catch(NamingException e) {
			e.printStackTrace();
			throw new DALException("Problème de chargement de contexte");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getInstance() throws DALException{
		
		if(connexion == null) {
			new ConnectionProvider();
		}
		return connexion;
	}
}
