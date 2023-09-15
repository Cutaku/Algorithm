package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class 앱_7579 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = nm[0], m = nm[1];

        int[] memories = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] costs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[][] apps = new int[n][];
        for (int i = 0; i < n; i++) apps[i] = new int[]{costs[i], memories[i]};

        Arrays.sort(apps, Comparator.comparingInt(a -> a[0]));

        int[] max = new int[10001];

        for (int i = 0; i < n; i++) {
            int cost = apps[i][0];
            int memory = apps[i][1];

            int[] temp = new int[10001];



            for (int j = 0; j < cost; j++) {
                temp[j] = max[j];
            }

            for (int j = cost; j < 10001; j++) {
                temp[j] = Math.max(max[j], max[j - cost] + memory);
            }

            max = temp;
        }

        for (int i = 0; i < 10001; i++) {
            if (max[i] >= m) {
                System.out.println(i);
                return;
            }
        }
    }
}