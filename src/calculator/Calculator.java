
package calculator;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author User
 */
public class Calculator extends Application {

    public static BorderPane lay;
    public static Parent rejim1, rejim2, rejim3;
    public static BorderPane layout;
    public static Stage stage;

    @Override
    public void start(Stage primaryStage) throws IOException {
        stage = primaryStage;
        layout = new BorderPane();
        //layout.setStyle("-fx-background-color :  #d8e7f1");

        rejim1 = FXMLLoader.load(getClass().getResource("rejim1.fxml"));
        rejim2 = FXMLLoader.load(getClass().getResource("rejim2.fxml"));
        rejim3 = FXMLLoader.load(getClass().getResource("rejim3.fxml"));

        Parent menu = FXMLLoader.load(getClass().getResource("Menu.fxml"));

        layout.setTop(menu);
        layout.setCenter(rejim1);

        Scene epizod = new Scene(layout);

        primaryStage.setIconified(true);
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("icon.PNG")));
        primaryStage.setTitle("Калькулятор");
        primaryStage.setResizable(false);
        primaryStage.setScene(epizod);
        primaryStage.show();
        primaryStage.setAlwaysOnTop(true);
    }

    public static void main(String[] args) {
        launch(args);
    }

}
