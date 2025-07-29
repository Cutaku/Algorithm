package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 소수쌍_1017 {
    static int n;
    static boolean[] isPrime;
    static List<Integer> odd, even;
    static List<Integer> left, right;
    static int l;
    static List<Integer>[] match;
    static int[] matched;
    static boolean[] v;

    public static void main(String[] args) throws IOException {

        setIsPrime();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        odd = new ArrayList<>();
        even = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int p = Integer.parseInt(st.nextToken());

            if (i == 0) {
                if (p % 2 == 0) {
                    left = even;
                    right = odd;
                } else {
                    left = odd;
                    right = even;
                }
            }

            if (p % 2 == 0) even.add(p);
            else odd.add(p);
        }

        if (left.size() != right.size()) {
            System.out.println(-1);
            return;
        }

        l = left.size();
        match = new List[l];

        Collections.sort(right);

        for (int i = 0; i < l; i++) match[i] = new ArrayList<>();

        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l; j++) {
                if (isPrime[left.get(i) + right.get(j)]) match[i].add(j);
            }
        }


        boolean flag = true;
        StringBuilder sb = new StringBuilder();

        for (int start : match[0]) {
            matched = new int[l];
            Arrays.fill(matched, -1);

            int cnt = 0;

            for (int i = 1; i < l; i++) {
                v = new boolean[l];

                if (dfs(i, start)) cnt++;
            }

            if (cnt == l - 1) {
                flag = false;
                sb.append(right.get(start)).append(" ");
            }
        }

        System.out.println(flag ? "-1" : sb);
    }

    static boolean dfs(int l, int fixed) {

        if (v[l]) return false;
        v[l] = true;

        for (int r : match[l]) {
            if (r == fixed) continue;

            if (matched[r] == -1 || dfs(matched[r], fixed)) {
                matched[r] = l;
                return true;
            }
        }

        return false;
    }

    static void setIsPrime() {

        isPrime = new boolean[2000];
        Arrays.fill(isPrime, true);

        for (int i = 3; i < 2000; i += 2) {
            if (!isPrime[i]) continue;

            for (int j = 3; i * j < 2000; j += 2) {
                isPrime[i * j] = false;
            }
        }
    }
}