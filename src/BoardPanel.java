import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.GridPane;

public class BoardPanel extends GridPane implements EventHandler<ActionEvent> {
    private final View view;
    private final Board board;

    public BoardPanel(View view, Board board) {
        this.view = view;
        this.board = board;
        generateBoard();
    }

    protected void generateBoard() {
        for (Cell[] row : this.board.getBoard()) {
            for (Cell cell : row) {
                this.add(cell, cell.getRow(), cell.getCol());
            }
        }
    }

    @Override
    public void handle(ActionEvent event) {
        Cell tile = (Cell) event.getSource();
        this.board.move(tile.getNum());
    }
}
