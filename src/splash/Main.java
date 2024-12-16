// package splash;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Main extends Application {
    // Private method to initialize the top menu
    private HBox createTopMenu() {
        HBox topMenu = new HBox(10);
        topMenu.setMaxWidth(1390);
        topMenu.setPadding(new Insets(10));
        Label menuF9 = new Label("F9 Terms & Condition");
        Label menuF12 = new Label("F12 Settings");
        menuF9.setTranslateX(100);
        menuF12.setTranslateX(200);
        topMenu.getChildren().addAll(menuF9, menuF12);
        topMenu.setStyle("-fx-background-color: #357DA9; -fx-font-weight: bold; -fx-text-fill: white;");
        return topMenu;
    }

    // Private method to create the left menu
    private VBox createLeftMenu() {
        VBox leftMenu = new VBox(20);
        leftMenu.setPadding(new Insets(60));
        leftMenu.setAlignment(Pos.CENTER_LEFT);
        leftMenu.setStyle("-fx-background-color: white; -fx-border-color: #E0E0E0;");

        // Create labels for the left menu
        Label createCompany = createMenuLabel("Create Company", "#357DA9");
        Label alterCompany = createMenuLabel("Alter Company", "#000000");
        Label selectCompany = createMenuLabel("Select Company", "#000000");
        Label shutCompany = createMenuLabel("Shut Company", "#000000");
        createCompany.setTranslateY(-100);
        alterCompany.setTranslateY(-95);
        selectCompany.setTranslateY(-90);
        shutCompany.setTranslateY(-85);

        // Add labels to the VBox
        leftMenu.getChildren().addAll(createCompany, alterCompany, selectCompany, shutCompany);
        return leftMenu;
    }

    // Private method to create individual menu labels with styling
    private Label createMenuLabel(String text, String textColor) {
        Label label = new Label(text);
        label.setStyle("-fx-text-fill: " + textColor + "; -fx-font-size: 16;");
        label.setStyle(" -fx-padding: 0;");
        return label;
    }

    // Private method to create the center content with watermark
    private StackPane createCenterContent() {
        StackPane centerContent = new StackPane();
        centerContent.setStyle("-fx-background-color: #FFFFFF;");
        centerContent.setPadding(new Insets(20));

        // Set image in the center
        Image waterMark = new Image("file:/D:/Shree/javafx/resources/mainlogo.png");
        ImageView centerImage = new ImageView(waterMark);
        centerImage.setOpacity(0.4);
        centerImage.setFitWidth(510);
        centerImage.setFitHeight(450);
        centerContent.getChildren().add(centerImage);
        return centerContent;
    }

    // Private method to create the right content
    private VBox createRightContent() {
        VBox rightContent = new VBox(100);
        rightContent.setMaxHeight(1190);
        rightContent.setPadding(new Insets(80));
        rightContent.setStyle("-fx-background-color: #C6D6F2;");
        return rightContent;
    }

    // Private method to create the bottom menu with function keys
    private HBox createBottomMenu() {
        HBox bottomMenu = new HBox(10);
        bottomMenu.setMaxWidth(1390);
        bottomMenu.setPadding(new Insets(10));
        bottomMenu.setStyle("-fx-background-color: #357DA9;");

        Label dateLabel = new Label("2024-12-09");
        dateLabel.setStyle("-fx-font-size:16; -fx-font-weight: bold; -fx-text-fill: #76C0EC;");
        dateLabel.setTranslateX(780);

        // Create function key labels
        Label f1 = createFunctionKeyLabel("F1 Create Company");
        Label f2 = createFunctionKeyLabel("F2 Alter Company");
        Label f3 = createFunctionKeyLabel("F3 Select Company");
        Label f4 = createFunctionKeyLabel("F4 Shut Company");
        f1.setTranslateX(100);
        f2.setTranslateX(200);
        f3.setTranslateX(300);
        f4.setTranslateX(400);
        bottomMenu.getChildren().addAll(f1, f2, f3, f4, dateLabel);
        return bottomMenu;
    }

    // Private method to create function key labels
    private Label createFunctionKeyLabel(String text) {
        Label label = new Label(text);
        label.setTranslateX(100);
        label.setTranslateY(5);
        label.setStyle("-fx-font-weight: bold;");
        return label;
    }

    @Override
    public void start(Stage primaryStage) {
        // Main layout setup
        BorderPane root = new BorderPane();
        root.setTop(createTopMenu());
        root.setLeft(createLeftMenu());
        root.setCenter(createCenterContent());
        root.setRight(createRightContent());
        root.setBottom(createBottomMenu());

        // Scene and Stage setup
        Scene scene = new Scene(root, 900, 600);
        primaryStage.setTitle("Main Application");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
