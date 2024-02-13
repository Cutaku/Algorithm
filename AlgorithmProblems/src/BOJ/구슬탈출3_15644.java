package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 구슬탈출3_15644 {
    static int n, m;
    static char[][] board;
    static int[][] D = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = nm[0];
        m = nm[1];

        board = new char[n][];
        for (int i = 0; i < n; i++) board[i] = br.readLine().toCharArray();

        int ir = 0, ib = 0;
        int goal = 0;

        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < m - 1; j++) {
                if (board[i][j] == 'R') ir = 10 * i + j;
                else if (board[i][j] == 'B') ib = 10 * i + j;
                else if (board[i][j] == 'O') goal = 10 * i + j;
            }
        }

        Bid bid = new Bid(ir, ib, 0, 0);

        Set<Integer> v = new HashSet<>();

        Queue<Bid> q1 = new ArrayDeque<>();
        Queue<Bid> q2 = new ArrayDeque<>();

        q1.add(bid);
        v.add(bid.distinct);

        int count = 0;

        while (!q1.isEmpty()) {
            Bid now = q1.poll();

            if (now.distinct / 100 == goal) {
                System.out.println(count);

                char[] dir = {'R', 'D', 'L', 'U'};

                for (int i = 0; i < count; i++) {
                    sb.append(dir[now.history % 10]);
                    now.history /= 10;
                }

                System.out.print(sb.reverse());
                return;
            }

            for (int i = 0; i < 4; i++) {
                Bid next = getNext(now, i);

                if (v.add(next.distinct) && next.distinct % 100 != goal) q2.add(next);
            }

            if (q1.isEmpty()) {
                Queue<Bid> t = new ArrayDeque<>();
                q1 = q2;
                q2 = t;

                count++;

                if (count > 10) break;
            }
        }

        System.out.println(-1);
    }

    private static Bid getNext(Bid now, int i) {

        int r = now.r;
        int b = now.b;

        boolean[] rb = {r % 10 > b % 10, r / 10 > b / 10, r % 10 < b % 10, r / 10 < b / 10};

        r = move(r, i);
        b = move(b, i);

        if (r == b && board[r / 10][r % 10] != 'O') {
            if (rb[i])  b -= 10 * D[i][0] + D[i][1];
            else  r -= 10 * D[i][0] + D[i][1];
        }

        return new Bid(r, b, now.history, i);
    }

    static int move(int p, int d) {

        int ni = p / 10;
        int nj = p % 10;

        while (true) {
            if (!isValid(ni + D[d][0], nj + D[d][1])) break;

            ni += D[d][0];
            nj += D[d][1];

            if (board[ni][nj] == 'O') break;
        }

        return 10 * ni + nj;
    }

    static boolean isValid(int i, int j) {
        return (i >= 0 && j >= 0 && i < n && j < m && board[i][j] != '#');
    }

    static class Bid {
        int r, b;
        int distinct;
        int history;

        public Bid(int r, int b, int history, int d) {
            this.r = r;
            this.b = b;
            this.history = 10 * history + d;
            this.distinct = 100 * r + b;
        }
    }
}