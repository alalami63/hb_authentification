package com.humanbooster.jdbc.clients;

import com.humanbooster.jdbc.dal.UserDAO;
import com.humanbooster.jdbc.model.User;

/**
 * Only here to test UserDAO's methods
 * 
 * @author Anis
 */
public class UserClient
{
	public static void main(String[] args)
	{
		UserDAO userDAO = UserDAO.getInstance();
		
		User u1 = new User("anis", "lalami", "monlog", "monpass");
		User u2 = new User("mehdi", "lalami", "monlog", "sonpass");
		
		userDAO.create(u1);
		int status = userDAO.create(u2);
		if (status == 0)
		{
			System.out.println("le login est déjà utilisé.");
		}
		
		System.out.println("Created users : ");
		System.out.println(u1);
		System.out.println(u2);
		
		u2.setFirstname("newfname");
		u2.setLastname("newlname");
		u2.setPassword("newpass");
		
		userDAO.update(u2);
		
		System.out.println("Update and get all users : ");
		System.out.println(userDAO.getAll());
		
		String login = "sonlog";
		System.out.println("Get the user which has his idUser = " + login);
		System.out.println(userDAO.get(login));
		
		// uncomment to test deleteAll and change the visibilité of this method
//		userDAO.deleteAll();
		
		System.out.println("Delete all and get all : ");
		System.out.println(userDAO.getAll());
		
		
	}

}
