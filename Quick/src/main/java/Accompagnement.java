public class Accompagnement extends Produit {
    private final Fries typeFrites;
    private boolean cheddar;

    public enum Fries {
        FRENCH_FRIES("F"),
        RUSTIQUE("R");

        private final String code;

        Fries(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }
    }

    public Accompagnement(float price, Fries typeFrites, boolean cheddar) {
        super(price);
        this.typeFrites = typeFrites;
        this.cheddar = cheddar;
    }

    @Override
    public String getDescription() {
        return "Accompagnement: " + typeFrites.name() + (cheddar ? " avec cheddar" : "") + " - " + price + "€";
    }
}