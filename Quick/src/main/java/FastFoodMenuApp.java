import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FastFoodMenuApp extends Application {
    private Command command;
    private Label prixTotalLabel;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Fast Food Menu");
        command = new Command();
        HBox root = new HBox(10);
        root.setPadding(new Insets(20));

        ListView<String> selectedItemsList = new ListView<>();
        selectedItemsList.setPrefWidth(300);

        prixTotalLabel = new Label("Prix Total : 0.0€");
        VBox buttonBox = new VBox(10);

        Button menuButton = new Button("Ajouter Menu");
        menuButton.setOnAction(event -> afficherChoixMenu(selectedItemsList));

        Button burgerButton = new Button("Ajouter Burger");
        burgerButton.setOnAction(event -> afficherChoixBurger(selectedItemsList));

        Button boissonButton = new Button("Ajouter Boisson");
        boissonButton.setOnAction(event -> afficherChoixBoisson(selectedItemsList));

        Button fritesButton = new Button("Ajouter Frites");
        fritesButton.setOnAction(event -> afficherChoixFrites(selectedItemsList));

        Button sauceButton = new Button("Ajouter Sauce");
        sauceButton.setOnAction(event -> afficherChoixSauce(selectedItemsList));

        buttonBox.getChildren().addAll(menuButton, burgerButton, boissonButton, fritesButton, sauceButton);
        root.getChildren().addAll(buttonBox, selectedItemsList, prixTotalLabel);

        Scene scene = new Scene(root, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void afficherChoixFrites(ListView<String> selectedItemsList) {
        Stage choixFritesStage = new Stage();
        choixFritesStage.setTitle("Choisir des Frites");

        VBox root = new VBox(10);
        root.setPadding(new Insets(20));

        Label fritesLabel = new Label("Choisir des Frites:");
        ListView<Accompagnement.Fries> fritesListView = new ListView<>();
        fritesListView.getItems().addAll(Accompagnement.Fries.values());

        Button validerButton = new Button("Valider");
        validerButton.setOnAction(event -> {
            Accompagnement.Fries selectedFrites = fritesListView.getSelectionModel().getSelectedItem();
            if (selectedFrites != null) {
                Accompagnement frites = new Accompagnement(3.0f, selectedFrites, false);
                command.ajouterProduit(frites);
                selectedItemsList.getItems().add(frites.getDescription());
                mettreAJourPrixTotal();
                choixFritesStage.close();
            } else {
                Label errorLabel = new Label("Veuillez sélectionner des frites.");
                root.getChildren().add(errorLabel);
            }
        });

        root.getChildren().addAll(fritesLabel, fritesListView, validerButton);
        Scene scene = new Scene(root, 300, 400);
        choixFritesStage.setScene(scene);
        choixFritesStage.show();
    }

    private void afficherChoixSauce(ListView<String> selectedItemsList) {
        Stage choixSauceStage = new Stage();
        choixSauceStage.setTitle("Choisir une Sauce");

        VBox root = new VBox(10);
        root.setPadding(new Insets(20));

        Label sauceLabel = new Label("Choisir une Sauce:");
        ListView<Sauce.type_sauce> sauceListView = new ListView<>();
        sauceListView.getItems().addAll(Sauce.type_sauce.values());

        Button validerButton = new Button("Valider");
        validerButton.setOnAction(event -> {
            Sauce.type_sauce selectedSauce = sauceListView.getSelectionModel().getSelectedItem();
            if (selectedSauce != null) {
                Sauce sauce = new Sauce(0.5f, selectedSauce);
                command.ajouterProduit(sauce);
                selectedItemsList.getItems().add(sauce.getDescription());
                mettreAJourPrixTotal();
                choixSauceStage.close();
            } else {
                Label errorLabel = new Label("Veuillez sélectionner une sauce.");
                root.getChildren().add(errorLabel);
            }
        });

        root.getChildren().addAll(sauceLabel, sauceListView, validerButton);
        Scene scene = new Scene(root, 300, 400);
        choixSauceStage.setScene(scene);
        choixSauceStage.show();
    }

    private void afficherChoixBoisson(ListView<String> selectedItemsList) {
        Stage choixBoissonStage = new Stage();
        choixBoissonStage.setTitle("Choisir une Boisson");

        VBox root = new VBox(10);
        root.setPadding(new Insets(20));

        Label boissonLabel = new Label("Choisir une Boisson:");
        ListView<Boisson.Type> boissonListView = new ListView<>();
        boissonListView.getItems().addAll(Boisson.Type.values());

        Label tailleLabel = new Label("Choisir la Taille:");
        ToggleGroup tailleGroup = new ToggleGroup();
        RadioButton petitButton = new RadioButton("Petit");
        petitButton.setToggleGroup(tailleGroup);
        RadioButton moyenButton = new RadioButton("Moyen");
        moyenButton.setToggleGroup(tailleGroup);
        RadioButton grandButton = new RadioButton("Grand");
        grandButton.setToggleGroup(tailleGroup);
        grandButton.setSelected(true);

        HBox tailleBox = new HBox(10, petitButton, moyenButton, grandButton);

        Button validerButton = new Button("Valider");
        validerButton.setOnAction(event -> {
            Boisson.Type selectedBoisson = boissonListView.getSelectionModel().getSelectedItem();
            Boisson.Taille tailleBoisson = grandButton.isSelected() ? Boisson.Taille.GRAND :
                    (moyenButton.isSelected() ? Boisson.Taille.MOYEN : Boisson.Taille.PETIT);
            if (selectedBoisson != null) {
                float prixBoisson = tailleBoisson == Boisson.Taille.PETIT ? 2.0f :
                        (tailleBoisson == Boisson.Taille.MOYEN ? 2.5f : 3.0f);
                Boisson boisson = new Boisson(prixBoisson, true, tailleBoisson, selectedBoisson);
                command.ajouterProduit(boisson);
                selectedItemsList.getItems().add(boisson.getDescription());
                mettreAJourPrixTotal();
                choixBoissonStage.close();
            } else {
                Label errorLabel = new Label("Veuillez sélectionner une boisson.");
                root.getChildren().add(errorLabel);
            }
        });

        root.getChildren().addAll(boissonLabel, boissonListView, tailleLabel, tailleBox, validerButton);
        Scene scene = new Scene(root, 300, 400);
        choixBoissonStage.setScene(scene);
        choixBoissonStage.show();
    }

    private void afficherChoixBurger(ListView<String> selectedItemsList) {
        Stage choixBurgerStage = new Stage();
        choixBurgerStage.setTitle("Choisir un Burger");

        VBox root = new VBox(10);
        root.setPadding(new Insets(20));

        Label burgerLabel = new Label("Choisir un Burger:");
        ListView<Burger.type_burger> burgerListView = new ListView<>();
        burgerListView.getItems().addAll(Burger.type_burger.values());

        Button validerButton = new Button("Valider");
        validerButton.setOnAction(event -> {
            Burger.type_burger selectedBurger = burgerListView.getSelectionModel().getSelectedItem();
            if (selectedBurger != null) {
                Burger burger = new Burger(5.0f, selectedBurger);
                command.ajouterProduit(burger);
                selectedItemsList.getItems().add(burger.getDescription());
                mettreAJourPrixTotal();
                choixBurgerStage.close();
            } else {
                Label errorLabel = new Label("Veuillez sélectionner un burger.");
                root.getChildren().add(errorLabel);
            }
        });

        root.getChildren().addAll(burgerLabel, burgerListView, validerButton);
        Scene scene = new Scene(root, 300, 400);
        choixBurgerStage.setScene(scene);
        choixBurgerStage.show();
    }

    private void afficherChoixMenu(ListView<String> selectedItemsList) {
        Stage choixMenuStage = new Stage();
        choixMenuStage.setTitle("Choisir un Menu");

        VBox root = new VBox(10);
        root.setPadding(new Insets(20));

        Label burgerLabel = new Label("Choisir un Burger:");
        ListView<Burger.type_burger> burgerListView = new ListView<>();
        burgerListView.getItems().addAll(Burger.type_burger.values());

        Label boissonLabel = new Label("Choisir une Boisson:");
        ListView<Boisson.Type> boissonListView = new ListView<>();
        boissonListView.getItems().addAll(Boisson.Type.values());

        Label fritesLabel = new Label("Choisir des Frites:");
        ListView<Accompagnement.Fries> fritesListView = new ListView<>();
        fritesListView.getItems().addAll(Accompagnement.Fries.values());

        Button validerButton = new Button("Valider");
        validerButton.setOnAction(event -> {
            Burger.type_burger selectedBurger = burgerListView.getSelectionModel().getSelectedItem();
            Boisson.Type selectedBoisson = boissonListView.getSelectionModel().getSelectedItem();
            Accompagnement.Fries selectedFrites = fritesListView.getSelectionModel().getSelectedItem();

            if (selectedBurger != null && selectedBoisson != null && selectedFrites != null) {
                Menu menu = new Menu(true, new Boisson(2.0f, true, Boisson.Taille.GRAND, selectedBoisson), Sauce.type_sauce.Mayonnaise, selectedBurger,selectedFrites);
                command.ajouterProduit(menu);
                selectedItemsList.getItems().add(menu.getDescription());
                mettreAJourPrixTotal();
                choixMenuStage.close();
            } else {
                Label errorLabel = new Label("Veuillez sélectionner tous les éléments du menu.");
                root.getChildren().add(errorLabel);
            }
        });

        root.getChildren().addAll(burgerLabel, burgerListView, boissonLabel, boissonListView, fritesLabel, fritesListView, validerButton);
        Scene scene = new Scene(root, 300, 400);
        choixMenuStage.setScene(scene);
        choixMenuStage.show();
    }

    private void mettreAJourPrixTotal() {
        prixTotalLabel.setText("Prix Total : " + command.getPrixTotal() + "€");
    }
}
