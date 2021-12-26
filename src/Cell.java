public class Cell {
    private int num;
    private int row;
    private int col;

    public Cell (int num, int row, int col) {
        this.num = num;
        this.row = row;
        this.col = col;
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

    public void setNum(int num) {
        this.num = num;
    }
}
