package mainatm;

import javafx.application.Application;
import javafx.stage.Stage;

public class atmAPP extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("My ATM!");
        MainATM mainATM = new MainATM(primaryStage);
        HomeScreen homeScreen = new HomeScreen(primaryStage);

        mainATM.prepareScene();
        homeScreen.prepareScene(primaryStage);

        mainATM.setHomeScreen(homeScreen);

        primaryStage.setScene(mainATM.getScene());
        primaryStage.show();
    }

}
