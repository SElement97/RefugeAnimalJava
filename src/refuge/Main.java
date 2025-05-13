package refuge;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Création des listes vides
        ArrayList<Animal> animaux = Utilitaires.chargerListe("data/animaux.dat");
        ArrayList<FormulaireAdoption> adoptions = Utilitaires.chargerListe("data/adoptions.dat");
        ArrayList<SoinsVeterinaires> soinsVeterinaires = Utilitaires.chargerListe("data/soins.dat");
        ArrayList<CliniqueVeterinaire> cliniques = Utilitaires.chargerListe("data/cliniques.dat");

        Utilitaires.ajouterAnimauxDeBase(animaux);
        Utilitaires.ajouterAdoptionsDeBase(adoptions, animaux);
        Utilitaires.ajouterSoinsVeterinairesDeBase(soinsVeterinaires, animaux);
        Utilitaires.ajouterCliniquesDeBase(cliniques);

        int choix;

        // === MENU PRINCIPAL ===
        do {
            System.out.println("\n--- MENU REFUGE ANIMAL ---");
            System.out.println("1. Afficher les animaux disponibles");
            System.out.println("2. Afficher tous les animaux");
            System.out.println("3. Afficher les adoptions");
            System.out.println("4. Afficher les soins vétérinaires");
            System.out.println("5. Afficher les cliniques");
            System.out.println("6. Gestion d’un animal");
            System.out.println("7. Gestion des adoptions");
            System.out.println("8. Quitter");
            System.out.print("Choix : ");

            try {
                choix = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Erreur : veuillez entrer un chiffre valide.");
                scanner.nextLine();
                choix = -1;
            }

            switch (choix) {
                case 1 -> Utilitaires.afficherAnimauxDisponibles(animaux);
                case 2 -> Utilitaires.afficherTousLesAnimaux(animaux);
                case 3 -> Utilitaires.afficherAdoptions(adoptions);
                case 4 -> {
                    try {
                        Utilitaires.afficherSoinsVeterinaires(soinsVeterinaires);
                    } catch (Exception e) {
                        System.out.println("Erreur d’affichage : " + e.getMessage());
                    }
                }
                case 5 -> {
                    try {
                        Utilitaires.afficherCliniques(cliniques);
                    } catch (Exception e) {
                        System.out.println("Erreur d’affichage : " + e.getMessage());
                    }
                }
                case 6 -> afficherMenuGestionAnimaux(animaux, scanner);
                case 7 -> afficherMenuGestionAdoptions(adoptions, animaux, scanner);
                case 8 -> {
                    // Sauvegarde avant de quitter
                    Utilitaires.sauvegarderListe(animaux, "data/animaux.dat");
                    Utilitaires.sauvegarderListe(adoptions, "data/adoptions.dat");
                    Utilitaires.sauvegarderListe(soinsVeterinaires, "data/soins.dat");
                    Utilitaires.sauvegarderListe(cliniques, "data/cliniques.dat");
                    System.out.println("Données sauvegardées avec succès. Bonne journée !");
                }
                default -> System.out.println("Choix invalide. Entrez un chiffre entre 1 et 8.");
            }
        } while (choix != 8);

        scanner.close();
    }

    private static void afficherMenuGestionAnimaux(ArrayList<Animal> animaux, Scanner scanner) {
        int choixAnimal;
        do {
            System.out.println("\n-- Gestion d’un animal --");
            System.out.println("1. Ajouter un animal");
            System.out.println("2. Modifier un animal");
            System.out.println("3. Retour au menu principal");
            System.out.print("Choix : ");
            try {
                choixAnimal = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Erreur : entrez un chiffre valide.");
                scanner.nextLine();
                choixAnimal = -1;
            }

            switch (choixAnimal) {
                case 1 -> Utilitaires.ajouterAnimal(animaux, scanner);
                case 2 -> Utilitaires.modifierAnimal(animaux, scanner);
                case 3 -> System.out.println("Retour au menu principal.");
                default -> System.out.println("Choix invalide.");
            }
        } while (choixAnimal != 3);
    }

    private static void afficherMenuGestionAdoptions(ArrayList<FormulaireAdoption> adoptions, ArrayList<Animal> animaux, Scanner scanner) {
        int choixAdoption;
        do {
            System.out.println("\n-- Gestion des adoptions --");
            System.out.println("1. Ajouter une adoption");
            System.out.println("2. Retourner un animal au refuge");
            System.out.println("3. Supprimer une adoption");
            System.out.println("4. Retour au menu principal");
            System.out.print("Choix : ");
            try {
                choixAdoption = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Erreur : entrez un chiffre valide.");
                scanner.nextLine();
                choixAdoption = -1;
            }

            switch (choixAdoption) {
                case 1 -> Utilitaires.ajouterAdoption(adoptions, animaux, scanner);
                case 2 -> Utilitaires.retournerAnimal(adoptions, scanner);
                case 3 -> Utilitaires.supprimerAdoption(adoptions, scanner);
                case 4 -> System.out.println("Retour au menu principal.");
                default -> System.out.println("Choix invalide.");
            }
        } while (choixAdoption != 4);
    }
}
