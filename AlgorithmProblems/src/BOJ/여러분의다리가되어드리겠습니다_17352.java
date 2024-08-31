package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 여러분의다리가되어드리겠습니다_17352 {
    static int[] root;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        root = new int[n];
        for (int i = 0; i < n; i++) root[i] = i;

        for (int i = 0; i < n - 2; i++) {
            st = new StringTokenizer(br.readLine());

            int a = find(Integer.parseInt(st.nextToken()) - 1);
            int b = find(Integer.parseInt(st.nextToken()) - 1);

            if (a > b) root[a] = b;
            else root[b] = a;
        }

        for (int i = 1; i < n; i++) {
            if (find(i) > 0) {
                System.out.println("1 " + (i + 1));
                return;
            }
        }
    }

    static int find(int a) {

        if (a == root[a]) return a;
        return root[a] = find(root[a]);
    }
}