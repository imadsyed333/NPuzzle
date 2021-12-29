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

    public void runPuzzle() {
        while (!isPuzzleSolved()) {
            getMove();
        }
        System.out.println(this.board);
        System.out.println("You solved it!");
    }

    public boolean isPuzzleSolved() {
        return this.board.isBoardSolved();
    }

    public void getMove() {
        System.out.println(this.board);
        System.out.println("Enter the number which you would like to move:");
        while (!this.scanner.hasNextInt()) {
            System.out.println("Enter a positive integer that is on the board:");
            scanner.next();
        }
        this.board.move(scanner.nextInt());
    }
    public static void main(String[] args) throws Exception {
        System.out.println("Welcome to N-Puzzle!");
        NPuzzle puzzle = new NPuzzle();
        puzzle.runPuzzle();
    }
}
