import java.util.Scanner;

public class EIQUEENS_EightQueensPuzzle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[][] board = new char[8][8];

        for (int i = 0; i < 8; i++) {
            board[i] = sc.next().toCharArray();
        }

        if (isValidBoard(board)) {
            System.out.println("valid");
        } else {
            System.out.println("invalid");
        }

        sc.close();
    }

    private static boolean isValidBoard(char[][] board) {
        int[] rows = new int[8];
        int[] cols = new int[8];
        int[] diag1 = new int[15]; // from -(7) to 7
        int[] diag2 = new int[15]; // from 0 to 14

        int queenCount = 0;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == '*') {
                    queenCount++;
                    if (rows[i]++ > 0 || cols[j]++ > 0 || diag1[i - j + 7]++ > 0 || diag2[i + j]++ > 0) {
                        return false;
                    }
                }
            }
        }

        return queenCount == 8;
    }
}