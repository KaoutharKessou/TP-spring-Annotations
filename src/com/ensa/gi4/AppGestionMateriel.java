package com.ensa.gi4;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import com.ensa.gi4.listeners.ApplicationPublisher;
import com.ensa.gi4.listeners.EventType;
import com.ensa.gi4.listeners.MyEvent;
import com.ensa.gi4.modele.Livre;


import com.ensa.gi4.controller.GestionMaterielController;
import java.lang.annotation.Annotation;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@SuppressWarnings("all")
@Configuration
@ComponentScan(basePackages = "com.ensa.gi4")
public class AppGestionMateriel {
    private static final AnnotationConfigApplicationContext APPLICATION_CONTEXT;
     //private static final XmlBeanFactory FACTORY;

    static { // bloc static pour initilialisation
        APPLICATION_CONTEXT = new AnnotationConfigApplicationContext(AppGestionMateriel.class);
                
        //new ClassPathXmlApplicationContext("/beans/app-context.xml");
       // ClassPathXmlApplicationContext("beans/*-app-context.xml/") : si je veux inserer tous les implementations; 
        //FACTORY = new XmlBeanFactory (new ClassPathResource("/beans/dao-context.xml"));
    }

    public static void main(String[] args) {
        final GestionMaterielController gestionMaterielController = APPLICATION_CONTEXT.getBean(GestionMaterielController.class);
        final ApplicationPublisher publisher = APPLICATION_CONTEXT.getBean(ApplicationPublisher.class);
        publisher.publish(new MyEvent<>(new Livre(), EventType.ADD));
        while (true) { // pour que l'appliation tourne jusqu'à la demande de l'utilisateur de l'arrêter
            gestionMaterielController.afficherMenu();
        }

    }
}
