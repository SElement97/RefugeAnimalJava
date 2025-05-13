package refuge;

import java.io.Serializable;

/**
 * Gère une demande d’adoption pour un animal.
 * Contient les informations de l’adoptant, l’animal concerné, et le statut de l’adoption (approuvée ou non).
 * Permet d'accepter ou refuser une adoption.
 */
public class FormulaireAdoption implements Serializable {

    private Animal animal;
    private String adoptant;
    private boolean adoptionApprouvee;

    // Constructeurs

    public FormulaireAdoption() {
        animal = null;
        adoptant = "";
        adoptionApprouvee = false;
    }

    public FormulaireAdoption(Animal unAnimal, String unAdoptant) {
        animal = unAnimal;
        adoptant = unAdoptant;
        adoptionApprouvee = false;
    }

    // Getters

    public Animal getAnimal() {
        return animal;
    }

    public String getAdoptant() {
        return adoptant;
    }

    public boolean isAdoptionApprouvee() {
        return adoptionApprouvee;
    }


    public void finaliserAdoption() {
        if (animal != null) {
            adoptionApprouvee = true;
            animal.setDisponiblePourAdoption(false);
        }
    }

    public void refuserAdoption() {
        adoptionApprouvee = false;
        if (animal != null) {
            animal.setDisponiblePourAdoption(true);
            animal.resetEtat();
            System.out.println("Adoption refusée. " + animal.getNom() + " est toujours disponible.");
        }
    }

    // toString
    @Override
    public String toString() {
        String adoptionStatus = adoptionApprouvee ? "Oui" : "Non";
        return "Adoptant: " + adoptant + ", " + animal.toString() +
                ", Adoption approuvée: " + adoptionStatus;
    }
}
