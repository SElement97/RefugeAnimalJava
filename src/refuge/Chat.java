package refuge;

public class Chat extends Animal {
    private String typePelage;
    private boolean sterilise;
    private String comportement;

    // Constructeur par défaut
    public Chat() {
        super();
        typePelage = "";
        sterilise = false;
        comportement = "";
    }

    // Constructeur avec paramètres
    public Chat(String unNom, int unAge, String unEtatSante, String unTypePelage, boolean estSterilise, String unComportement) {
        super(unNom, "refuge.Chat", unAge, unEtatSante);
        typePelage = unTypePelage;
        sterilise = estSterilise;
        comportement = unComportement;
    }

    public String getTypePelage() { return typePelage; }
    public boolean isSterilise() { return sterilise; }
    public String getComportement() { return comportement; }

    public void setTypePelage(String unTypePelage) { typePelage = unTypePelage; }
    public void setSterilise(boolean estSterilise) { sterilise = estSterilise; }
    public void setComportement(String unComportement) { comportement = unComportement; }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Type de pelage : " + typePelage + "\n" +
                "Stérilisé : " + (sterilise ? "Oui" : "Non") + "\n" +
                "Comportement : " + comportement;
    }

}

