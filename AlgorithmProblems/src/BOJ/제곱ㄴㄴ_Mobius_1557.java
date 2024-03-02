package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 제곱ㄴㄴ_Mobius_1557 {
    static List<Integer> mobiusList;
    static int[] mobius;
    static int max = (int) Math.sqrt(Integer.MAX_VALUE);

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine());

        initMobius();

        long s = k - 1;
        long e = 2L * k;

        while (e - s > 1) {
            long m = (s + e) / 2;

            if (countSquareFree((int) m) >= k) e = m;
            else s = m;
        }

        System.out.println(e);
    }

    static int countSquareFree(int n) {

        int res = 0;

        for (int i : mobiusList) {
            int count = mobius[i] * (n / i / i);

            if (count == 0) break;

            res += count;
        }

        return res;
    }

    static void initMobius() {

        mobiusList = new ArrayList<>();
        mobius = new int[max];
        mobius[1] = 1;

        for (int i = 1; i < max; i++) {
            if (mobius[i] == 0) continue;

            mobiusList.add(i);

            for (int j = 2; i * j < max; j++) {
                mobius[i * j] -= mobius[i];
            }
        }
    }
}