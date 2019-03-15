package mainatm;

import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class HomeScreen {

    transactions Transactions = new transactions();
    Stage stage = new Stage();
    Scene scene;
    MainATM mainATM;
    private static String[] historyOfTransactions = new String[5];
    private static int i = 0;
    private static int j;

    public HomeScreen(Stage stage) {
        this.stage = stage;
    }

    HomeScreen() {
    }

    public void prepareScene(Stage primaryStage) {
        Button deposit = new Button("Deposit");
        Button withdraw = new Button("Withsdraw");
        Button balanceInquiry = new Button("Balance Inquiry");
        Button historyOfTransaction = new Button("History navigation");
        GridPane grid = new GridPane();
        grid.add(deposit, 0, 0);
        grid.add(withdraw, 0, 1);
        grid.add(balanceInquiry, 0, 2);
        grid.add(historyOfTransaction, 0, 3);
        // PREPARING DEPOSIT SCENE .....................
        GridPane grid1 = new GridPane();
        Scene scene1 = new Scene(grid1, 600, 400);
        grid1.setAlignment(Pos.CENTER);
        TextField depositField = new TextField();
        Label depositLabel = new Label("Enter the amount you want to deposit: ");
        Button confirm = new Button("Confirm");

        grid1.add(depositLabel, 0, 0);
        grid1.add(depositField, 0, 1);
        grid1.add(confirm, 1, 1);
        scene = new Scene(grid, 600, 400);
        deposit.setOnAction((ActionEvent event) -> {
            primaryStage.setScene(scene1);
        });

        confirm.setOnAction((ActionEvent event) -> {
            String depositAmount = depositField.getText();
            double amount;
            amount = Double.parseDouble(depositAmount);
            transactions.deposit(amount);
            setHistory("You depisited " + amount);
            primaryStage.setScene(scene);

        });
        // PREPARING WITHDRAW SCENE .....................
        GridPane grid2 = new GridPane();
        Scene scene2 = new Scene(grid2, 600, 400);
        grid2.setAlignment(Pos.CENTER);
        TextField withdrawfield = new TextField();
        Label withdrawLabel = new Label("Enter the amount you want to withdraw: ");
        Button confirm2 = new Button("Confirm");
        grid2.add(withdrawLabel, 0, 0);
        grid2.add(withdrawfield, 0, 1);
        grid2.add(confirm2, 1, 1);
        withdraw.setOnAction((ActionEvent event) -> {
            primaryStage.setScene(scene2);
        });
        confirm2.setOnAction((ActionEvent event) -> {
            String withdrawAmount = withdrawfield.getText();
            Double amount = Double.parseDouble(withdrawAmount);
            transactions.withdraw(amount);
            setHistory("You've withdrawn " + amount);
            primaryStage.setScene(scene);

        });
        GridPane grid3 = new GridPane();
        Scene scene3 = new Scene(grid3, 600, 400);
        grid3.setAlignment(Pos.CENTER);
        Label balanceLabel = new Label("Balance is : ");
        grid3.add(balanceLabel, 0, 0);
        Label balanceLabel2 = new Label();
        grid3.add(balanceLabel2, 1, 0);
        Button showbalance = new Button("Show balance ");
        Button confirm3 = new Button("Confirm");
        grid3.add(confirm3, 1, 1);
        grid3.add(showbalance, 0, 1);
        balanceInquiry.setOnAction((ActionEvent event) -> {
            primaryStage.setScene(scene3);

        });
        showbalance.setOnAction((ActionEvent event) -> {
            balanceLabel2.setText(Double.toString(transactions.getBalance()));

        });
        confirm3.setOnAction((ActionEvent event) -> {
            primaryStage.setScene(scene);

        });
        GridPane grid4 = new GridPane();
        Scene scene4 = new Scene(grid4, 600, 400);
        Button previous = new Button("Previous");
        Button next = new Button("Next");
        Label nextLabel = new Label();
        Label previousLabel = new Label();
        Button confirm4 = new Button("Confirm");
        grid4.add(next, 0, 0);
        grid4.add(previous, 0, 1);
        grid4.add(nextLabel, 1, 0);
        grid4.add(previousLabel, 1, 1);
        grid4.add(confirm4,1,2);

        historyOfTransaction.setOnAction((ActionEvent event) -> {
            primaryStage.setScene(scene4);

        });
        next.setOnAction((ActionEvent event) -> {
            nextLabel.setText(historyOfTransactions[++j]);

        });
        previous.setOnAction((ActionEvent event) -> {
            previousLabel.setText(historyOfTransactions[--j]);

        });
        confirm4.setOnAction((ActionEvent event) -> {
            primaryStage.setScene(scene);

        });
    }

    public Scene getScene() {
        return scene;
    }

    public void setMainATM(MainATM mainATM) {
        this.mainATM = mainATM;
    }

    public static void setHistory(String msg) {
        historyOfTransactions[i] = msg;
        i++;

    }

    public static String getHistory() {
        for (j = 0; j <= i - 1; j++) {
            System.out.println("The history of transactions is: " + historyOfTransactions[j]);
        }
        return historyOfTransactions[j];
    }
}
