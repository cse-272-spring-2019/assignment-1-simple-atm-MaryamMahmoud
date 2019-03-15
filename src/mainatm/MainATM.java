package mainatm;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MainATM {

    Stage stage = new Stage();
    Scene scene;
    LoginAuthintication authintication;
    public HomeScreen homeScreen;

    public MainATM(Stage stage) {
        this.stage = stage;
    }

    MainATM() {
    }

    public void prepareScene() {
        authintication = new LoginAuthintication();
        //drawing...............................................
        Label name = new Label("Name");
        TextField nameField = new TextField();
        Label cardNumberLabel = new Label("Card Number");
        PasswordField cardNumberField = new PasswordField();
        Button submit = new Button("Login");
        Label validationLabel = new Label();
        GridPane grid = new GridPane();
        grid.add(name, 0, 0);
        grid.add(nameField, 1, 0);
        grid.add(cardNumberLabel, 0, 1);
        grid.add(cardNumberField, 1, 1);
        grid.add(submit, 1, 2);
        grid.add(validationLabel, 1, 3);
//End of drawing....................................................

//Actions ...........................................................
        submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String userName = nameField.getText();
                String cardNumber = cardNumberField.getText();
                boolean valid = authintication.validation(userName, cardNumber);
                if (valid) {
                    validationLabel.setText("Welcome " + userName);
                    stage.setScene(homeScreen.getScene());

                } else if (!cardNumber.matches("[0-9]+")) {
                    validationLabel.setText("Use numbers only in the card number field");
                } else {
                    validationLabel.setText("Wrong username or card Number");

                }
            }

        });

        // end actions ..................................................
        scene = new Scene(grid, 600, 400);
    }

    public Scene getScene() {
        return this.scene;
    }

    public void setHomeScreen(HomeScreen homeScreen) {
        this.homeScreen = homeScreen;
    }

}
