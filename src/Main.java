import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    /**
     * An "abstract" method is one that is defined in the parent class, but the parent class does not know enough
     * about the mother to fully implement it. So, all that is provided is the method signature in the parent class.
     * A subclass has to implement it.
     * @param args
     */

    @Override
    public void start(Stage stage) throws Exception { //this is where we tell java how to launch our app
        Parent root = FXMLLoader.load(getClass().getResource("views/cardView.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Card Display Super Awesome GUI");
        stage.show();
    }
}
