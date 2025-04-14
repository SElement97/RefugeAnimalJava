package refuge;

import java.io.Serializable;

public class FormulaireAdoption implements Serializable {
    private Animal animal;
    private String adoptant;
    private boolean adoptionApprouvee;

    // Constructeur par défaut
    public FormulaireAdoption() {
        animal = null;
        adoptant = "";
        adoptionApprouvee = false;
    }

    // Constructeur avec paramètres
    public FormulaireAdoption(Animal unAnimal, String unAdoptant) {
        animal = unAnimal;
        adoptant = unAdoptant;
        adoptionApprouvee = false;
    }

    public Animal getAnimal() {
        return animal;
    }

    public String getAdoptant() {
        return adoptant;
    }

    public boolean isAdoptionApprouvee() {
        return adoptionApprouvee;
    }

    // Approuver l'adoption
    public void finaliserAdoption() {
        if (animal != null) {
            adoptionApprouvee = true;
            animal.setDisponiblePourAdoption(false); // L’animal n'est plus disponible
        }
    }

    // Refuser l'adoption
    public void refuserAdoption() {
        adoptionApprouvee = false;
        if (animal != null) {
            animal.setDisponiblePourAdoption(true);
            animal.resetEtat(); // Remettre l’état de santé à "Bon" si nécessaire
            System.out.println("Adoption refusée. " + animal.getNom() + " est toujours disponible.");
        }
    }

    @Override
    public String toString() {
        String adoptionStatus = adoptionApprouvee ? "Oui" : "Non";
        return "Adoptant: " + adoptant + ", " + animal.toString() + ", Adoption approuvée: " + adoptionStatus;
    }
}
