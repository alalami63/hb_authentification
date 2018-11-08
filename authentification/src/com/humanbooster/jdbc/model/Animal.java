package com.humanbooster.jdbc.model;

public class Animal {

	private int idAnimal;
	private String name, color;
	private Boolean dangerous;
	private int idUser;

	public Animal(String name, String color, Boolean dangerous, int idUser) {
		super();
		this.name = name;
		this.color = color;
		this.dangerous = dangerous;
		this.idUser = idUser;
	}

	public int getIdAnimal()
	{
		return idAnimal;
	}

	public void setIdAnimal(int idAnimal)
	{
		this.idAnimal = idAnimal;
	}

	public int getIdUser()
	{
		return idUser;
	}

	public void setIdUser(int idUser)
	{
		this.idUser = idUser;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Boolean getDangerous() {
		return dangerous;
	} 

	public void setDangerous(Boolean dangerous) {
		this.dangerous = dangerous;
	}

	@Override
	public String toString() {
		return "Animal [name=" + name + ", color=" + color + ", dangerous=" + dangerous + "]";
	}
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof Animal)
			if (name.equalsIgnoreCase(((Animal) o).getName())) {
				return true;
			}
		return false;
	}
}
