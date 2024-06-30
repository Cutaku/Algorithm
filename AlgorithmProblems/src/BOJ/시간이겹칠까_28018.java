package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 시간이겹칠까_28018 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] seats = new int[1000002];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            seats[Integer.parseInt(st.nextToken())]++;
            seats[Integer.parseInt(st.nextToken()) + 1]--;
        }

        for (int i = 1; i < 1000002; i++) {
            seats[i] += seats[i - 1];
        }

        int q = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < q; i++) {
            sb.append(seats[Integer.parseInt(st.nextToken())]).append("\n");
        }

        System.out.println(sb);
    }
}