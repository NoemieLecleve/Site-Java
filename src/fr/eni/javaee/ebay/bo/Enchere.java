package fr.eni.javaee.ebay.bo;

import java.util.Date;

public class Enchere {

	private Date dateEnchere;
	private int montantEnchere;
	private Utilisateur noUtilisateur;
	private ArticleVendu noArticle;

	public Enchere() {

	}

	/**
	 * @param dateEnchere
	 * @param montantEnchere
	 * @param noUtilisateur
	 * @param noArticle
	 */
	public Enchere(Date dateEnchere, int montantEnchere, Utilisateur noUtilisateur, ArticleVendu noArticle) {
		this.dateEnchere = dateEnchere;
		this.montantEnchere = montantEnchere;
		this.noUtilisateur = noUtilisateur;
		this.noArticle = noArticle;
	}

	/**
	 * @param dateEnchere
	 * @param montantEnchere
	 */
	public Enchere(Date dateEnchere, int montantEnchere) {
		this.dateEnchere = dateEnchere;
		this.montantEnchere = montantEnchere;
	}

	/**
	 * @return the dateEnchere
	 */
	public Date getDateEnchere() {
		return dateEnchere;
	}

	/**
	 * @param dateEnchere
	 *            the dateEnchere to set
	 */
	public void setDateEnchere(Date dateEnchere) {
		this.dateEnchere = dateEnchere;
	}

	/**
	 * @return the montantEnchere
	 */
	public int getMontantEnchere() {
		return montantEnchere;
	}

	/**
	 * @param montantEnchere
	 *            the montantEnchere to set
	 */
	public void setMontantEnchere(int montantEnchere) {
		this.montantEnchere = montantEnchere;
	}

	/**
	 * @return the noUtilisateur
	 */
	public Utilisateur getNoUtilisateur() {
		return noUtilisateur;
	}

	/**
	 * @param noUtilisateur
	 *            the noUtilisateur to set
	 */
	public void setNoUtilisateur(Utilisateur noUtilisateur) {
		this.noUtilisateur = noUtilisateur;
	}

	/**
	 * @return the noArticle
	 */
	public ArticleVendu getNoArticle() {
		return noArticle;
	}

	/**
	 * @param noArticle
	 *            the noArticle to set
	 */
	public void setNoArticle(ArticleVendu noArticle) {
		this.noArticle = noArticle;
	}

}
