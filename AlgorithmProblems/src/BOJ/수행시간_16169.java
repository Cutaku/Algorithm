package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 수행시간_16169 {
    static List<Computer>[] computers;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        computers = new List[n];
        for (int i = 0; i < n; i++) computers[i] = new ArrayList<>();

        int maxC = 0;

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int c = Integer.parseInt(st.nextToken()) - 1;
            int t = Integer.parseInt(st.nextToken());

            computers[c].add(new Computer(i, c, t));
            maxC = Math.max(maxC, c);
        }

        int ans = 0;

        for (Computer computer : computers[maxC]) {
            ans = Math.max(ans, computer.finTime());
        }

        System.out.println(ans);
    }

    static class Computer {

        int idx;
        int c;
        int activeTime;
        int finTime = 0;

        Computer(int idx, int c, int activeTime) {
            this.idx = idx;
            this.c = c;
            this.activeTime = activeTime;
        }

        int finTime() {
            if (finTime > 0) return finTime;

            if (c > 0) {
                for (Computer computer : computers[c - 1]) {
                    finTime = Math.max(finTime, computer.finTime() + (idx - computer.idx) * (idx - computer.idx));
                }
            }

            finTime += activeTime;

            return finTime;
        }
    }
}