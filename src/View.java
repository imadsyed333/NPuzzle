import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class View {
    NPuzzle model;
    Stage stage;
    BoardPanel boardPanel;
    
    public View (NPuzzle model, Stage stage) {
        this.model = model;
        this.stage = stage;
        initUI();
    }

    private void initUI() {
        this.boardPanel = new BoardPanel(this, this.model.getBoard());
        Scene scene = new Scene(this.boardPanel, 800, 800);
        this.stage.setScene(scene);
        this.stage.show();
    }
}
