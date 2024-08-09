package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 드래곤앤던전_16434 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        long a = Long.parseLong(st.nextToken());

        long life = 0;
        long min = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            if (st.nextToken().charAt(0) == '1') {
                life -= Long.parseLong(st.nextToken()) * ((Long.parseLong(st.nextToken()) - 1) / a);
                min = Math.min(min, life);
            } else {
                a += Long.parseLong(st.nextToken());
                life = Math.min(0, life + Long.parseLong(st.nextToken()));
            }
        }

        System.out.println(1 - min);
    }
}