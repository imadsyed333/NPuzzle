import javafx.scene.Scene;
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
        Scene scene = new Scene(this.boardPanel);
        this.stage.setScene(scene);
        this.stage.show();
    }

    protected void runMove(Cell tile) {
        this.model.moveTile(tile);
    }
}
