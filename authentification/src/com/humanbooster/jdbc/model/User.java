package com.humanbooster.jdbc.model;


/**
 * Model of the users for authentification
 * 
 * @author Anis
 */
public class User
{
	/**
	 * Unique Identifier used in the DB.
	 */
	private int idUser;
	
	/**
	 * Properties of a typical user.
	 */
	private String firstname, lastname, login, password;
	
	/**
	 * Default constructor must not initialize the id.
	 * 
	 * @param firstname's user
	 * @param lastname's user
	 * @param login's user
	 * @param password's user
	 */
	public User(String firstname, String lastname, String login, String password)
	{
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.login = login;
		this.password = password;
		this.idUser = -1; // means unset
	}
	
	/* Getters --- Setters */
	
	public int getIdUser()
	{
		return idUser;
	}

	public void setIdUser(int idUser)
	{
		this.idUser = idUser;
	}

	public String getFirstname()
	{
		return firstname;
	}

	public void setFirstname(String firstname)
	{
		this.firstname = firstname;
	}

	public String getLastname()
	{
		return lastname;
	}

	public void setLastname(String lastname)
	{
		this.lastname = lastname;
	}

	public String getLogin()
	{
		return login;
	}

	public void setLogin(String login)
	{
		this.login = login;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	
	@Override
	public String toString() 
	{
		return "User [idUser=" + idUser + ", firstname=" + firstname + ", lastname=" + lastname + ", login=" + login
				+ ", password=" + password + "]";
	}
	
	@Override
	public boolean equals(Object object)
	{
		if (object != null 
				&& object instanceof User 
				&& this.sameIdUser((User)object))
		{
			return true;
		}
		return false;
	}


	
	/**
	 * Test the idUser of this and user in param
	 * @param user to test with this
	 * @return true if they have the same id
	 */
	private boolean sameIdUser(User user)
	{
		if (user.getIdUser() == this.idUser)
			return true;
		return false;
	}
}
