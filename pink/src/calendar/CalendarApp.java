package calendar;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.util.HashMap;

public class CalendarApp {
    private final HashMap<LocalDate, String> events = new HashMap<>();

    public void start(Stage stage) {
        DatePicker datePicker = new DatePicker();
        TextField eventField = new TextField();
        Button saveButton = new Button("Save Event");

        TextArea eventArea = new TextArea();
        eventArea.setEditable(false);

        VBox vbox = new VBox(10, new Label("Select Date:"), datePicker,
                new Label("Enter Event:"), eventField, saveButton, eventArea);
        vbox.setAlignment(Pos.CENTER);
        vbox.setStyle("-fx-padding: 20; -fx-background-color: pink;");
        vbox.setPrefSize(400, 400);

        saveButton.setOnAction(_ -> {
            LocalDate date = datePicker.getValue();
            String event = eventField.getText();
            if (date != null && !event.isEmpty()) {
                events.put(date, event);
                eventArea.setText("Saved event on " + date + ": " + event);
                eventField.clear();
            } else {
                eventArea.setText("Please select date and enter event.");
            }
        });

        Scene scene = new Scene(vbox);
        stage.setScene(scene);
        stage.setTitle("Calendar App");
        stage.show();
    }
}
