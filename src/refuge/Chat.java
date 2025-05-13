package refuge;

public class Chat extends Animal {

    private String typePelage;
    private boolean sterilise;
    private String comportement;

    // Constructeurs

    public Chat() {
        super();
        typePelage = "";
        sterilise = false;
        comportement = "";
    }

    public Chat(String unNom, int unAge, String unEtatSante,
                String unTypePelage, boolean estSterilise, String unComportement) {
        super(unNom, "Chat", unAge, unEtatSante);
        typePelage = unTypePelage;
        sterilise = estSterilise;
        comportement = unComportement;
    }

    // Getters

    public String getTypePelage() {
        return typePelage;
    }

    public boolean isSterilise() {
        return sterilise;
    }

    public String getComportement() {
        return comportement;
    }

    // Setters

    public void setTypePelage(String unTypePelage) {
        typePelage = unTypePelage;
    }

    public void setSterilise(boolean estSterilise) {
        sterilise = estSterilise;
    }

    public void setComportement(String unComportement) {
        comportement = unComportement;
    }

    // toString

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Type de pelage : " + typePelage + "\n" +
                "Stérilisé : " + (sterilise ? "Oui" : "Non") + "\n" +
                "Comportement : " + comportement;
    }
}
