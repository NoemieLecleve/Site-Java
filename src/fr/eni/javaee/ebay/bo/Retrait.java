package fr.eni.javaee.ebay.bo;

public class Retrait {

	private String rueRetrait;
	
	private String villeRetrait;
	
	private String codePostalRetrait;
	
	
	
	public Retrait() {
		 
	}

	/**
	 * @param rueRetrait
	 * @param villeRetrait
	 * @param codePostalRetrait
	 */
	public Retrait(String rueRetrait, String villeRetrait, String codePostalRetrait) {
		 
		this.rueRetrait = rueRetrait;
		this.villeRetrait = villeRetrait;
		this.codePostalRetrait = codePostalRetrait;
	}

	/**
	 * @return the rueRetrait
	 */
	public String getRueRetrait() {
		return rueRetrait;
	}

	/**
	 * @param rueRetrait the rueRetrait to set
	 */
	public void setRueRetrait(String rueRetrait) {
		this.rueRetrait = rueRetrait;
	}

	/**
	 * @return the villeRetrait
	 */
	public String getVilleRetrait() {
		return villeRetrait;
	}

	/**
	 * @param villeRetrait the villeRetrait to set
	 */
	public void setVilleRetrait(String villeRetrait) {
		this.villeRetrait = villeRetrait;
	}

	/**
	 * @return the codePostalRetrait
	 */
	public String getCodePostalRetrait() {
		return codePostalRetrait;
	}

	/**
	 * @param codePostalRetrait the codePostalRetrait to set
	 */
	public void setCodePostalRetrait(String codePostalRetrait) {
		this.codePostalRetrait = codePostalRetrait;
	}

}
