package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 기하가너무좋아_28067 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
        int l = (n + 1) * (m + 1);

        int[][] v = new int[l][];

        for (int i = 0; i < l; i++) {
            v[i] = new int[]{i / (m + 1), i % (m + 1)};
        }

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < l - 2; i++) {
            for (int j = i + 1; j < l - 1; j++) {
                for (int k = j + 1; k < l; k++) {
                    if (onStraight(v[i], v[j], v[k])) continue;

                    int a = dist(v[i], v[j]);
                    int b = dist(v[i], v[k]);
                    int c = dist(v[j], v[k]);

                    set.add(toInt(new int[]{a, b, c}));
                }
            }
        }

        System.out.println(set.size());
    }

    static int dist(int[] a, int[] b) {

        return (a[0] - b[0]) * (a[0] - b[0]) +  (a[1] - b[1]) * (a[1] - b[1]);
    }

    static int toInt(int[] arr) {

        Arrays.sort(arr);

        return arr[0] + 1000 * arr[1] + 1000000 * arr[2];
    }

    static boolean onStraight(int[] a, int[] b, int[] c) {

        return (b[1] - a[1]) * (c[0] - b[0]) == (c[1] - b[1]) * (b[0] - a[0]);
    }
}