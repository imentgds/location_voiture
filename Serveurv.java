package location_voiture;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Serveurv {

    public static void main(String[] args) {
        try {
            // Définir l'adresse du serveur
            System.setProperty("java.rmi.server.hostname", "127.0.0.1");

            // Créer une instance de l'implémentation
            voiturImp obj = new voiturImp();

            // Exporter l'objet
            imple stub = (imple) UnicastRemoteObject.exportObject(obj, 0);

            // Créer le registre et enregistrer le stub
            Registry reg = LocateRegistry.createRegistry(1099);
            reg.rebind("imple", stub);

            System.out.println("Serveur prêt !");
        } catch (Exception e) {
            System.err.println("Erreur sur le serveur : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
