public class Sauce extends Produit {

    private type_sauce sauce;

    public Sauce(float price, type_sauce sauce) {
        super(0.5F);
        this.sauce = sauce;
    }

    public type_sauce getSauce() {
        return sauce;
    }
    public enum type_sauce {

        Giant("G"),
        Tartare("T"),
        Barbecue("B"),
        Ketchup("K"),
        Mayonnaise("M"),
        Tomate_Basilic("TB"),
        Curry("C"),
        Salsa("S");
        private final String code;

        type_sauce(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }

    }
    @Override
    public String getDescription() {
        return "Sauce " + sauce.name() + " - " + price + "€";
    }

}
