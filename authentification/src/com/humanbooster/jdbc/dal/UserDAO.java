package com.humanbooster.jdbc.dal;

import java.sql.SQLException;

import com.humanbooster.jdbc.model.Animal;
import com.humanbooster.jdbc.model.User;

/**
 * DAO for User's model implementing CRUD for the model User 
 * 		{@linkplain com.humanbooster.jdbc.model.User}
 * 
 * @author Anis
 */
public class UserDAO
{

	/**
	 * Instance of UserDAO for singleton class
	 */
	private static UserDAO instance;
	
	/**
	 * Connection used {@linkplain java.sql.Connection}
	 */
	private java.sql.Connection connection;
	
	/**
	 * Default private constructor of a UserDAO
	 */
	private UserDAO()
	{
		try 
		{
			connection = DataConnect.getConnection();
		}
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Static method to get the unique instance of this DAO
	 * 
	 * @return a UserDAO
	 */
	public static UserDAO getInstance() 
	{
		if (instance == null)
			instance = new UserDAO();
		return instance;
	}
	
	public int create(User user) 
	{
		String query = "INSERT INTO user(firstname, lastname, login, password) VALUE (?,?,?,?)";
		int status = 0;
		try 
		{
			java.sql.PreparedStatement pst = connection.prepareStatement(query, java.sql.Statement.RETURN_GENERATED_KEYS);
			pst.setString(1, user.getFirstname());
			pst.setString(2, user.getLastname());
			pst.setString(3, user.getLogin());
			pst.setString(4, user.getPassword());
			status = pst.executeUpdate();
			java.sql.ResultSet rs = pst.getGeneratedKeys();
			if (rs.next())
			{
				user.setIdUser(rs.getInt(1));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return status;
	}
	
	public int delete(String login)
	{
		int result = 0;
		String query = "DELETE FROM user WHERE login=?";
		try 
		{
			java.sql.PreparedStatement pst = connection.prepareStatement(query);
			pst.setString(1, login);
			result = pst.executeUpdate();;
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return result;
	}
	
	public int update(User user)
	{
		int result = 0;
		String query = "UPDATE user SET firstname=?, lastname=?, password=? WHERE login=?";
		try
		{
			java.sql.PreparedStatement pst = connection.prepareStatement(query);
			pst.setString(1, user.getFirstname());
			pst.setString(2, user.getLastname());
			pst.setString(3, user.getPassword());
			pst.setString(4, user.getLogin());
			result = pst.executeUpdate();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * Select the user that has his login corresponds to the parameter login
	 * 
	 * @param idUser of the user to return
	 * @return the user found, if not, return null
	 */
	public User get(String login)
	{
		User user = null;
		String query = "SELECT * FROM user WHERE login=?";
		try
		{
			java.sql.PreparedStatement pst = connection.prepareStatement(query);
			pst.setString(1, login);
			java.sql.ResultSet rs = pst.executeQuery();
			if (rs.next())
			{
				user = convertResultSetToUser(rs);	
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return user;
	}

	public java.util.List<User> getAll()
	{
		java.util.List<User> users = new java.util.LinkedList<>();
		String query = "SELECT * FROM user";
		try
		{
			java.sql.PreparedStatement pst = connection.prepareStatement(query);
			java.sql.ResultSet rs = pst.executeQuery();
			while (rs.next())
			{
				users.add(convertResultSetToUser(rs));
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		 return users;
	}
	
	/**
	 * Private method to convert a ResulSet to a User {@linkplain java.sql.ResultSet}
	 * 
	 * @param rs to convert in user
	 * @return the converted user
	 */
	private static User convertResultSetToUser(java.sql.ResultSet rs)
	{
		User user = null;
		try
		{
			user = new User(rs.getString("firstname"), rs.getString("lastname"), rs.getString("login"), rs.getString("password"));
			user.setIdUser(rs.getInt("idUser"));
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return user;
	}
	
	/**
	 * Delete all entries in the database
	 * 
	 * @return status of executeUpdate() from {@linkplain java.sql.PreparedStatement}
	 */
	@SuppressWarnings("unused")
	private int deleteAll()
	{
		String query = "TRUNCATE user";
		int status = 0;
		try
		{
			java.sql.PreparedStatement pst = connection.prepareStatement(query);
			status = pst.executeUpdate();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return status;
	}
	
	public java.util.List<Animal> getAnimals(String login)
	{
		java.util.List<Animal> animals = new java.util.LinkedList<>();
		String query = "SELECT a.idAnimal, a.name, a.color, a.dangerous, a.idUser FROM animal a, user u WHERE a.idUser=u.idUser and u.login=?";
		try
		{
			java.sql.PreparedStatement pst = connection.prepareStatement(query);
			pst.setString(1, login);
			java.sql.ResultSet rs = pst.executeQuery();
			while (rs.next())
			{
				animals.add(convertResultSetToAnimal(rs));
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		 return animals;
	}
	
	/**
	 * Private method to convert a ResulSet to a User {@linkplain java.sql.ResultSet}
	 * 
	 * @param rs to convert in user
	 * @return the converted user
	 */
	private static Animal convertResultSetToAnimal(java.sql.ResultSet rs)
	{
		Animal animal = null;
		try
		{
			animal = new Animal(rs.getString("name"), 
								rs.getString("color"), 
								rs.getBoolean("dangerous"), 
								rs.getInt("idUser"));
			animal.setIdAnimal(rs.getInt("idAnimal"));
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return animal;
	}
}