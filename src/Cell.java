import javafx.scene.control.Button;

public class Cell extends Button {
    private int num;
    private int row;
    private int col;
    private int size = 100;

    public Cell (int num, int row, int col) {
        super("");
        setNum(num);
        this.row = row;
        this.col = col;
        this.setId(Integer.toString(row) + ", "  + Integer.toString(col));
        setSize();
    }

    public int getRow() {
        return this.row;
    }

    public int getCol() {
        return this.col;
    }

    public int getNum() {
        return this.num;
    }

    public String toString() {
        if (this.num == 0) {
            return " ";
        }
        return Integer.toString(this.num);
    }

    public void setSize() {
        setMinSize(size, size);
        setPrefSize(size, size);
    }

    public void setNum(int num) {
        this.num = num;
        if (num == 0) {
            setDisable(true);
        } else {
            setDisable(false);
        }
        this.setText(toString());
    }
}
