package calendar;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

class LoginScreen {
    private final String USERNAME = "Nur Efşan Yaman";
    private final String PASSWORD = "24040102011";

    public void start(Stage primaryStage) {
        Label userLabel = new Label("Username:");
        TextField userField = new TextField();

        Label passLabel = new Label("Password:");
        PasswordField passField = new PasswordField();

        Button loginBtn = new Button("Login");

        VBox vbox = new VBox(10, userLabel, userField, passLabel, passField, loginBtn);
        vbox.setStyle("-fx-padding: 20; -fx-background-color: pink;");

        loginBtn.setOnAction(_ -> {
            String user = userField.getText();
            String pass = passField.getText();
            if (user.equals(USERNAME) && pass.equals(PASSWORD)) {
                CalendarApp app = new CalendarApp();
                app.start(primaryStage);
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Incorrect login.");
                alert.show();
            }
        });

        Scene scene = new Scene(vbox, 300, 200);
        primaryStage.setTitle("Login");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
