package SWExpertAcademy;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 가능한시험점수_3752 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            bw.append("#").append(String.valueOf(tc)).append(" ");

            int n = Integer.parseInt(br.readLine());

            int[] scores = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            Set<Integer> set = new HashSet<>();
            set.add(0);

            for (int score : scores) {
                Set<Integer> temp = new HashSet<>(set);

                for (int t : set) {
                    temp.add(t + score);
                }

                set = temp;
            }

            bw.append(String.valueOf(set.size())).append("\n");
        }
        bw.flush();
    }
}