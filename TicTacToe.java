import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create the board of Tic-Tac-Toe game.
        char[][] board = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
        char player = 'X';
        int row, col;

        while (true) {
            // Showing the game.
            System.out.println("  0 1 2");
            System.out.println("0 "+board[0][0]+"|"+board[0][1]+"|"+board[0][2]);
            System.out.println("  -+-+-");
            System.out.println("1 "+board[1][0]+"|"+board[1][1]+"|"+board[1][2]);
            System.out.println("  -+-+-");
            System.out.println("2 "+board[2][0]+"|"+board[2][1]+"|"+board[2][2]);

            // Play.
            System.out.print("\nPlayer "+player+"'s turn!\nChoose the row: ");
            row = scanner.nextInt();
            System.out.print("Choose the column: ");
            col = scanner.nextInt();

            // Validate play.
            if (row < 0 || row > 2 || col < 0 || col > 2 || board[row][col] != ' ') {
                System.out.println("Invalid play!");
                continue;
            }

            board[row][col] = player;

            // Defining winner.
            if (board[0][0] == player && board[0][1] == player && board[0][2] == player ||
                board[1][0] == player && board[1][1] == player && board[1][2] == player ||
                board[2][0] == player && board[2][1] == player && board[2][2] == player ||
                board[0][0] == player && board[1][0] == player && board[2][0] == player ||
                board[0][1] == player && board[1][1] == player && board[2][1] == player ||
                board[0][2] == player && board[1][2] == player && board[2][2] == player ||
                board[0][0] == player && board[1][1] == player && board[2][2] == player ||
                board[0][2] == player && board[1][1] == player && board[2][0] == player) {
                System.out.println("\nThe Player "+player+" Winner!");
                break;
            }

            // Next player.
            if (player == 'X')
                player = 'O';
            else
                player = 'X';

            // Check for draw.
            boolean draw = true;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j] == ' ') {
                        draw = false;
                        break;
                    }
                }
                if (!draw) {
                    break;
                }
            }
            if (draw) {
                System.out.println("\nIt's a Tie!");
                break;
            }
        }

        scanner.close();
    }
}