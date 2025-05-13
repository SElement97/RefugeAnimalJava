package refuge;

import java.io.Serializable;

public class SoinsVeterinaires implements Serializable {

    private Animal animal;
    private String descriptionSoins;

    // Constructeurs

    public SoinsVeterinaires(Animal unAnimal, String uneDescriptionSoins) {
        animal = unAnimal;
        descriptionSoins = uneDescriptionSoins;
    }

    public SoinsVeterinaires() {
        animal = new Animal();
        descriptionSoins = "Aucun soin";
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
