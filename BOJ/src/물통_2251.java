import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class 물통_2251 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] caps = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] init = new int[3];
        init[2] = caps[2];
        boolean[][] check = new boolean[caps[0]+1][caps[1]+1];

        Queue<int[]> q1 = new LinkedList<>();
        Queue<int[]> q2 = new LinkedList<>();

        q1.add(init);
        check[0][0] = true;

        List<Integer> list = new ArrayList<>();

        while (!q1.isEmpty()) {
            int[] waters = q1.poll();
            if (waters[0] == 0) list.add(waters[2]);

            for (int i = 0; i < 3; i++) {
                for (int j = i+1; j < 3; j++) {
                    int[] temp = move(caps, waters, i, j);

                    if (!check[temp[0]][temp[1]]) {
                        q2.add(temp);
                        check[temp[0]][temp[1]] = true;
                    }

                    temp = move(caps, waters, j, i);

                    if (!check[temp[0]][temp[1]]) {
                        q2.add(temp);
                        check[temp[0]][temp[1]] = true;
                    }
                }
            }

            if (q1.isEmpty()) {
                q1 = q2;
                q2 = new LinkedList<>();
            }
        }

        List<Integer> ans = list.stream()
                .distinct()
                .sorted()
                .collect(Collectors.toList());

        StringBuilder str = new StringBuilder();
        for (Integer n : ans) {
            str.append(n);
            str.append(" ");
        }

        System.out.println(str.toString());
    }

    static int[] move(int[] caps, int[] waters, int from, int to) {

        int[] result = new int[3];

        int n = Math.min(waters[from], caps[to] - waters[to]);

        result[from] = waters[from] - n;
        result[to] = waters[to] + n;
        result[3-from-to] = waters[3-from-to];

        return result;
    }
}