package com.humanbooster.jdbc.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Manage the connection with the DB "authentification"
 * 
 * @author Anis
 */
class DataConnect
{
	private static Connection connection = null;
	
	/**
	 * Method getting the DB connection
	 * @return Connection
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static Connection getConnection()
			throws SQLException, ClassNotFoundException 
	{
		if (connection == null)
		{
			// necessaries datas
			String dbName = "authentification";
			String login = "root";
			String pass ="root";
			String fixTimeZoneError = "?useSSL=false&serverTimezone=UTC";	
			
			// Chargement du driver
			Class.forName("com.mysql.jdbc.Driver");
	
			connection = 
					DriverManager.getConnection("jdbc:mysql://localhost:3306/"
							+ dbName
							+ fixTimeZoneError, login, pass);
	
			// inform the user
			System.out.println("Connection succed.");
		}
		return connection;
	}
	
	/**
	 * method that close the DB connection
	 * @param connection to close
	 * @throws SQLException if closing the connection throws an exception
	 */
	public static void closeConnection(Connection connection)
			throws SQLException
	{
		connection.close();
	}
}
