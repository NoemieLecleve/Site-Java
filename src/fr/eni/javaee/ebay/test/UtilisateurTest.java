package fr.eni.javaee.ebay.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fr.eni.javaee.ebay.bll.ManagerFactory;
import fr.eni.javaee.ebay.bll.UtilisateurManager;
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
	void testseConnecter() {
		
		Utilisateur user = new Utilisateur("Karman", "mickael");
		
		UtilisateurManager utilisateurManager = null;
		
		try {
			utilisateurManager = ManagerFactory.getUtilisateurManageur();
		} catch (DALException e) {
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
