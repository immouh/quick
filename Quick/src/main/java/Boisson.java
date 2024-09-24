public class Boisson extends Produit {
    private boolean avecGlacons;
    private Taille taille;
    private Type typeDeBoisson;

    // Enum pour les types de boissons
    public enum Type {
        COCA("COCA"),
        FANTA("FANTA"),
        SPRITE("SPRITE"),
        BADOIT("BADOIT"),
        VOLVIC("VOLVIC"),
        COCA_CHERRY("COCA_CHERRY"),
        COCA_ZERO("COCA_ZERO"),
        FUZE_TEA("FUZE_TEA"),
        BIERE("BIERE");

        private String code;

        Type(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }
    }
    @Override
    public String getDescription() {
        String glaconsString = avecGlacons ? "avec glaçons" : "sans glaçons";
        return "Boisson : " + typeDeBoisson.getCode() + " (" + taille.getCode() + "), " + glaconsString + " - " + price + "€";
    }

    // Enum pour les tailles de boissons
    public enum Taille {
        PETIT("s"),
        MOYEN("m"),
        GRAND("b");

        private String code;

        Taille(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }
    }

    // Constructeur
    public Boisson(float prix, boolean avecGlacons, Taille taille, Type typeDeBoisson) {
        super(prix);  // Appelle le constructeur de la classe Produit
        this.avecGlacons = avecGlacons;
        this.taille = taille;
        this.typeDeBoisson = typeDeBoisson;
    }

    // Getters
    public boolean isAvecGlacons() {
        return avecGlacons;
    }

    public Taille getTaille() {
        return taille;
    }

    public Type getTypeDeBoisson() {
        return typeDeBoisson;
    }

    @Override
    public String toString() {
        String glaconsString = avecGlacons ? "avec glaçons" : "sans glaçons";
        return "Boisson : " + typeDeBoisson.getCode() + " (" + taille.getCode() + "), " + glaconsString + " - " + getPrice() + "€";
    }
}
