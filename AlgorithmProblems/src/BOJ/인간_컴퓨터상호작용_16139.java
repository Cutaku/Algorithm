package BOJ;

import java.io.*;

public class 인간_컴퓨터상호작용_16139 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();

        int l = str.length();

        int q = Integer.parseInt(br.readLine());

        int[][] count = new int[150][l + 1];

        for (int i = 1; i <= l; i++) {
            count[str.charAt(i - 1)][i]++;
        }

        for (int i = 'a'; i <= 'z'; i++) {
            for (int j = 1; j <= l; j++) {
                count[i][j] += count[i][j - 1];
            }
        }

        for (int i = 0; i < q; i++) {
            String[] query = br.readLine().split(" ");

            char c = query[0].charAt(0);

            int s = Integer.parseInt(query[1]);
            int e = Integer.parseInt(query[2]);

            bw.append(String.valueOf(count[c][e + 1] - count[c][s])).append("\n");
        }

        bw.flush();
    }
}