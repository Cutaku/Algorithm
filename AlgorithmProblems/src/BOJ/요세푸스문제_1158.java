package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class 요세푸스문제_1158 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nk = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = nk[0], k = nk[1];

        List<Integer> list = new LinkedList<>();
        for (int i = 1; i <= n; i++) list.add(i);

        int index = k - 1;

        int[] ans = new int[n];

        int c = n;

        for (int i = 0; i < n; i++) {
            ans[i] = list.get(index);
            list.remove(index--);
            c--;

            if (c == 0) break;

            index += k;
            index %= c;
        }

        System.out.println(Arrays.toString(ans).replace("[", "<").replace("]", ">"));
    }
}