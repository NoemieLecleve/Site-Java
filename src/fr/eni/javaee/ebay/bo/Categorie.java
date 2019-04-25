package fr.eni.javaee.ebay.bo;

public class Categorie {

	private int noCategorie;
	private String libelle;

	public Categorie() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param noCategorie
	 * @param libelle
	 */
	public Categorie(int noCategorie, String libelle) {
		this.noCategorie = noCategorie;
		this.libelle = libelle;
	}

	/**
	 * @return the noCategorie
	 */
	public int getNoCategorie() {
		return noCategorie;
	}

	/**
	 * @param noCategorie
	 *            the noCategorie to set
	 */
	public void setNoCategorie(int noCategorie) {
		this.noCategorie = noCategorie;
	}

	/**
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}

	/**
	 * @param libelle
	 *            the libelle to set
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

}
