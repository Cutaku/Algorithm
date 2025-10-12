package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 식물기르기_32407 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] toIdx = new int[65537];
        for (int i = 0; i < 17; i++) toIdx[1 << i] = i;

        int[] cnt = new int[17];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) cnt[toIdx[Integer.parseInt(st.nextToken())]]++;

        for (int i = 16; i > 0; i--) {
            cnt[i - 1] += (cnt[i] + 1) / 2;
        }

        System.out.println(cnt[0]);
    }
}