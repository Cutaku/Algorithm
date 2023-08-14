package Programmers;

class 혼자서하는틱택토 {
    public int solution(String[] board) {

        char[][] b = new char[3][];
        for (int i = 0; i < 3; i++) b[i] = board[i].toCharArray();

        int countO = 0;
        int countX = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (b[i][j] == 'O') countO++;
                else if (b[i][j] == 'X') countX++;
            }
        }

        boolean oCompleted = false;
        boolean xCompleted = false;

        for (int i = 0; i < 3; i++) {
            if (b[i][0] == 'O' && b[i][1] == 'O' && b[i][2] == 'O') oCompleted = true;
            if (b[0][i] == 'O' && b[1][i] == 'O' && b[2][i] == 'O') oCompleted = true;
            if (b[i][0] == 'X' && b[i][1] == 'X' && b[i][2] == 'X') xCompleted = true;
            if (b[0][i] == 'X' && b[1][i] == 'X' && b[2][i] == 'X') xCompleted = true;
        }

        if (b[0][0] == 'O' && b[1][1] == 'O' && b[2][2] == 'O') oCompleted = true;
        if (b[2][0] == 'O' && b[1][1] == 'O' && b[0][2] == 'O') oCompleted = true;
        if (b[0][0] == 'X' && b[1][1] == 'X' && b[2][2] == 'X') xCompleted = true;
        if (b[2][0] == 'X' && b[1][1] == 'X' && b[0][2] == 'X') xCompleted = true;


        if (countO == countX) {
            if (!oCompleted && !xCompleted) return 1;
            if (!oCompleted && xCompleted) return 1;
        }

        if (countO - countX == 1) {
            if (!oCompleted && !xCompleted) return 1;
            if (oCompleted && !xCompleted) return 1;
        }

        return 0;
    }
}