import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {
    NPuzzle model;
    View view;

    @Override
    public void start(Stage stage) {
        stage.setTitle("NPuzzle");
        stage.setMinHeight(900);
        stage.setMinWidth(600);

        this.model = new NPuzzle();
        this.view = new View(model, stage);
    }

    public static void main(String[] args) {
        launch();
    }
}
