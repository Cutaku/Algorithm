package SWExpertAcademy;

import java.io.*;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class 최대상금_1244 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            bw.append("#").append(String.valueOf(t)).append(" ");

            String[] input = br.readLine().split(" ");

            int c = Integer.parseInt(input[1]);

            int l = input[0].length();

            Queue<Integer> q1 = new LinkedList<>();
            Queue<Integer> q2 = new LinkedList<>();

            q1.add(Integer.parseInt(input[0]));

            for (int i = 0; i < c; i++) {
                Set<Integer> set = new HashSet<>();

                while (!q1.isEmpty()) {
                    int q = q1.poll();

                    for (int j = 0; j < l - 1; j++) {
                        for (int k = j + 1; k < l; k++) {
                            int p = change(q, j, k, l);

                            if (set.add(p)) {
                                q2.add(p);
                            }
                        }
                    }
                }

                q1 = q2;
                q2 = new LinkedList<>();
            }

            int max = 0;

            while (!q1.isEmpty()) {
                max = Math.max(max, q1.poll());
            }

            bw.append(String.valueOf(max)).append("\n");
        }

        bw.flush();
    }

    public static int change(int n, int i, int j, int l) {

        int[] num = new int[l];

        for (int k = l - 1; k >= 0; k--) {
            num[k] = n % 10;
            n /= 10;
        }

        int t = num[i];
        num[i] = num[j];
        num[j] = t;

        int result = 0;

        for (int k = 0; k < l; k++) {
            result *= 10;
            result += num[k];
        }

        return result;
    }
}