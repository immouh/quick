public class Burger extends Produit {
    @Override
    public String getDescription() {
        return null;
    }

    public enum type_burger{
        GIANT("GIANT"),
        MEGA_GIANT("MEGA"),
        GIANT_MAX("MAX"),
        SUPREME_CLASSIQUE("SUPREME_CLASSIQUE"),
        SUPREME_SPICY("SUPREME_SPICY"),
        SUPREME_BACON("SUPREME_BACON"),
        QUICK_TOAST("QUICK_TOAST"),
        LONG_CHICKEN("LONG_CHICKEN"),
        LONG_BACON("LONG_BACON"),
        LONG_FISH("LONG_FISH"),
        CHEESE("CHEESE"),
        WRAPS_CHEESE("WRAPS_CHEESE"),
        WRAPS_VEGGIE("VEGGIE");
        private  String code;

        type_burger(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }
    }
    type_burger burger;

    public Burger(float price, type_burger burger) {
        super(price);
        this.burger = burger;
    }

    @Override
    public String toString() {
        return "Burger{" +
                "burger=" + burger +
                ", price=" + price +
                '}';
    }
}
