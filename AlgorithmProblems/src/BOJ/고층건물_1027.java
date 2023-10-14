package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 고층건물_1027 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        long[] buildings = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();

        int[] count = new int[n];

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                boolean visible = true;

                for (int k = i + 1; k < j; k++) {
                    if ((j - i) * (buildings[k] - buildings[i]) >= (k - i) * (buildings[j] - buildings[i])) {
                        visible = false;
                        break;
                    }
                }

                if (visible) {
                    count[i]++;
                    count[j]++;
                }
            }
        }

        int max = 0;

        for (int i = 0; i < n; i++) {
            max = Math.max(max, count[i]);
        }

        System.out.println(max);
    }
}