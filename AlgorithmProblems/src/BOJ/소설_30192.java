package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 소설_30192 {
    static int n, k;
    static int[] group;
    static int gNum;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        group = new int[n];
        Arrays.fill(group, -1);

        char[] novel = br.readLine().toCharArray();

        int c = 1;
        int s = 0;
        gNum = 0;

        for (int i = 1; i <= n; i++) {
            if (i < n && novel[i] == novel[i - 1]) {
                c++;

                if (c > 2 * k - 2) {
                    System.out.println(k - 1);
                    return;
                }
            } else {
                if (c >= k) {

                    for (int j = i - k + 1; j <= s + k - 1; j++) {
                        group[j] = gNum;
                    }

                    gNum++;
                }

                c = 1;
                s = i;
            }
        }

        if (gNum == 0) {
            System.out.println(n);
            return;
        }

        for (int i = n - 1; i >= k ; i--) {
            if (pos(i)) {
                System.out.println(i);
                return;
            }
        }

        System.out.println(k - 1);
    }

    static boolean pos(int l) {

        int g = 0;

        for (int i = 1; i * l < n; i++) {
            if (group[i * l] >= 0) {
                if (group[i * l] != g++) return false;
            }
        }

        return g == gNum;
    }
}