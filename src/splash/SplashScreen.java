// package splash;

import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;


public class SplashScreen extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Load the GIF file securely
        String gifPath = "../../resources/shreelogo.gif";


        Image gifImage = new Image("file:" + gifPath);

        // Create an ImageView to display the GIF
        ImageView imageView = new ImageView(gifImage);

        // Optional: Apply effects to the ImageView
        ColorAdjust colorAdjust = new ColorAdjust();
        colorAdjust.setContrast(0);
        colorAdjust.setBrightness(0);
        imageView.setEffect(colorAdjust);

        // Set properties for the ImageView
        imageView.setFitWidth(500);
        imageView.setFitHeight(300);
        imageView.setTranslateY(30);
        imageView.setPreserveRatio(true);

        // Center the ImageView in a StackPane
        StackPane splashPane = new StackPane(imageView);
        splashPane.setAlignment(Pos.CENTER);
        // Create the Scene
        Scene splashScene = new Scene(splashPane, 400, 300);

        // Set up the splash stage
        Stage splashStage = new Stage();
        splashStage.setX(500);
        splashStage.setY(200);
        splashStage.initStyle(StageStyle.UNDECORATED); 
        splashStage.setScene(splashScene);
        splashStage.show();

        // Transition to the main application after a delay
        PauseTransition delay = new PauseTransition(Duration.seconds(5));
        delay.setOnFinished(event -> {
            splashStage.close(); 
            Main.main(new String[]{});      //calling fo splash screen function
        });
        delay.play();
    }
}
