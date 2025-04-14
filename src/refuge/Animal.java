package refuge;

import java.io.Serializable;

public class Animal implements Serializable {
    private String nom;
    private String espece;
    private int age;
    private String etatSante;
    private boolean disponiblePourAdoption; // Nouvel attribut

    // Constructeur par défaut
    public Animal() {
        nom = "";
        espece = "";
        age = 0;
        etatSante = "";
        disponiblePourAdoption = true; // Par défaut, l’animal est adoptable
    }

    // Constructeur avec paramètres
    public Animal(String unNom, String uneEspece, int unAge, String unEtatSante) {
        nom = unNom;
        espece = uneEspece;
        age = unAge;
        etatSante = unEtatSante;
        disponiblePourAdoption = true; // Par défaut, l’animal est adoptable
    }

    // Getters
    public String getNom() {
        return nom;
    }

    public String getEspece() {
        return espece;
    }

    public int getAge() {
        return age;
    }

    public String getEtatSante() {
        return etatSante;
    }

    // Ajout du guetter
    public boolean isDisponiblePourAdoption() {
        return disponiblePourAdoption;
    }

    // Ajout du setter
    public void setDisponiblePourAdoption(boolean disponible) {
        disponiblePourAdoption = disponible;
    }

    public void resetEtat() {
        etatSante = "Bon";
    }

    @Override
    public String toString() {
        return "Nom : " + nom + "\n" +
                "Espèce : " + espece + "\n" +
                "Âge : " + age + " ans\n" +
                "Santé : " + etatSante + "\n" +
                "Disponible à l'adoption : " + (disponiblePourAdoption ? "Oui" : "Non");
    }
}
