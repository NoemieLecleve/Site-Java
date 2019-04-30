package fr.eni.javaee.ebay.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fr.eni.javaee.ebay.bll.BLLException;
import fr.eni.javaee.ebay.bll.ManagerFactory;
import fr.eni.javaee.ebay.bll.UtilisateurManager;
import fr.eni.javaee.ebay.bll.impl.UtilisateurManagerImpl;
import fr.eni.javaee.ebay.bo.Utilisateur;
import fr.eni.javaee.ebay.dal.ConnectionProvider;
import fr.eni.javaee.ebay.dal.DALException;

class UtilisateurTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	@Test
	void testCripterMDP() throws DALException, BLLException {
		
		String resultatAttendu = "e8972bcf0d36de03e086997089154895ef4299c18d617f2b1b59103c4cd1689c";
		String motDePasse = "enchere";
		
		UtilisateurManagerImpl umi = new UtilisateurManagerImpl();
		String motDePasseCripte = umi.cripterMDP(motDePasse);
		assertEquals(motDePasseCripte, resultatAttendu);
		
	}

	@Test
	void testSeConnecter() {
		//TODO chargement du contexte de la bdd
		Utilisateur user = new Utilisateur("Karman", "mickael");
		
		UtilisateurManager utilisateurManager = null;
		
		try {
			utilisateurManager = ManagerFactory.getUtilisateurManageur();
		} catch (BLLException e) {
			fail(e.getMessage());
		}
		/*
		Utilisateur userConnecte = utilisateurManager.seConnecter(user);
		
		if(userConnecte == null) {
			fail("Echec connexion utilisateur");
		}		
		*/
	}


}
