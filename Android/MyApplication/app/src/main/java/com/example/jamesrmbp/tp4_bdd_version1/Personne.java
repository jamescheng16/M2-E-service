
package com.example.jamesrmbp.tp4_bdd_version1;

/**
 * Created by Jean-Claude on 07/10/2014.
 * Classe m�tier pour une Personne
 */
public class Personne {
	private int id;
	private String nom;
	private String prenom;
	private int age;

    Personne(){

    }

    public Personne(int id, String nom, String prenom, int age) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
    }

    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom.toUpperCase();
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String original) {
		StringBuilder prenom = new StringBuilder(original.toLowerCase());
		char premier = Character.toUpperCase(original.charAt(0));
		prenom.setCharAt(0, premier);
		this.prenom = prenom.toString();
	}

	@Override
	public String toString() {
		return nom + ", " + prenom + " (" + age + ')';
	}
}
