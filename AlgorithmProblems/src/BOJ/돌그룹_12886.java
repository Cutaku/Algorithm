package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 돌그룹_12886 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[3];

        StringTokenizer st = new StringTokenizer(br.readLine());
        arr[0] = Integer.parseInt(st.nextToken());
        arr[1] = Integer.parseInt(st.nextToken());
        arr[2] = Integer.parseInt(st.nextToken());

        int sum = arr[0] + arr[1] + arr[2];

        if (sum % 3 > 0) {
            System.out.println(0);
            return;
        }

        Arrays.sort(arr);

        Set<Integer> v = new  HashSet<>();
        v.add(toInt(arr));

        int[][] idx = {{0, 1}, {0, 2}, {1, 2}};

        Queue<int[]> q = new ArrayDeque<>();
        q.add(arr);

        while (!q.isEmpty()) {
            int[] now = q.poll();

            if (now[0] == now[2]) {
                System.out.println(1);
                return;
            }

            for (int[] i : idx) {
                int[] tmp = now.clone();
                tmp[i[1]] -= tmp[i[0]];
                tmp[i[0]] *= 2;
                Arrays.sort(tmp);

                if (v.add(toInt(tmp))) q.add(tmp);
            }
        }

        System.out.println(0);
    }

    static int toInt(int[] arr) {

        return 10000000 * arr[2] + 1000 * arr[1] + arr[0];
    }
}