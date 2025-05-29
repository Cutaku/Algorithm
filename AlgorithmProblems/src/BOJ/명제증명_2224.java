package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 명제증명_2224 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        boolean[][] adj = new boolean[52][52];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();

            char from = line.charAt(0);
            char to = line.charAt(5);

            adj[toInt(from)][toInt(to)] = true;
        }

        for (int k = 0; k < 52; k++) {
            for (int i = 0; i < 52; i++) {
                if (i == k) continue;

                for (int j = 0; j < 52; j++) {
                    if (j == k || j == i) continue;

                    if (adj[i][k] && adj[k][j]) adj[i][j] = true;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        int c = 0;

        for (int i = 0; i < 52; i++) {
            for (int j = 0; j < 52; j++) {
                if (i == j) continue;

                if (adj[i][j]) {
                    c++;
                    sb.append(toChar(i)).append(" => ").append(toChar(j)).append("\n");
                }
            }
        }

        System.out.println(c);
        System.out.println(sb);
    }

    static int toInt(char c) {

        if (c > 'Z') return c - 'a' + 26;
        else return c - 'A';
    }

    static char toChar(int a) {

        if (a > 25) return (char) (a - 26 + 'a');
        else return (char) (a + 'A');
    }
}