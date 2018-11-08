package com.humanbooster.jdbc.dal;

import java.sql.SQLException;

import com.humanbooster.jdbc.model.Animal;

public class AnimalDAO {

	/**
	 * Instance of UserDAO for singleton class
	 */
	private static AnimalDAO instance;
	
	/**
	 * Connection used {@linkplain java.sql.Connection}
	 */
	private java.sql.Connection connection;
	
	/**
	 * Default private constructor of a UserDAO
	 */
	private AnimalDAO()
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
	public static AnimalDAO getInstance() 
	{
		if (instance == null)
			instance = new AnimalDAO();
		return instance;
	}
	
	public int create(Animal animal) 
	{
		String query = "INSERT INTO animal(name, color, dangerous, idUser) VALUE (?,?,?,?)";
		int status = 0;
		try 
		{
			java.sql.PreparedStatement pst = connection.prepareStatement(query);
			pst.setString(1, animal.getName());
			pst.setString(2, animal.getColor());
			pst.setBoolean(3, animal.getDangerous());
			pst.setInt(4, animal.getIdUser());
			status = pst.executeUpdate();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return status;
	}
	
	public int delete(int id)
	{
		int result = 0;
		String query = "DELETE FROM animal WHERE idAnimal=?";
		try 
		{
			java.sql.PreparedStatement pst = connection.prepareStatement(query);
			pst.setInt(1, id);
			result = pst.executeUpdate();;
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return result;
	}
	
	public int update(Animal animal)
	{
		int result = 0;
		String query = "UPDATE animal SET color=?, dangerous=?, idUser=? WHERE name=?";
		try
		{
			java.sql.PreparedStatement pst = connection.prepareStatement(query);
			pst.setString(1, animal.getColor());
			pst.setBoolean(2, animal.getDangerous());
			pst.setInt(3, animal.getIdUser());
			pst.setString(4, animal.getName());
			result = pst.executeUpdate();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * Select the animal that has his login corresponds to the parameter login
	 * 
	 * @param name of the animal to return
	 * @return the animal found, if not, return null
	 */
	public Animal get(int id)
	{
		Animal animal = null;
		String query = "SELECT * FROM animal WHERE idAnimal=?";
		try
		{
			java.sql.PreparedStatement pst = connection.prepareStatement(query);
			pst.setInt(1, id);
			java.sql.ResultSet rs = pst.executeQuery();
			if (rs.next())
			{
				animal = convertResultSetToAnimal(rs);	
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return animal;
	}

	public java.util.List<Animal> getAll()
	{
		java.util.List<Animal> animals = new java.util.LinkedList<>();
		String query = "SELECT * FROM animal";
		try
		{
			java.sql.PreparedStatement pst = connection.prepareStatement(query);
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
	
	/**
	 * Delete all entries in the database
	 * 
	 * @return status of executeUpdate() from {@linkplain java.sql.PreparedStatement}
	 */
	@SuppressWarnings("unused")
	private int deleteAll()
	{
		String query = "TRUNCATE animal";
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
	
}
