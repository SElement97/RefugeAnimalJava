package refuge;

import refuge.enums.TypeDeSoin;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.Serializable;

public class CliniqueVeterinaire implements Serializable {
    private String nomClinique;
    private String adresse;
    private String telephone;
    private TypeDeSoin typeDeSoin;
    private ArrayList<String> nomsVeterinaires; // Min 2, Max 10

    // Constructeur par défaut avec 2 vétérinaires
    public CliniqueVeterinaire() {
        nomClinique = "Clinique du Refuge";
        adresse = "123 Rue des Animaux, Ville";
        telephone = "555-1234";
        typeDeSoin = TypeDeSoin.CONSULTATION_GENERALE; // Valeur par défaut

        // Ajout automatique de 2 vétérinaires seulement
        nomsVeterinaires = new ArrayList<>(Arrays.asList("Dr. Dupont", "Dr. Lefebvre"));
    }

    // Constructeur avec paramètres
    public CliniqueVeterinaire(String unNomClinique, String uneAdresse, String unTelephone, TypeDeSoin unTypeDeSoin, ArrayList<String> desVeterinaires) {
        nomClinique = unNomClinique;
        adresse = uneAdresse;
        telephone = unTelephone;
        typeDeSoin = unTypeDeSoin;

        // Vérification de la liste
        if (desVeterinaires.size() >= 2 && desVeterinaires.size() <= 10) {
            nomsVeterinaires = desVeterinaires;
        } else {
            nomsVeterinaires = new ArrayList<>(Arrays.asList("Dr. Dupont", "Dr. Lefebvre"));
            System.out.println("Erreur : Une clinique doit avoir entre 2 et 10 vétérinaires. Liste par défaut utilisée.");
        }
    }

    // Getters
    public String getNomClinique() { return nomClinique; }
    public String getAdresse() { return adresse; }
    public String getTelephone() { return telephone; }
    public TypeDeSoin getTypeDeSoin() { return typeDeSoin; }
    public ArrayList<String> getNomsVeterinaires() { return nomsVeterinaires; }

    // Setters
    public void setNomClinique(String unNomClinique) { nomClinique = unNomClinique; }
    public void setAdresse(String uneAdresse) { adresse = uneAdresse; }
    public void setTelephone(String unTelephone) { telephone = unTelephone; }
    public void setTypeDeSoin(TypeDeSoin unTypeDeSoin) { typeDeSoin = unTypeDeSoin; }

    // Ajouter un vétérinaire
    public void ajouterVeterinaire(String nomVeterinaire) {
        if (nomsVeterinaires.size() < 10) {
            nomsVeterinaires.add(nomVeterinaire);
        } else {
            System.out.println("Impossible d'ajouter un vétérinaire, la limite de dix est atteinte.");
        }
    }

    public void supprimerVeterinaire(String nomVeterinaire) {
        if (nomsVeterinaires.size() > 2) {
            nomsVeterinaires.remove(nomVeterinaire);
        } else {
            System.out.println("Impossible de supprimer, seulement deux vétérinaires seulement.");
        }
    }

    @Override
    public String toString() {
        return "Clinique Vétérinaire: " + nomClinique + ", Adresse: " + adresse + ", Téléphone: " + telephone +
                ", Type de soin: " + typeDeSoin + ", Vétérinaires: " + nomsVeterinaires;
    }


}
