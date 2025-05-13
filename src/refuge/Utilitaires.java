package refuge;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.*;

public class Utilitaires {

    // Données de base

    public static void ajouterAnimauxDeBase(ArrayList<Animal> animaux) {
        animaux.add(new Chien("Rex", 3, "Bonne santé", "Labrador", true, "À jour"));
        animaux.add(new Chat("Milo", 2, "Vacciné", "Poil court", true, "Affectueux"));
        animaux.add(new Chien("Kiki", 5, "Besoin de traitement", "Pitbull", false, "Blessure à la patte"));
        animaux.add(new Chat("Bella", 4, "Stérilisé", "Poil long", true, "Timide"));
        animaux.add(new AnimalExotique("Léo", 1, "Bonne santé", "Brésil", 3, "Lumière chauffante"));
        animaux.add(new Chien("Rocky", 2, "Bonne santé", "Husky", true, "Vacciné"));
        animaux.add(new Chat("Luna", 3, "Bonne santé", "Poil moyen", true, "Joueur"));
        animaux.add(new AnimalExotique("Oscar", 1, "Suivi vétérinaire requis", "Australie", 2, "Alimentation spéciale"));
        animaux.add(new Chat("Shadow", 4, "Bonne santé", "Poil court", false, "Indépendant"));
    }

    public static void ajouterAdoptionsDeBase(ArrayList<FormulaireAdoption> adoptions, ArrayList<Animal> animaux) {
        adoptions.add(new FormulaireAdoption(animaux.get(0), "Alice"));
        adoptions.get(0).finaliserAdoption();

        adoptions.add(new FormulaireAdoption(animaux.get(2), "Bob"));
        adoptions.get(1).finaliserAdoption();

        adoptions.add(new FormulaireAdoption(animaux.get(3), "Charlie"));
        adoptions.get(2).finaliserAdoption();

        adoptions.add(new FormulaireAdoption(animaux.get(4), "David"));
        adoptions.get(3).finaliserAdoption();

        adoptions.add(new FormulaireAdoption(animaux.get(1), "Eve")); // Non approuvée
    }

    public static void ajouterSoinsVeterinairesDeBase(ArrayList<SoinsVeterinaires> soins, ArrayList<Animal> animaux) {
        soins.add(new SoinsVeterinaires(animaux.get(0), "Vaccination annuelle"));
        soins.add(new SoinsVeterinaires(animaux.get(2), "Traitement pour infection"));
        soins.add(new SoinsVeterinaires(animaux.get(3), "Consultation générale"));
        soins.add(new SoinsVeterinaires(animaux.get(4), "Soins de bec"));
        soins.add(new SoinsVeterinaires(animaux.get(1), "Vérification post-opératoire"));
    }

    public static void ajouterCliniquesDeBase(ArrayList<CliniqueVeterinaire> cliniques) {
        cliniques.add(new CliniqueVeterinaire());
        cliniques.add(new CliniqueVeterinaire("Clinique Vétérinaire Gaspé", "45 Rue de la Reine", "514-123-4567", refuge.enums.TypeDeSoin.CHIRURGIE, new ArrayList<>(List.of("Dr. Moreau", "Dr. Pelletier"))));
        cliniques.add(new CliniqueVeterinaire("Clinique Vétérinaire Rimouski", "28 Boulevard Arthur-Buie", "450-555-7890", refuge.enums.TypeDeSoin.VACCINATION, new ArrayList<>(List.of("Dr. Tremblay", "Dr. Gagnon"))));
        cliniques.add(new CliniqueVeterinaire("Clinique Vétérinaire Chandler", "12 Rte 132", "438-987-6543", refuge.enums.TypeDeSoin.URGENCE, new ArrayList<>(List.of("Dr. Laroche", "Dr. Dufresne"))));
        cliniques.add(new CliniqueVeterinaire("Clinique Vétérinaire Matane", "99 Avenue Notre-Dame", "514-777-1234", refuge.enums.TypeDeSoin.CONSULTATION_GENERALE, new ArrayList<>(List.of("Dr. Lévesque", "Dr. Fortin"))));
    }

    // Affichage

    public static void afficherAnimauxDisponibles(ArrayList<Animal> animaux) {
        System.out.println("\nAnimaux disponibles à l'adoption :");
        for (Animal a : animaux) {
            if (a.isDisponiblePourAdoption()) {
                System.out.println(a + "\n");
            }
        }
    }

    public static void afficherTousLesAnimaux(ArrayList<Animal> animaux) {
        System.out.println("\nTous les animaux du refuge :");
        for (Animal a : animaux) {
            System.out.println(a + "\n");
        }
    }

    public static void afficherAdoptions(ArrayList<FormulaireAdoption> adoptions) {
        System.out.println("\nAdoptions enregistrées :");
        for (FormulaireAdoption a : adoptions) {
            System.out.println(a);
        }
    }

    public static void afficherSoinsVeterinaires(ArrayList<SoinsVeterinaires> soins) {
        System.out.println("\nSoins vétérinaires enregistrés :");
        for (SoinsVeterinaires s : soins) {
            System.out.println(s.getAnimal().getNom() + " - " + s.getDescriptionSoins());
        }
    }

    public static void afficherCliniques(ArrayList<CliniqueVeterinaire> cliniques) {
        System.out.println("\nCliniques vétérinaires disponibles :");
        for (CliniqueVeterinaire c : cliniques) {
            System.out.println(c.getNomClinique() + " - " + c.getTypeDeSoin());
        }
    }

    // Sauvegarde

    public static <T> void sauvegarderListe(ArrayList<T> liste, String cheminFichier) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(cheminFichier))) {
            oos.writeObject(liste);
        } catch (IOException e) {
            System.out.println("Erreur pendant la sauvegarde dans " + cheminFichier + " : " + e.getMessage());
        }
    }

    public static <T> ArrayList<T> chargerListe(String cheminFichier) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(cheminFichier))) {
            return (ArrayList<T>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Fichier introuvable ou vide : " + cheminFichier);
            return new ArrayList<>();
        }
    }

    //  Fonctions

    public static void ajouterAnimal(ArrayList<Animal> animaux, Scanner scanner) {
        System.out.println("\nAjout d'un nouvel animal :");
        System.out.print("Nom : ");
        String nom = scanner.nextLine();
        System.out.print("Espèce : ");
        String espece = scanner.nextLine();

        int age = 0;
        try {
            System.out.print("Âge : ");
            age = scanner.nextInt();
            scanner.nextLine();
        } catch (Exception e) {
            System.out.println("Erreur : l'âge doit être un nombre entier.");
            scanner.nextLine();
            return;
        }

        System.out.print("État de santé : ");
        String etatSante = scanner.nextLine();
        animaux.add(new Animal(nom, espece, age, etatSante));
        System.out.println("Animal ajouté avec succès !");
    }

    public static void modifierAnimal(ArrayList<Animal> animaux, Scanner scanner) {
        System.out.println("\n--- Modifier un animal ---");

        if (animaux.isEmpty()) {
            System.out.println("Aucun animal à modifier.");
            return;
        }

        int choix = afficherListeEtChoisir(animaux, scanner, "--- Modifier quel animal ?");
        if (choix < 0 || choix >= animaux.size()) {
            System.out.println("Numéro invalide.");
            return;
        }

        Animal aModifier = animaux.get(choix);

        System.out.print("Nouveau nom pour l’animal (actuel : " + aModifier.getNom() + ") : ");
        String nouveauNom = scanner.nextLine();
        aModifier.setNom(nouveauNom);

        System.out.print("Nouvel âge pour l’animal (actuel : " + aModifier.getAge() + ") : ");
        try {
            int nouvelAge = scanner.nextInt();
            scanner.nextLine();
            if (nouvelAge >= 0) {
                aModifier.setAge(nouvelAge);
                System.out.println("L’animal a été modifié avec succès !");
            } else {
                System.out.println("Âge invalide. Modification annulée.");
            }
        } catch (Exception e) {
            System.out.println("Erreur : vous devez entrer un âge valide.");
            scanner.nextLine();
        }
    }

    public static void ajouterAdoption(ArrayList<FormulaireAdoption> adoptions, ArrayList<Animal> animaux, Scanner scanner) {
        System.out.println("\nAjout d'une adoption :");
        System.out.print("Nom de l'adoptant : ");
        String adoptant = scanner.nextLine();

        ArrayList<Animal> animauxDisponibles = new ArrayList<>();
        for (Animal a : animaux) {
            if (a.isDisponiblePourAdoption()) {
                animauxDisponibles.add(a);
            }
        }

        if (animauxDisponibles.isEmpty()) {
            System.out.println("Aucun animal disponible pour adoption.");
            return;
        }

        for (int i = 0; i < animauxDisponibles.size(); i++) {
            System.out.println((i + 1) + ". " + animauxDisponibles.get(i));
        }

        int indexAdoption = -1;
        try {
            indexAdoption = scanner.nextInt() - 1;
            scanner.nextLine();
        } catch (Exception e) {
            System.out.println("Erreur : vous devez entrer un numéro valide.");
            scanner.nextLine();
            return;
        }

        if (indexAdoption >= 0 && indexAdoption < animauxDisponibles.size()) {
            FormulaireAdoption adoption = new FormulaireAdoption(animauxDisponibles.get(indexAdoption), adoptant);
            adoption.finaliserAdoption();
            adoptions.add(adoption);
            System.out.println("Adoption ajoutée avec succès !");
        } else {
            System.out.println("Adoption impossible.");
        }
    }

    public static void retournerAnimal(ArrayList<FormulaireAdoption> adoptions, Scanner scanner) {
        System.out.println("\n--- Retour d’un animal au refuge ---");

        if (adoptions.isEmpty()) {
            System.out.println("Aucune adoption enregistrée.");
            return;
        }

        int choix = afficherListeEtChoisir(adoptions, scanner, "--- Choisissez l’adoption à retourner :");
        if (choix < 0 || choix >= adoptions.size()) {
            System.out.println("Numéro invalide.");
            return;
        }

        FormulaireAdoption adoption = adoptions.get(choix);

        System.out.print("Raison du retour au refuge : ");
        String raison = scanner.nextLine();

        adoption.refuserAdoption();
        System.out.println("Retour effectué. Raison notée : " + raison);
    }

    public static void supprimerAdoption(ArrayList<FormulaireAdoption> adoptions, Scanner scanner) {
        System.out.println("\n--- Supprimer une adoption ---");

        if (adoptions.isEmpty()) {
            System.out.println("Aucune adoption enregistrée.");
            return;
        }

        for (int i = 0; i < adoptions.size(); i++) {
            System.out.println((i + 1) + ". " + adoptions.get(i).getAdoptant() + " - " + adoptions.get(i).getAnimal().getNom());
        }

        System.out.print("Entrez le numéro de l’adoption à supprimer : ");
        int choix = -1;
        try {
            choix = scanner.nextInt() - 1;
            scanner.nextLine();
        } catch (Exception e) {
            System.out.println("Erreur : entrée invalide.");
            scanner.nextLine();
            return;
        }

        if (choix < 0 || choix >= adoptions.size()) {
            System.out.println("Numéro invalide.");
            return;
        }

        FormulaireAdoption adoption = adoptions.get(choix);
        adoption.refuserAdoption();
        adoptions.remove(choix);

        System.out.println("Adoption supprimée avec succès.");
    }

    // Fonction d’optimisation réutilisée dans plusieurs menus
    public static <T> int afficherListeEtChoisir(ArrayList<T> liste, Scanner scanner, String message) {
        System.out.println("\n" + message);
        for (int i = 0; i < liste.size(); i++) {
            System.out.println((i + 1) + ". " + liste.get(i));
        }
        System.out.print("Votre choix : ");
        int choix = -1;
        try {
            choix = scanner.nextInt() - 1;
            scanner.nextLine();
        } catch (Exception e) {
            System.out.println("Erreur : entrée invalide.");
            scanner.nextLine();
        }
        return choix;
    }
}
