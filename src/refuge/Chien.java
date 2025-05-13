package refuge;

public class Chien extends Animal {

    private String race;
    private boolean dresse;
    private String statutMedical;

    // Constructeurs

    public Chien() {
        super();
        race = "";
        dresse = false;
        statutMedical = "";
    }

    public Chien(String unNom, int unAge, String unEtatSante,
                 String uneRace, boolean estDresse, String unStatutMedical) {
        super(unNom, "Chien", unAge, unEtatSante);
        race = uneRace;
        dresse = estDresse;
        statutMedical = unStatutMedical;
    }

    // Getters

    public String getRace() {
        return race;
    }

    public boolean isDresse() {
        return dresse;
    }

    public String getStatutMedical() {
        return statutMedical;
    }

    // Setters

    public void setRace(String uneRace) {
        race = uneRace;
    }

    public void setDresse(boolean estDresse) {
        dresse = estDresse;
    }

    public void setStatutMedical(String unStatutMedical) {
        statutMedical = unStatutMedical;
    }

    // toString

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Race : " + race + "\n" +
                "Dressé : " + (dresse ? "Oui" : "Non") + "\n" +
                "Statut médical : " + statutMedical;
    }
}
