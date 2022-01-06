import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class View {
    NPuzzle model;
    Stage stage;
    BoardPanel boardPanel;
    TextField txtInput;
    Label messageLabel;
    
    public View (NPuzzle model, Stage stage) {
        this.model = model;
        this.stage = stage;
        initUI();
    }

    private void initUI() {
        this.boardPanel = new BoardPanel(this, this.model.getBoard());
        this.boardPanel.setAlignment(Pos.CENTER);
        Scene scene = new Scene(showMainMenu());
        this.stage.setScene(scene);
        this.stage.sizeToScene();
        this.stage.setResizable(false);
        this.stage.centerOnScreen();
        this.stage.show();
    }

    private VBox showMainMenu() {
        this.txtInput = new TextField();
        this.messageLabel = new Label("Enter the size of the board below");
        this.messageLabel.setPrefSize(200, 50);
        VBox vbox = new VBox(20, this.messageLabel, this.txtInput);
        return vbox;
    }

    public int getSize() {
        int input = Integer.parseInt(this.txtInput.getText());
        if (0 < input && input < 10) {
            return input;
        } else {
            this.messageLabel.setText("Enter a number between 1 and 9, inclusive");
            return getSize();
        }
    }

    protected void runMove(Cell tile) {
        this.model.moveTile(tile);
    }
}
