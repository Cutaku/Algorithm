package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 나무블록_4912 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer>[] list = new List[9];
        for (int i = 0; i < 9; i++) list[i] = new ArrayList<>();

        list[1].add(4);
        list[1].add(5);
        list[3].add(4);
        list[3].add(5);
        list[4].add(2);
        list[4].add(3);
        list[5].add(8);
        list[6].add(2);
        list[6].add(3);
        list[7].add(8);
        list[8].add(6);
        list[8].add(7);

        String input = br.readLine();
        StringBuilder sb = new StringBuilder();
        int t = 1;

        a: while (!input.equals("0")) {
            sb.append(t++);
            int[] arr = Arrays.stream(input.split("")).mapToInt(Integer::parseInt).toArray();

            input = br.readLine();

            for (int i = 0; i < arr.length - 1; i++) {
                if (!list[arr[i]].contains(arr[i + 1])) {
                    sb.append(". NOT\n");
                    continue a;
                }
            }

            sb.append(arr[0] == 1 && arr[arr.length - 1] == 2 ? ". VALID\n" : ". NOT\n");
        }

        System.out.println(sb);
    }
}