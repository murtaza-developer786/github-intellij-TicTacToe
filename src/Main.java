import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        char[][] board = new char[3][3];
        initializeBoard(board);

        char currentPlayer = 'X';

        Scanner scanner = new Scanner(System.in);

        System.out.println("------ Welcome to Tic-Tac-Toe ------");

        while (true) {

            printBoard(board);

            System.out.println("Player " + currentPlayer + ", it's your turn.");

            int row;
            int column;

            // Get a valid position
            while (true) {

                System.out.print("Enter row (0, 1, 2): ");
                row = scanner.nextInt();

                System.out.print("Enter column (0, 1, 2): ");
                column = scanner.nextInt();

                if (isValidMove(board, row, column)) {
                    break;
                }

                System.out.println("Invalid move! Try again.");
            }

            // Place player's symbol
            board[row][column] = currentPlayer;

            // Check winner
            if (checkWin(board, currentPlayer)) {
                printBoard(board);
                System.out.println("Player " + currentPlayer + " wins!");
                break;
            }

            // Check draw
            if (checkDraw(board)) {
                printBoard(board);
                System.out.println("Game draw!");
                break;
            }

            // Switch player
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }

        scanner.close();
    }

    private static void initializeBoard(char[][] board) {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    private static void printBoard(char[][] board) {

        System.out.println("\n-------------");

        for (int i = 0; i < 3; i++) {

            System.out.print("| ");

            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }

            System.out.println();
            System.out.println("-------------");
        }
    }

    private static boolean isValidMove(char[][] board, int row, int column) {

        return row >= 0 &&
                row < 3 &&
                column >= 0 &&
                column < 3 &&
                board[row][column] == '-';
    }

    private static boolean checkWin(char[][] board, char player) {

        // Check rows and columns
        for (int i = 0; i < 3; i++) {

            // Row
            if (board[i][0] == player &&
                    board[i][1] == player &&
                    board[i][2] == player) {

                return true;
            }

            // Column
            if (board[0][i] == player &&
                    board[1][i] == player &&
                    board[2][i] == player) {

                return true;
            }
        }

        // First diagonal
        if (board[0][0] == player &&
                board[1][1] == player &&
                board[2][2] == player) {

            return true;
        }

        // Second diagonal
        if (board[0][2] == player &&
                board[1][1] == player &&
                board[2][0] == player) {

            return true;
        }

        return false;
    }

    private static boolean checkDraw(char[][] board) {

        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {

                if (board[i][j] == '-') {
                    return false;
                }
            }
        }

        return true;
    }
}