import java.util.*;

class Game {
    
    private String[][] board;
    private String currentPlayer;
    
    public Game() {
        board = new String[3][3];
        setBoard();
        currentPlayer = "O";
    }

    public void setBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = "-";
            }
        }
    }

    public boolean boardIsFull(int r, int c){
        if (!board[r][c].equals("-")) 
            return true;
        return false;
    }

    public boolean boardIsFull() {
        int count = 0;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                if (board[i][j].equals("-")) {
                    count++;
                }
            }
        }
        if (count == 0) {
            return true;
        }
        return false;
    }

    public boolean boardIsEmpty() {
        int count = 0;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                if (board[i][j].equals("-")) {
                    count++;
                }
            }
        }
        if (count == 9) {
            return true;
        }
        return false;
    }

    public void input(String xo) {
        int r,c;
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter row: ");
        r = sc.nextInt();r--;

        System.out.print("Enter column: ");
        c = sc.nextInt();c--;
        
        try {
            if (boardIsFull(r, c)) {
                System.out.println("Invalid! value already exists\n");
                input(xo);
            }
            else
            board[r][c] = xo;
        } 
        catch (Exception e) {
            System.out.println("Invalid! must be >0 && <=3 \n");
            input(xo);
        }
    }

    public void input(String xo, int r, int c){
        board[r][c] = xo;
    }
    
    public void display() {
        System.out.println();
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                System.out.print(board[i][j] + " "); 
            }
            System.out.println();
        }
        System.out.println();
    }
    
    public boolean gameOver() {
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer)||
                (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer)||
                (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer)||
                (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer)||
                (boardIsFull()))
            return true;
        }

        return false;
    }
    
    public void game() {
        display();
        do{
            if (currentPlayer == "X") {
                currentPlayer = "O";
            }
            else{
                currentPlayer = "X";
            }
            
            System.out.println(currentPlayer + "'s Turn-");
            input(currentPlayer);   
            display();
        }while (!gameOver());

        if (boardIsFull())
        System.out.println("It's a DRAW");
        else 
        System.out.println(currentPlayer + " WINS");
    }
}

public class Tic_Tac_Toe {
    
    public static void main(String[] args) {
        System.out.println("Tic Tac Toe Game");    
        Game game = new Game();  
        game.game();
    }
}
