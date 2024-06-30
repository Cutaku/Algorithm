package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 태상이의훈련소생활_19951 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        int[] heights = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) heights[i] = Integer.parseInt(st.nextToken()); 
        
        int[] var = new int[n];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            
            int s = Integer.parseInt(st.nextToken()) - 1;
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            var[s] += v;
            if (e < n ) var[e] -= v;
        }

        for (int i = 0; i < n; i++) {
            if (i > 0) var[i] += var[i - 1];
            sb.append(heights[i] + var[i]).append(" ");
        }

        System.out.println(sb);
    }
}