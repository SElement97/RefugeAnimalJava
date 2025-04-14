package refuge;

import java.io.Serializable;

public class SoinsVeterinaires implements Serializable {
    private Animal animal;
    private String descriptionSoins;

    // Constructeur avec paramètres
    public SoinsVeterinaires(Animal unAnimal, String uneDescriptionSoins) {
        animal = unAnimal;
        descriptionSoins = uneDescriptionSoins;
    }

    // Constructeur par défaut
    public SoinsVeterinaires() {
        animal = new Animal();  // Créer un animal constructeur par défaut
        descriptionSoins = "Aucun soin ";
    }

    // Getters
    public Animal getAnimal() {
        return animal;
    }

    public String getDescriptionSoins() {
        return descriptionSoins;
    }

    // toString
    @Override
    public String toString() {
        return "Soins pour " + animal.toString() + ": " + descriptionSoins;
    }
}

