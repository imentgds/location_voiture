package location_voiture;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class voiturImp implements imple {
    private HashMap<String, voiture> voitures;

    public voiturImp() {
        voitures = new HashMap<>();
    }

    @Override
    public void ajouter(String immatriculation, String modele, String marque, boolean disponible) throws RemoteException {
        voiture voi = new voiture(modele, marque, immatriculation, disponible);
        voitures.put(immatriculation, voi);
        System.out.println("Voiture ajoutée : " + voi);
    }

    @Override
    public boolean reserver(String immatriculation, String dateDebut, String dateFin) throws RemoteException {
        voiture voi = voitures.get(immatriculation);
        if (voi != null && voi.isDisponible()) {
            voi.setDisponible(false); // La voiture est réservée
            System.out.println("Voiture réservée : " + voi);
            return true;
        }
        return false;
    }

    @Override
    public List<String> consulterVoituresDisponibles() throws RemoteException {
        List<String> disponibles = new ArrayList<>();
        for (voiture voi : voitures.values()) {
            if (voi.isDisponible()) {
                disponibles.add(voi.toString());
            }
        }
        return disponibles;
    }
}
