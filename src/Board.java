import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Board {
    private Cell[][] board;
    private int size;

    public Board(int size) {
        this.size = size;
        this.board = new Cell[size][size];
        loadBoard();
    }

    public void loadBoard() {
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i < this.size * this.size; i++) {
            nums.add(i);
        }
        while (getNumInversions(nums) == 0 || getNumInversions(nums) % 2 != 0) {
            Collections.shuffle(nums);
        }
        nums.add(0);
        System.out.println(nums);
        this.board = toArray(nums, this.size);
    }

    public int getNumInversions(List<Integer> nums) {
        int numInversions = 0;
        for (int i = 0; i < nums.size() - 1; i++) {
            int a = nums.get(i);
            int b = nums.get(i + 1);
            if (a > b) {
                numInversions++;
            }
        }
        return numInversions;
    }

    public Cell[][] toArray(List<Integer> list, int rows) {
        int resultRows = list.size()/rows; 
        if (list.size() % rows != 0) {
            resultRows++;
        }
        Cell[][] result = new Cell[resultRows][rows];
        int i = 0;
        int j = 0;
            for (Integer value : list) {
                result[i][j] = new Cell(value, i, j);
                j++;
                if(j > rows - 1){
                    i++;
                    j = 0;
                }
            }
        return result;
    }

    public boolean isBoardSolved() {
        List<Integer> nums = new ArrayList<>();
        for (Cell[] row : this.board) {
            for (Cell cell : row) {
                nums.add(cell.getNum());
            }
        }
        List<Integer> copyNums = new ArrayList<>(nums);
        Collections.sort(copyNums);
        copyNums.remove(0);
        copyNums.add(0);
        return nums.equals(copyNums);
    }

    public void move(int num) {
        Cell cell = getCellWithNum(num);
        if (canMove(cell)) {
            Cell nullCell = getCellWithNum(0);
            nullCell.setNum(cell.getNum());
            cell.setNum(0);            
        }
    }

    public boolean canMove(Cell cell) {
        Cell nullCell = getCellWithNum(0);
        int rowDistance = Math.abs(cell.getRow() - nullCell.getRow());
        int colDistance = Math.abs(cell.getCol() - nullCell.getCol());

        return (rowDistance == 0 && colDistance == 1) || (rowDistance == 1 && colDistance == 0);
    }

    public Cell getCellWithNum(int num) {
        for (Cell[] row : this.board) {
            for (Cell cell : row) {
                if (cell.getNum() == num) {
                    return cell;
                }
            }
        }
        return null;
    }

    public boolean isNumOnBoard(int num) {
        return 0 < num && num < this.size;
    }

    public String toString() {
        String s = "";
        for (Cell[] row : this.board) {
            for (Cell cell : row) {
                s += '[' + cell.toString() + ']';
            }
            s += '\n';
        }
        return s.strip();
    }
}
