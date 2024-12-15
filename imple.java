package location_voiture;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface imple extends Remote {
    boolean reserver(String immatriculation, String dateDebut, String dateFin) throws RemoteException;
    List<String> consulterVoituresDisponibles() throws RemoteException;
    void ajouter(String immatriculation, String modele, String marque, boolean disponible) throws RemoteException;
}
