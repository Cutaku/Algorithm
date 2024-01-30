package SWExpertAcademy;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Flatten_1208 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int tc = 1; tc <= 10; tc++) {
            bw.append(String.format("#%d ", tc));

            int dump = Integer.parseInt(br.readLine());

            PriorityQueue<Integer> min = new PriorityQueue<>();
            PriorityQueue<Integer> max = new PriorityQueue<>();

            Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                    .forEach(n -> {
                        min.add(n);
                        max.add(-n);
                    });

            while (dump-- > 0) {
                min.add(min.poll() + 1);
                max.add(max.poll() + 1);
            }

            bw.append(String.format("%d\n", -max.poll() - min.poll()));
        }
    }
}