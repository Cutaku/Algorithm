package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 일루수가누구야_17349 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] props = new int[9][];

        StringTokenizer st;

        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            props[i] = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        }

        List<Integer> ans = new ArrayList<>();

        for (int i = 1; i <= 9; i++) {
            int cnt = 0;

            for (int j = 0; j < 9; j++) {
                cnt += ((props[j][0] == 1) ^ (props[j][1] == i)) ? 1 : 0;
            }

            if (cnt == 1) ans.add(i);
        }

        System.out.println(ans.size() == 1 ? ans.get(0) : -1);
    }
}