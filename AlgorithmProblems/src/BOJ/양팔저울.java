package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 양팔저울 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] weights = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int m = Integer.parseInt(br.readLine());

        int[] beads = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Set<Integer> set = new HashSet<>();

        for (int weight : weights) {
            Set<Integer> temp = new HashSet<>();

            temp.add(weight);

            for (int pos : set) {
                temp.add(pos + weight);
                temp.add(Math.abs(pos - weight));
            }

            set.addAll(temp);
        }

        for (int bead : beads) {
            if (set.contains(bead)) {
                System.out.print("Y ");
            } else {
                System.out.print("N ");
            }
        }
    }
}