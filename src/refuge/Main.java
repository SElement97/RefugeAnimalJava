package refuge;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Animal> animaux = Utilitaires.chargerListe("data/animaux.dat");
        ArrayList<FormulaireAdoption> adoptions = Utilitaires.chargerListe("data/adoptions.dat");
        ArrayList<SoinsVeterinaires> soinsVeterinaires = Utilitaires.chargerListe("data/soins.dat");
        ArrayList<CliniqueVeterinaire> cliniques = Utilitaires.chargerListe("data/cliniques.dat");


        // refuge.Utilitaires
        Utilitaires.ajouterAnimauxDeBase(animaux);
        Utilitaires.ajouterAdoptionsDeBase(adoptions, animaux);
        Utilitaires.ajouterSoinsVeterinairesDeBase(soinsVeterinaires, animaux);
        Utilitaires.ajouterCliniquesDeBase(cliniques);

        // Menu
        int choix;
        do {
            System.out.println("\n--- MENU REFUGE ANIMAL ---");
            System.out.println("1. Afficher les animaux disponibles");
            System.out.println("2. Afficher tous les animaux");
            System.out.println("3. Afficher les adoptions");
            System.out.println("4. Afficher les soins vétérinaires");
            System.out.println("5. Afficher les cliniques");
            System.out.println("6. Ajouter un animal");
            System.out.println("7. Ajouter une adoption");
            System.out.println("8. Quitter");
            System.out.print("Choix : ");
            choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1:
                    Utilitaires.afficherAnimauxDisponibles(animaux);
                    break;
                case 2:
                    Utilitaires.afficherTousLesAnimaux(animaux);
                    break;
                case 3:
                    Utilitaires.afficherAdoptions(adoptions);
                    break;
                case 4:
                    Utilitaires.afficherSoinsVeterinaires(soinsVeterinaires);
                    break;
                case 5:
                    Utilitaires.afficherCliniques(cliniques);
                    break;
                case 6:
                    ajouterAnimal(animaux, scanner);
                    break;
                case 7:
                    ajouterAdoption(adoptions, animaux, scanner);
                    break;
                case 8:
                    Utilitaires.sauvegarderListe(animaux, "data/animaux.dat");
                    Utilitaires.sauvegarderListe(adoptions, "data/adoptions.dat");
                    Utilitaires.sauvegarderListe(soinsVeterinaires, "data/soins.dat");
                    Utilitaires.sauvegarderListe(cliniques, "data/cliniques.dat");

                    System.out.println("Données sauvegardées avec succès. Bonne journée! ");
                    break;
                default:
                    System.out.println("Oups! Choix invalide, assurez-vous de choisir une option entre 1 et 8.");
            }
        } while (choix != 8);

        scanner.close();
    }

    // Ajout nouvel animal
    private static void ajouterAnimal(ArrayList<Animal> animaux, Scanner scanner) {
        System.out.println("\nAjout d'un nouvel animal :");
        System.out.print("Nom : ");
        String nom = scanner.nextLine();
        System.out.print("Espèce : ");
        String espece = scanner.nextLine();
        System.out.print("Âge : ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("État de santé : ");
        String etatSante = scanner.nextLine();
        animaux.add(new Animal(nom, espece, age, etatSante));
        System.out.println("Animal ajouté avec succès !");
    }

    // Ajout d'un adoption
    private static void ajouterAdoption(ArrayList<FormulaireAdoption> adoptions, ArrayList<Animal> animaux, Scanner scanner) {
        System.out.println("\nAjout d'une adoption :");
        System.out.print("Nom de l'adoptant : ");
        String adoptant = scanner.nextLine();

        System.out.println("Choisissez un animal disponible à adopter :");
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

        int indexAdoption = scanner.nextInt() - 1;
        scanner.nextLine();

        if (indexAdoption >= 0 && indexAdoption < animauxDisponibles.size()) {
            FormulaireAdoption adoption = new FormulaireAdoption(animauxDisponibles.get(indexAdoption), adoptant);
            adoption.finaliserAdoption();
            adoptions.add(adoption);
            System.out.println("Adoption ajoutée avec succès !");
        } else {
            System.out.println("Adoption impossible.");
        }
    }
}
