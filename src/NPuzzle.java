import java.util.Scanner;

public class NPuzzle {

    private final Board board;
    private int size;
    private final Scanner scanner = new Scanner(System.in);

    public NPuzzle() {
        this.size = getSize();
        this.board = new Board(this.size);
    }

    public int getSize() {
        System.out.println("Enter the board size:");
        while (!this.scanner.hasNextInt()) {
            System.out.println("Enter a positive integer:");
            scanner.next();
        }
        return scanner.nextInt();
    }

    public boolean isPuzzleSolved() {
        return this.board.isBoardSolved();
    }

    public void moveTile(Cell tile) {
        this.board.move(tile);
    }

    public Board getBoard() {
        return this.board;
    }
}
