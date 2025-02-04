package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 팀빌딩_22945 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] abilities = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) abilities[i] = Integer.parseInt(st.nextToken());

        int l = 0, r = n - 1;
        int max = 0;

        while (r - l > 1) {
            max = Math.max(max, Math.min(abilities[l], abilities[r]) * (r - l - 1));

            if (abilities[l] < abilities[r]) l++;
            else r--;
        }

        System.out.println(max);
    }
}