package refuge;

public class AnimalExotique extends Animal {

    private String paysOrigine;
    private int niveauSoinsRequis;
    private String besoinParticulier;

    // Constructeur par défaut
    public AnimalExotique() {
        super();
        paysOrigine = "";
        niveauSoinsRequis = 1;
        besoinParticulier = "Aucun besoin particulier";
    }

    // Constructeur avec paramètres
    public AnimalExotique(String unNom, int unAge, String unEtatSante,
                          String unPaysOrigine, int unNiveauSoins, String unBesoinParticulier) {
        super(unNom, "Exotique", unAge, unEtatSante);
        paysOrigine = unPaysOrigine;
        niveauSoinsRequis = unNiveauSoins;
        besoinParticulier = unBesoinParticulier;
    }

    // Getters
    public String getPaysOrigine() {
        return paysOrigine;
    }

    public int getNiveauSoinsRequis() {
        return niveauSoinsRequis;
    }

    public String getBesoinParticulier() {
        return besoinParticulier;
    }

    // Setters
    public void setPaysOrigine(String unPaysOrigine) {
        paysOrigine = unPaysOrigine;
    }

    public void setNiveauSoinsRequis(int unNiveauSoins) {
        niveauSoinsRequis = unNiveauSoins;
    }

    public void setBesoinParticulier(String unBesoinParticulier) {
        besoinParticulier = unBesoinParticulier;
    }

    // toString()
    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Pays d'origine : " + paysOrigine + "\n" +
                "Niveau de soins requis : " + niveauSoinsRequis + "\n" +
                "Besoin particulier : " + besoinParticulier;
    }
}
