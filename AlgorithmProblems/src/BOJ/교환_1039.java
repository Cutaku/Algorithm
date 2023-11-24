package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 교환_1039 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nk = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = nk[0], k = nk[1];

        int l = String.valueOf(n).length();

        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        q1.add(n);

        for (int t = 0; t < k; t++) {
            Set<Integer> set = new HashSet<>();

            while (!q1.isEmpty()) {
                int q = q1.poll();

                for (int i = 0; i < l - 1; i++) {
                    for (int j = i + 1; j < l; j++) {
                        int p = change(q, i, j);

                        if (p > 0 && set.add(p)) {
                            q2.add(p);
                        }
                    }
                }
            }

            if (q2.isEmpty()) {
                System.out.println(-1);
                return;
            }

            q1 = q2;
            q2 = new LinkedList<>();
        }

        int max = 0;

        while (!q1.isEmpty()) {
            max = Math.max(max, q1.poll());
        }

        System.out.println(max);
    }

    public static int change(int n, int i, int j) {

        char[] num = String.valueOf(n).toCharArray();

        if (i == 0 && num[j] == '0') return 0;

        char c = num[i];
        num[i] = num[j];
        num[j] = c;

        int result = 0;

        for (char m : num) {
            result *= 10;
            result += m - '0';
        }

        return result;
    }
}