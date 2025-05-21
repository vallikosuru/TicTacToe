import java.util.Scanner;

public class TicTacToe {
    static char[][] board = {
        {' ', '|', ' ', '|', ' '},
        {'-', '+', '-', '+', '-'},
        {' ', '|', ' ', '|', ' '},
        {'-', '+', '-', '+', '-'},
        {' ', '|', ' ', '|', ' '}
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char currentPlayer = 'X';
        boolean gameEnded = false;

        System.out.println("Welcome to Tic Tac Toe!");
        printBoard();

        while (!gameEnded) {
            System.out.println("Player " + currentPlayer + ", enter your move (1-9): ");
            int move = scanner.nextInt();

            if (isValidMove(move)) {
                placeMove(move, currentPlayer);
                printBoard();

                if (checkWinner(currentPlayer)) {
                    System.out.println("Player " + currentPlayer + " wins!");
                    gameEnded = true;
                } else if (isDraw()) {
                    System.out.println("It's a draw!");
                    gameEnded = true;
                } else {
                    currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                }
            } else {
                System.out.println("Invalid move, try again.");
            }
        }

        scanner.close();
    }

    // Print the board
    public static void printBoard() {
        for (char[] row : board) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    // Check if move is valid
    public static boolean isValidMove(int move) {
        int[] pos = mapPosition(move);
        return board[pos[0]][pos[1]] == ' ';
    }

    // Place the move on the board
    public static void placeMove(int move, char player) {
        int[] pos = mapPosition(move);
        board[pos[0]][pos[1]] = player;
    }

    // Map input number to board coordinates
    public static int[] mapPosition(int move) {
        switch (move) {
            case 1: return new int[]{0, 0};
            case 2: return new int[]{0, 2};
            case 3: return new int[]{0, 4};
            case 4: return new int[]{2, 0};
            case 5: return new int[]{2, 2};
            case 6: return new int[]{2, 4};
            case 7: return new int[]{4, 0};
            case 8: return new int[]{4, 2};
            case 9: return new int[]{4, 4};
            default: return new int[]{-1, -1}; // Invalid
        }
    }

    // Check for winner
    public static boolean checkWinner(char player) {
        // Rows
        for (int i = 0; i <= 4; i += 2) {
            if (board[i][0] == player && board[i][2] == player && board[i][4] == player)
                return true;
        }

        // Columns
        for (int i = 0; i <= 4; i += 2) {
            if (board[0][i] == player && board[2][i] == player && board[4][i] == player)
                return true;
        }

        // Diagonals
        if (board[0][0] == player && board[2][2] == player && board[4][4] == player)
            return true;
        if (board[0][4] == player && board[2][2] == player && board[4][0] == player)
            return true;

        return false;
    }

    // Check for draw
    public static boolean isDraw() {
        for (int i = 0; i <= 4; i += 2) {
            for (int j = 0; j <= 4; j += 2) {
                if (board[i][j] == ' ')
                    return false;
            }
        }
        return true;
    }
}
