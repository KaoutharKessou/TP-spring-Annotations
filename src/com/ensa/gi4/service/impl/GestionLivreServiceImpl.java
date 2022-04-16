    
package com.ensa.gi4.service.impl;

import com.ensa.gi4.DAO.MaterielDAO;
import com.ensa.gi4.modele.Livre;
import com.ensa.gi4.modele.Materiel;
import com.ensa.gi4.service.api.GestionLivreService;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


@Component
public class GestionLivreServiceImpl implements GestionLivreService{

    MaterielDAO dao;
    
    @Autowired 
    public GestionLivreServiceImpl(@Qualifier("materielDAO") MaterielDAO dao){
        this.dao = dao;
    }
    
       @Override
    public void init() {
        //l'initialisation du service est réalier par la gestionMateriel
    }

    @Override
    public void listerMateriel() {
        //la liste des materiaux est indepandante du type, donc réaliser ppar gestionMateriell
    }

    @Override
    public void ajouterNouveauMateriel(Materiel materiel) {
        System.out.println("Veuillez saisir le nom du livre que vous voulez ajouter : ");
        Scanner scanner = new Scanner(System.in);
        String nom = scanner.nextLine();
        materiel = new Livre();
        materiel.setName(nom);
        dao.ajouterNouveauMateriel(materiel);
    }

    @Override
    public void supprimerMateriel() {
        System.out.println("Veuillez saisir le nom du livre que vous voulez supprimer : ");
        Scanner scanner = new Scanner(System.in);
        String nom = scanner.nextLine();
        int id=-1;
        for(int i = 0;i<dao.getAllMateriel().size();i++)
	        {
				if(dao.getAllMateriel().get(i).getClass().toString().equals("class com.ensa.gi4.modele.Livre") && dao.getAllMateriel().get(i).getName().equals(nom)) // si c'est un livre avec le nom chercher
				{
					id=i;break;
				}
	        }
        if(id>=0)
        {
            dao.supprimerMateriel(id);
            System.out.println("la suppression du livre est effectué avec succés ");
        }
        else
            System.out.println("Livre introuvable");
    }

    @Override
    public void modifierMateriel() {
        System.out.println("Veuillez saisir le nom du livre que vous voulez modifier : ");
        Scanner scanner = new Scanner(System.in);
        String nom = scanner.next();
        int id=-1;
        for(int i = 0;i<dao.getAllMateriel().size();i++)
	        {
				if(dao.getAllMateriel().get(i).getClass().toString().equals("class com.ensa.gi4.modele.Livre") && dao.getAllMateriel().get(i).getName().equals(nom)) // si c'est un livre avec le nom chercher
				{
					id=i;
                                        System.out.println("Livre trouvé, veullez saisir le nouveau nom : ");
                                        nom = scanner.next();
                                        break;
				}
	        }
        if(id>=0)
        {
            dao.modifierMateriel(id,nom);
            System.out.println("la modification du livre est effectué avec succés ");
        }
        else
            System.out.println("Livre introuvable");
    }

    @Override
    public Materiel chercherMateriel() {
        
                 System.out.println("Veuillez saisir le nom du livre que vous voulez chercher : ");
	        Scanner scanner = new Scanner(System.in);
	        String nom = scanner.next();
                int id=-1;
        for(int i = 0;i<dao.getAllMateriel().size();i++)
	        {
				if(dao.getAllMateriel().get(i).getClass().toString().equals("class com.ensa.gi4.modele.Livre") && dao.getAllMateriel().get(i).getName().equals(nom)) // si c'est un livre avec le nom chercher
				{
					id=i;break;
				}
	        }
        if(id>=0)
            {
        	System.out.println("Livre recherche est trouve");
        	return dao.getAllMateriel().get(id);
            }
        else {
        	System.out.println("Livre recherche est introuvable");
        	return null;
        }
    }
    
}
