package refuge;

import java.io.Serializable;

/**
 * Représente un animal dans le refuge.
 * Contient les propriétés de base : nom, espèce, âge, état de santé,
 * et une indication s’il est disponible pour adoption.
 * Cette classe est destinée à être héritée par les classes Chien, Chat et AnimalExotique.
 */
public class Animal implements Serializable {

    private String nom;
    private String espece;
    private int age;
    private String etatSante;
    private boolean disponiblePourAdoption;

    // Constructeurs

    public Animal() {
        nom = "";
        espece = "";
        age = 0;
        etatSante = "";
        disponiblePourAdoption = true;
    }

    public Animal(String unNom, String uneEspece, int unAge, String unEtatSante) {
        nom = unNom;
        espece = uneEspece;
        age = unAge;
        etatSante = unEtatSante;
        disponiblePourAdoption = true;
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

    public boolean isDisponiblePourAdoption() {
        return disponiblePourAdoption;
    }

    // Setters

    public void setNom(String unNom) {
        nom = unNom;
    }

    public void setAge(int unAge) {
        age = unAge;
    }

    public void setDisponiblePourAdoption(boolean disponible) {
        disponiblePourAdoption = disponible;
    }

    // Méthodes

    public void resetEtat() {
        etatSante = "Bon";
    }
    // toString
    @Override
    public String toString() {
        return "Nom : " + nom + "\n" +
                "Espèce : " + espece + "\n" +
                "Âge : " + age + " ans\n" +
                "Santé : " + etatSante + "\n" +
                "Disponible à l'adoption : " + (disponiblePourAdoption ? "Oui" : "Non");
    }
}
