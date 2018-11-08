package com.humanbooster.jdbc.clients;

import com.humanbooster.jdbc.dal.AnimalDAO;

public class AnimalClient
{

	public static void main(String[] args)
	{
		AnimalDAO.getInstance().delete(1);
		System.out.println(AnimalDAO.getInstance().getAll());
	}

}
