package location_voiture;


import java.io.Serializable;

public class voiture implements Serializable {
    private String modele;
    private String marque;
    private boolean disponible;
    private String immatriculation;

    public voiture(String modele, String marque, String mat,  boolean dispo) {
        this.modele = modele;
        this.marque = marque;
        this.immatriculation = mat;
        this.disponible = dispo;
    }

    public String getModele() {
        return modele;
    }

    public String getMarque() {
        return marque;
    }

    public String getImmatriculation() {
        return immatriculation;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public String toString() {
        return "Voiture [modele=" + modele + ", marque=" + marque + ", immatriculation=" + immatriculation + ", disponible=" + disponible + "]";
    }
}

