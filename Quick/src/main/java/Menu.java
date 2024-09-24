import java.util.LinkedList;

public class Menu extends Produit {
   private boolean grandMenu;
   private Boisson boisson;
   private Burger.type_burger typeBurger;
   private Sauce.type_sauce sauce1;
   private Sauce.type_sauce sauce2;
   private Accompagnement.Fries typeFrites;

   public Menu(boolean grandMenu, Boisson boisson, Sauce.type_sauce sauce1, Burger.type_burger typeBurger, Accompagnement.Fries typeFrites) {
      super(grandMenu ? 12.0f : 10.0f);
      this.grandMenu = grandMenu;
      this.boisson = boisson;
      this.sauce1 = sauce1;
      this.typeBurger = typeBurger;
      this.typeFrites = typeFrites;

      if (grandMenu) {
         this.sauce2 = Sauce.type_sauce.Tomate_Basilic;
      } else {
         this.sauce2 = null;
      }
   }

   public boolean isGrandMenu() {
      return grandMenu;
   }

   public Boisson getBoisson() {
      return boisson;
   }

   public Burger.type_burger getTypeBurger() {
      return typeBurger;
   }

   public Accompagnement.Fries getTypeFrites() {
      return typeFrites;
   }

   public Sauce.type_sauce getSauce1() {
      return sauce1;
   }

   public Sauce.type_sauce getSauce2() {
      return sauce2;
   }

   @Override
   public String getDescription() {
      StringBuilder description = new StringBuilder();
      description.append("Menu ").append(grandMenu ? "Grand" : "Petit").append(": ");
      description.append(typeBurger.name()).append(", ");
      description.append(boisson.getDescription()).append(", ");
      description.append("Frites ").append(typeFrites.name()).append(", ");
      description.append("Sauce ").append(sauce1.name());
      if (grandMenu && sauce2 != null) {
         description.append(" et ").append(sauce2.name());
      }
      description.append(" - ").append(getPrice()).append("€");
      return description.toString();
   }

   @Override
   public float getPrice() {
      return super.getPrice();
   }
}