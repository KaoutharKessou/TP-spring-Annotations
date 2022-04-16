package com.ensa.gi4.service.impl;

import com.ensa.gi4.DAO.MaterielDAO;
import com.ensa.gi4.listeners.EventType;
import com.ensa.gi4.listeners.MyEvent;
import com.ensa.gi4.modele.Livre;
import com.ensa.gi4.modele.Materiel;
import com.ensa.gi4.service.api.GestionChaiseService;
import com.ensa.gi4.service.api.GestionLivreService;
import com.ensa.gi4.service.api.GestionMaterielService;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;


@Component
public class GestionMaterielServiceImpl implements GestionMaterielService {
    
 // bd goes here
    @Autowired 
    private MaterielDAO dao;
    private GestionLivreService LivreService ;
    private GestionChaiseService ChaiseService ;
    


    public GestionMaterielServiceImpl(@Qualifier("materielDAO") MaterielDAO dao){
        this.dao = dao;
    }
    public void setGestionLivreService(GestionLivreService LivreService) {
        this.LivreService = LivreService;
    }
    public void setGestionChaiseService(GestionChaiseService ChaiseService) {
        this.ChaiseService = ChaiseService;
    }
    
    @Override
    public void init() {
        System.out.println("Service de gestion de matériel : \n Veuillez suivre les consignes pour gerer vos materielss : \n");
    }

    @Override
    public void listerMateriel() {
        System.out.println("La liste du matériel est :\n ");
        dao.listerMateriel();
    }

    @Override
    public void ajouterNouveauMateriel(Materiel materiel) {
        System.out.println("Vous avez le choix entre livre et chaise:\n Si vous voulez ajouter une chaise taper (a) \n Si vous voulez ajouter un livre taper (b)");
        Scanner scanner = new Scanner(System.in);
        String choix = scanner.next();
        
        if("b".equals(choix))
        {
            LivreService = new GestionLivreServiceImpl(dao);
            LivreService.ajouterNouveauMateriel(materiel);
    
       
        }
        else if("a".equals(choix))
        {
            ChaiseService = new GestionChaiseServiceImpl(dao);
            ChaiseService.ajouterNouveauMateriel(materiel);
        }
        else 
            System.out.println("Vous avez effectuer un choix incorrect");
    }

    @Override
    public void supprimerMateriel() {
        System.out.println("Vous avez le choix entre livre et chaise:\n Si vous voulez supprimer une chaise taper (a) \n Si vous voulez supprimer un livre taper (b)");
        Scanner scanner = new Scanner(System.in);
        String choix = scanner.next();
        
        if("b".equals(choix))
        {
            LivreService = new GestionLivreServiceImpl(dao);
            LivreService.supprimerMateriel();
        }
        else if("a".equals(choix))
        {
            ChaiseService = new GestionChaiseServiceImpl(dao);
            ChaiseService.supprimerMateriel();
        }
        else 
            System.out.println("Vous avez effectuer un choix incorrect");
    }

    @Override
    public void modifierMateriel() {
        System.out.println("Vous avez le choix entre livre et chaise:\n Si vous voulez modifier une chaise taper (a) \n Si vous voulez modifier un livre taper (b)");
        Scanner scanner = new Scanner(System.in);
        String choix = scanner.next();
        
        if("b".equals(choix))
        {
            LivreService = new GestionLivreServiceImpl(dao);
            LivreService.modifierMateriel();
        
        }
        else if("a".equals(choix))
        {
            ChaiseService = new GestionChaiseServiceImpl(dao);
            ChaiseService.modifierMateriel();
        }
        else 
            System.out.println("Vous avez effectuer un choix incorrect");
    }

    @Override
    public Materiel chercherMateriel() {
        System.out.println("Vous avez le choix entre livre et chaise:\n Si vous voulez chercher une chaise taper (a) \n Si vous voulez chercher un livre taper (b)");
        Scanner scanner = new Scanner(System.in);
        String choix = scanner.next();
        
        if("b".equals(choix))
        {
            LivreService = new GestionLivreServiceImpl(dao);
           return  LivreService.chercherMateriel();
        }
        else if("a".equals(choix))
        {
            ChaiseService = new GestionChaiseServiceImpl(dao);
            return ChaiseService.chercherMateriel();
        }
        else 
            return null;
    }
}
