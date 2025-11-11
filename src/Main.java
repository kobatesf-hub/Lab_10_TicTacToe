import java.util.Scanner;

public class Main {
    private static final int ROWS = 3;
    private static final int COLS = 3;
    private static String[][] board = new String [ROWS][COLS];
    private static Scanner in = new Scanner(System.in);

    public static void main(String [] args){
        boolean done = false;
        System.out.println("Welcome to Tic Tac Toe");
        do{
            clearBoard();
            String player = "X";
            boolean gameOver = false;
            int moveCount = 0;

            while(!gameOver){
                display();
                System.out.println("Enter your move");
                int row = SafeInput.getRangedInt(in, "Enter row (1-3): ", 1, 3) - 1;
                int col = SafeInput.getRangedInt(in ,"Enter column (1-3): " , 1, 3) - 1;
                while (!isValidMove(row, col)) {
                    System.out.println("That cell is already taken! Try again. ");
                    row = SafeInput.getRangedInt(in, "Enter row (1-3): ", 1, 3) - 1;
                    col = SafeInput.getRangedInt(in ,"Enter column (1-3): " , 1, 3) - 1;
                }
                board[row][col] = player;
                moveCount++;

                if(moveCount >= 5 && isWin(player)){
                    display();
                    System.out.println("Player " + player + " Wins! ");
                    gameOver = true;
                }else if (moveCount == 9 && isTie()){
                    display();
                    System.out.println("It's a tie! ");
                    gameOver = true;
                }else {
                    player  = (player.equals("X")) ? "O" : "X";
                }
            }
            done = !SafeInput.getYNConfirm(in, "Play again? (Y/N): ");
        }while (!done);
        System.out.println("Thanks for Playing!");
    }
    private static void clearBoard(){
        for(int r = 0; r < ROWS; r++){
            for(int c = 0; c < COLS; c++){
                board[r][c] = " ";
            }
        }
    }
    private static void display() {
        System.out.println("\n  1 2 3");
        for (int r = 0; r < ROWS; r++) {
            System.out.print((r + 1) + " ");
            for (int c = 0; c < COLS; c++) {
                System.out.print(board[r][c]);
                if (c < COLS - 1) System.out.print("|");
            }
            System.out.println();
            if (r < ROWS - 1) System.out.println("  -----");
        }
    }
    private static boolean isValidMove(int row, int col){
            return row >= 0 && row < ROWS &&
                    col >= 0 && col < COLS &&
                    board[row][col].equals(" ");
    }
    private static boolean isWin(String player ){
        return isRowWin(player) || isColWin(player) || isDiagonalWin(player);
    }
    private static boolean isRowWin(String player){
        for(int r = 0; r < ROWS; r++){
            if (board[r][0].equals(player) && board[r][1].equals(player) && board[r][2].equals(player))
                return true;
            }
        return false;
    }
    private static boolean isColWin(String player){
        for (int c = 0; c < COLS; c++) {
            if (board[0][c].equals(player) && board[1][c].equals(player) && board[2][c].equals(player))
                return true;
        }
        return false;
    }
    private static boolean isDiagonalWin(String player){
        return (board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player)) ||
                (board[0][2].equals(player) && board[1][2].equals(player) && board[2][0].equals(player));

    }
    private static boolean isTie() {
        for (int r = 0; r < ROWS; r++){
            for (int c = 0; c< COLS; c++){
                if(board[r][c].equals(" "))
                    return false;
            }
        }
        return true;
    }
}




















