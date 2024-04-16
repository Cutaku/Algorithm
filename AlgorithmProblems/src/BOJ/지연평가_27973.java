package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 지연평가_27973 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int q = Integer.parseInt(br.readLine());

        long num = 1;
        long add = 0;
        long mul = 1;

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());

            char c = st.nextToken().charAt(0);

            if (c == '0') {
                add += Integer.parseInt(st.nextToken());
            } else if (c == '1') {
                int x = Integer.parseInt(st.nextToken());

                mul *= x;
                add *= x;
            } else if (c == '2') {
                num += Integer.parseInt(st.nextToken());
            } else {
                sb.append(num * mul + add).append("\n");
            }
        }

        System.out.println(sb);
    }
}