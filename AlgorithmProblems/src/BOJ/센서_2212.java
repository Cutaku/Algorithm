package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 센서_2212 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        int[] station = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) station[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(station);

        int[] dist = new int[n - 1];
        for (int i = 0; i < n - 1; i++) dist[i] = station[i + 1] - station[i];

        Arrays.sort(dist);

        int ans = 0;

        for (int i = 0; i < n - k; i++) {
            ans += dist[i];
        }

        System.out.println(ans);
    }
}