package fr.eni.javaee.ebay.test;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionPourTest {
	
	private Connection connexion = null;
	
	private ConnectionPourTest() {
		
	    try {
	        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

	        String url = "jdbc:sqlserver://10.106.200.5;databasename=ebay";
	        String user = "sa";
	        String passwd = "Pa$$w0rd";

	        connexion = DriverManager.getConnection(url, user, passwd);
	        System.out.println("Connexion effective !");         
	           
	      } catch (Exception e) {
	        e.printStackTrace();
	      }		
	}
	
	public Connection getInstance() {
		
		if(connexion == null) {
			new ConnectionPourTest();
		}

			return connexion;

	}
	


}
