import javafx.scene.control.Button;

public class Cell extends Button {
    private int num;
    private int row;
    private int col;

    public Cell (int num, int row, int col) {
        super("");
        setNum(num);
        this.row = row;
        this.col = col;
        this.setId(Integer.toString(row) + ", "  + Integer.toString(col));
        setScaleShape(true);
        setScale(5);
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

    public void setScale(int scale) {
        setScaleX(scale);
        setScaleY(scale);
        // setScaleZ(scale);
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
