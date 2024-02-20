package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 음주코딩_5676 {
    static int n;
    static int[] arr;
    static int[] minus;
    static int[] zero;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        String input;

        while ((input = br.readLine()) != null) {
            st = new StringTokenizer(input);
            n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            arr = new int[n + 1];
            minus = new int[n + 1];
            zero = new int[n + 1];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());

                int j = i;

                if (arr[i] < 0) {
                    while (j <= n) {
                        minus[j]++;
                        j += j & -j;
                    }
                } else if (arr[i] == 0) {
                    while (j <= n) {
                        zero[j]++;
                        j += j & -j;
                    }
                }
            }

            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());

                if (st.nextToken().equals("C")) {
                    modify(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
                } else {
                    int s = Integer.parseInt(st.nextToken());
                    int e = Integer.parseInt(st.nextToken());

                    int z = sum(e, true) - sum(s - 1, true);

                    if (z > 0) {
                        sb.append('0');
                    } else {
                        int m = sum(e, false) - sum(s - 1, false);
                        if (m % 2 == 0) sb.append('+');
                        else sb.append('-');
                    }
                }
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void modify(int i, int num) {

        if (arr[i] == num && num == 0) return;
        if (arr[i] * num > 0) return;

        boolean wasZero = arr[i] == 0;
        boolean wasNegative = arr[i] < 0;

        arr[i] = num;

        if (arr[i] < 0) {
            while (i <= n) {
                minus[i]++;
                if (wasZero) zero[i]--;
                i += i & -i;
            }
        } else if (arr[i] == 0) {
            while (i <= n) {
                zero[i]++;
                if (wasNegative) minus[i]--;
                i += i & -i;
            }
        } else {
            while (i <= n) {
                if (wasZero) zero[i]--;
                if (wasNegative) minus[i]--;
                i += i & -i;
            }
        }
    }

    static int sum(int i, boolean isZero) {

        int res = 0;

        while (i > 0) {
            if (isZero) res += zero[i];
            else res += minus[i];
            i -= i & -i;
        }

        return res;
    }
}