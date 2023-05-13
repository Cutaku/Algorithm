package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 구간자르기_2283 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nk = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = nk[0], k = nk[1];

        int[][] intervals = new int[n][];
        for (int i = 0; i < n; i++) intervals[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] line = new int[1000002];

        for (int[] interval : intervals) {
            line[interval[0] + 1]++;
            line[interval[1] + 1]--;
        }

        for (int i = 1; i < 1000001; i++) {
            line[i] += line[i - 1];
        }

        for (int i = 1; i < 1000001; i++) {
            line[i] += line[i - 1];
        }

        int a = 0;
        int b = 0;

        boolean flag = false;

        while (b < 1000001) {
            if (line[b] - line[a] < k) {
                b++;
            } else if (line[b] - line[a] > k) {
                a++;
            } else {
                flag = true;
                break;
            }
        }

        if (flag) System.out.println(a + " " + b);
        else System.out.println("0 0");
    }
}