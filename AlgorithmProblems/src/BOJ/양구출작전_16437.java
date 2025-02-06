package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 양구출작전_16437 {
    static List<Integer>[] children;
    static int[] cnt;
    static boolean[] isSheep;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        children = new List[n];
        for (int i = 0; i < n; i++) children[i] = new ArrayList<>();

        cnt = new int[n];
        isSheep = new boolean[n];

        StringTokenizer st;
        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            isSheep[i] = st.nextToken().charAt(0) == 'S';
            cnt[i] = Integer.parseInt(st.nextToken());
            children[Integer.parseInt(st.nextToken()) - 1].add(i);
        }

        System.out.println(count(0));
    }

    static long count(int i) {

        long res = cnt[i] * (isSheep[i] ? 1 : -1);

        for (int child : children[i]) {
            res += count(child);
        }

        return Math.max(0, res);
    }
}