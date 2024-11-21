package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 시프트연산_27740 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<int[]> count = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            int bit = Integer.parseInt(st.nextToken());

            if (bit == 1) {
                count.add(new int[]{i + 1, n - i});
            }
        }

        int l = count.size();

        int min = count.get(0)[1];
        int status = 0;

        if (min > count.get(l - 1)[0]) {
            min = count.get(l - 1)[0];
            status = 1;
        }

        int start = 0;

        for (int i = 0; i < l - 1; i++) {
            int[] left = count.get(i);
            int[] right = count.get(i + 1);

            if (min > 2 * left[0] + right[1]) {
                min = 2 * left[0] + right[1];
                status = 2;
                start = i;
            }

            if (min > left[0] + 2 * right[1]) {
                min = left[0] + 2 * right[1];
                status = 3;
                start = i;
            }
        }

        StringBuilder sb = new StringBuilder();

        sb.append(min).append("\n");

        if (status == 0) {
            sb.append("R".repeat(min));
        } else if (status == 1) {
            sb.append("L".repeat(min));
        } else if (status == 2) {
            int c = count.get(start)[0];
            sb.append("L".repeat(c));
            sb.append("R".repeat(min - c));
        } else {
            int c = count.get(start + 1)[1];
            sb.append("R".repeat(c));
            sb.append("L".repeat(min - c));
        }

        System.out.println(sb);
    }
}