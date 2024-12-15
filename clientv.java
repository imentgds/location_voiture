package location_voiture;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import java.util.Scanner;

public class clientv {

    public static void main(String[] args) {
        try {
            // Connexion au registre RMI
            Registry reg = LocateRegistry.getRegistry("localhost", 1099);
            imple stub = (imple) reg.lookup("imple");

            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("\nMenu :");
                System.out.println("1. Ajouter une voiture");
                System.out.println("2. Réserver une voiture");
                System.out.println("3. Consulter les voitures disponibles");
                System.out.println("4. Quitter");

                System.out.print("Choix : ");
                int choix = scanner.nextInt();
                scanner.nextLine(); // Consommer le saut de ligne

                switch (choix) {
                    case 1: // Ajouter une voiture
                        System.out.print("Immatriculation : ");
                        String immatriculation = scanner.nextLine();
                        System.out.print("Modèle : ");
                        String modele = scanner.nextLine();
                        System.out.print("Marque : ");
                        String marque = scanner.nextLine();
                        System.out.print("Disponible (true/false) : ");
                        boolean disponible = scanner.nextBoolean();
                        scanner.nextLine();

                        stub.ajouter(immatriculation, modele, marque, disponible);
                        System.out.println("Voiture ajoutée avec succès !");
                        break;

                    case 2: // Réserver une voiture
                        System.out.print("Immatriculation : ");
                        String immatriculationReservation = scanner.nextLine();
                        System.out.print("Date début (format YYYY-MM-DD) : ");
                        String dateDebut = scanner.nextLine();
                        System.out.print("Date fin (format YYYY-MM-DD) : ");
                        String dateFin = scanner.nextLine();

                        boolean success = stub.reserver(immatriculationReservation, dateDebut, dateFin);
                        if (success) {
                            System.out.println("Voiture réservée avec succès !");
                        } else {
                            System.out.println("Voiture non disponible ou inexistante.");
                        }
                        break;

                    case 3: // Consulter les voitures disponibles
                        List<String> voituresDisponibles = stub.consulterVoituresDisponibles();
                        if (voituresDisponibles.isEmpty()) {
                            System.out.println("Aucune voiture disponible.");
                        } else {
                            System.out.println("Voitures disponibles :");
                            for (String voiture : voituresDisponibles) {
                                System.out.println(voiture);
                            }
                        }
                        break;

                    case 4: // Quitter
                        System.out.println("Au revoir !");
                        scanner.close();
                        System.exit(0);

                    default:
                        System.out.println("Choix invalide !");
                }
            }
        } catch (Exception e) {
            System.err.println("Erreur côté client : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
