
package com.ensa.gi4.DAO;

import com.ensa.gi4.modele.Chaise;
import com.ensa.gi4.modele.Livre;
import com.ensa.gi4.modele.Materiel;
import com.ensa.gi4.service.api.GestionMaterielService;
import com.ensa.gi4.service.impl.GestionMaterielServiceImpl;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Repository("materielDAO")
@Scope("prototype")
public class MaterielDAO {
    
    //la liste des materiaux joue le rôle de la BD
    private java.util.List<Materiel> AllMateriel = new java.util.ArrayList<>();

    public MaterielDAO()
    {
        //initialisation de la liste materiaux pour les tests
        Chaise chaise1 = new Chaise();
        chaise1.setName("chaise Initiale");
        AllMateriel.add(chaise1);
        Livre livre1 = new Livre();
        livre1.setName("livre Initiale");
        AllMateriel.add(livre1);
    }

    public void listerMateriel() {

        for(Materiel instance : AllMateriel)
        {
            System.out.println(instance.getName());
        }
    }

    public List<Materiel> getAllMateriel() {
        return AllMateriel;
    }
    
    
    
     public void ajouterNouveauMateriel(Materiel materiel) {
         AllMateriel.add(materiel);
     }
     
     public void supprimerMateriel(int id)
     {
         AllMateriel.remove(id);
     }
     
     public void modifierMateriel(int id, String nom)
     {
         AllMateriel.get(id).setName(nom);
     }
     
    public GestionMaterielService getMaterielDao() {
        return new GestionMaterielServiceImpl(this);
    }

}
