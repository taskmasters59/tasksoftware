

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

// User class to store form data
class User {
    private String name;
    private String email;
    private long roll;

    public User(String name, String email, long roll) {
        this.name = name;
        this.email = email;
        this.roll = roll;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public long getRoll() {
        return roll;
    }

   
}

public class SimpleForm extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("User Form");

        // Layout setup
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 20, 20, 20));

        // Form fields
        Label nameLabel = new Label("Name:");
        grid.add(nameLabel, 0, 0);
        TextField nameField = new TextField();
        grid.add(nameField, 1, 0);

        Label emailLabel = new Label("Email:");
        grid.add(emailLabel, 0, 1);
        TextField emailField = new TextField();
        grid.add(emailField, 1, 1);

        Label rollLabel = new Label("Roll:");
        grid.add(rollLabel, 0, 2);
        TextField rollField = new TextField();
        grid.add(rollField, 1, 2);

        // Submit button
        Button submitButton = new Button("Submit");
        grid.add(submitButton, 1, 3);

        // Submit Button Action
        submitButton.setOnAction(event -> {
     
                String name = nameField.getText();
                String email = emailField.getText();
                long roll = Long.parseLong(rollField.getText()); // Convert roll to long

                // Create a User object
                User user = new User(name, email, roll);

                // Print user details to console
                System.out.println("----------------------------- Form Submitted: -----------------------------");
                System.out.println(user.getName());
                System.out.println("---------------------------------------------------------------------------");

        });

        // Set scene and stage
        Scene scene = new Scene(grid, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
