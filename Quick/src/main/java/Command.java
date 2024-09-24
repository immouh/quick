import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;


public class Command {
    private List<Produit> produits;
    private List<Menu> menus;
    private float prixTotal;
    public void retirerProduit(Produit produit){
        this.produits.remove(produit);
        this.prixTotal -= produit.getPrice();
    }

    public void retirerMenu(Menu menu) {
        this.menus.remove(menu);
        this.prixTotal -= menu.getPrice();
    }


    public Command() {
        this.produits = new ArrayList<>();
        this.menus = new ArrayList<>();
        this.prixTotal = 0.0F;
    }
    public void ajouterProduit(Produit produit) {
        this.produits.add(produit);
        this.prixTotal += produit.getPrice();
    }

    public void ajouterMenu(Menu menu) {
        this.menus.add(menu);
        this.prixTotal += menu.getPrice();
    }

    public List<Produit> getProduits() {
        return produits;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public float getPrixTotal() {
        return prixTotal;
    }

    public void calculerPrixTotal() {
        float total = 0.0F;
        for (Produit produit : produits) {
            total += produit.getPrice();
        }
        for (Menu menu : menus) {
            total += menu.getPrice();
        }
        this.prixTotal = total;
    }

    @Override
    public String toString() {
        StringBuilder description = new StringBuilder();
        description.append("Commande :\n");

        if (!produits.isEmpty()) {
            description.append("Produits :\n");
            for (Produit produit : produits) {
                description.append(produit.getDescription()).append("\n");
            }
        }

        if (!menus.isEmpty()) {
            description.append("Menus :\n");
            for (Menu menu : menus) {
                description.append(menu.getDescription()).append("\n");
            }
        }

        description.append("Prix Total : ").append(String.format("%.2f", prixTotal)).append("€");
        return description.toString();
    }
}

