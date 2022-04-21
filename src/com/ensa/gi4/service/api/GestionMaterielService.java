package com.ensa.gi4.service.api;

import com.ensa.gi4.modele.Materiel;
import org.springframework.stereotype.Service;


public interface GestionMaterielService {
    void init();
    void listerMateriel();
    void ajouterNouveauMateriel(Materiel materiel);
    void supprimerMateriel();
    void modifierMateriel();
    Materiel chercherMateriel();
}
