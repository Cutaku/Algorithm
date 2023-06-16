package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 부분수열의합_1208 {
    static int[] arr;
    static List<Integer> left;
    static List<Integer> right;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] ns = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = ns[0], s = ns[1];

        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int l = n / 2;

        left = new ArrayList<>();
        right = new ArrayList<>();

        dfs(0, 0, l, 0, true);
        dfs(l, l, n, 0, false);

        Collections.sort(left);
        Collections.sort(right);

        int i = 0;
        int j = right.size() - 1;

        long count = 0;

        while (i < left.size() && j >= 0) {
            int a = left.get(i);
            int b = right.get(j);

            if (a + b < s) {
                i++;
            } else if (a + b > s) {
                j--;
            } else {
                long lc = 0;
                long rc = 0;

                while (i < left.size() && left.get(i) == a) {
                    i++;
                    lc++;
                }

                while (j >= 0 && right.get(j) == b) {
                    j--;
                    rc++;
                }

                count += lc * rc;
            }
        }

        if (s == 0) count--;

        System.out.println(count);
    }

    static void dfs(int start, int now, int end, int sum, boolean isLeft) {

        if (now == end) {
            if (isLeft) left.add(sum);
            else right.add(sum);

            return;
        }

        dfs(start, now + 1, end, sum, isLeft);
        dfs(start, now + 1, end, sum + arr[now], isLeft);
    }
}