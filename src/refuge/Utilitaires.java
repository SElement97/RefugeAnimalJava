package refuge;

import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class Utilitaires {

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


    public static void afficherAnimauxDisponibles(ArrayList<Animal> animaux) {
        System.out.println("\nAnimaux disponibles à l'adoption :");
        for (Animal a : animaux) {
            if (a.isDisponiblePourAdoption()) {
                System.out.println(a.getClass().getSimpleName() + " :\n" + a + "\n");
            }
        }
    }


    public static void afficherTousLesAnimaux(ArrayList<Animal> animaux) {
        System.out.println("\nTous les animaux du refuge :");
        for (Animal a : animaux) {
            System.out.println(a.getClass().getSimpleName() + " :\n" + a + "\n");
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
            System.out.println(c);
        }
    }

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
}
