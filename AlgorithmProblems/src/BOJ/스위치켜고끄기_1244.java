package BOJ;

import java.io.*;
import java.util.Arrays;

public class 스위치켜고끄기_1244 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] switches = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            int[] order = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            if (order[0] == 1) {
                for (int j = order[1] - 1; j < n; j += order[1]) {
                    switches[j] = 1 - switches[j];
                }
            } else {
                int c = order[1] - 1;

                int d = Math.min(c, n - c - 1);

                for (int j = 0; j <= d; j++) {
                    if (switches[c - j] == switches[c + j]) {
                        switches[c - j] = 1 - switches[c - j];
                        switches[c + j] = switches[c - j];
                    } else {
                        break;
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            bw.append(String.valueOf(switches[i]));
            if (i % 20 == 19) bw.append("\n");
            else bw.append(' ');
        }

        bw.flush();
    }
}