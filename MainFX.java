import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
/**
 * Kyle M. Shive
 */
public class MainFX extends Application {
    
    @Override
    public void start(Stage stage) {
        stage.setTitle("JavaFX Shape Art");
        stage.setScene( new Scene( new RandomPane(), 600, 600) );
        stage.show();
        stage.getScene().getRoot().requestFocus(); //set event focus to scene 
    }// end override
    
    public static void main(String[] args) {
        Application.launch(args);
    }// end launch
}// end main method