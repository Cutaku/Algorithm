package BOJ;

import java.io.*;

public class 틱택토_7682 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String str = br.readLine();

            if (str.equals("end")) {
                bw.flush();
                return;
            }

            char[] board = str.toCharArray();

            int countO = 0;
            int countX = 0;

            for (int i = 0; i < 9; i++) {
                if (board[i] == 'O') countO++;
                else if (board[i] == 'X') countX++;
            }

            boolean oCompleted = false;
            boolean xCompleted = false;

            for (int i = 0; i < 3; i++) {
                if (board[i] == 'O' && board[i + 3] == 'O' && board[i + 6] == 'O') oCompleted = true;
                if (board[3 * i] == 'O' && board[3 * i + 1] == 'O' && board[3 * i + 2] == 'O') oCompleted = true;
                if (board[i] == 'X' && board[i + 3] == 'X' && board[i + 6] == 'X') xCompleted = true;
                if (board[3 * i] == 'X' && board[3 * i + 1] == 'X' && board[3 * i + 2] == 'X') xCompleted = true;
            }

            if (board[0] == 'O' && board[4] == 'O' && board[8] == 'O') oCompleted = true;
            if (board[2] == 'O' && board[4] == 'O' && board[6] == 'O') oCompleted = true;
            if (board[0] == 'X' && board[4] == 'X' && board[8] == 'X') xCompleted = true;
            if (board[2] == 'X' && board[4] == 'X' && board[6] == 'X') xCompleted = true;

            if (countX == countO) {
                if (!xCompleted && oCompleted) {
                    bw.append("valid").append("\n");
                    continue;
                }
            }

            if (countX - countO == 1 && !oCompleted) {
                if (xCompleted) {
                    bw.append("valid").append("\n");
                    continue;
                } else if (countX == 5) {
                    bw.append("valid").append("\n");
                    continue;
                }
            }

            bw.append("invalid").append("\n");
        }
    }
}