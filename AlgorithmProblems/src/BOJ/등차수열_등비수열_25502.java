package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 등차수열_등비수열_25502 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        long[] arr = new long[n];
        arr[0] = Long.parseLong(st.nextToken());

        Storage dif = new Storage();
        Storage ratio = new Storage();

        for (int i = 1; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());

            dif.add(arr[i] - arr[i - 1]);
            if (arr[i] % arr[i - 1] == 0) ratio.add(arr[i] / arr[i - 1]);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int idx = Integer.parseInt(st.nextToken()) - 1;

            long tmp = arr[idx];
            arr[idx] = Long.parseLong(st.nextToken());

            if (idx > 0) {
                dif.delete(tmp - arr[idx - 1]);
                if (tmp % arr[idx - 1] == 0) ratio.delete(tmp / arr[idx - 1]);

                dif.add(arr[idx] - arr[idx - 1]);
                if (arr[idx] % arr[idx - 1] == 0) ratio.add(arr[idx] / arr[idx - 1]);
            }

            if (idx < n - 1) {
                dif.delete(arr[idx + 1] - tmp);
                if (arr[idx + 1] % tmp == 0) ratio.delete(arr[idx + 1] / tmp);

                dif.add(arr[idx + 1] - arr[idx]);
                if (arr[idx + 1] % arr[idx] == 0) ratio.add(arr[idx + 1] / arr[idx]);
            }

            sb.append(decide(dif, ratio, n));
        }

        System.out.println(sb);
    }

    static String decide(Storage dif, Storage ratio, int n) {

        if (dif.map.size() == 1 && dif.cnt == n - 1) return "+\n";
        else if (ratio.map.size() == 1 && ratio.cnt == n - 1) return "*\n";
        return "?\n";
    }

    static class Storage {

        Map<Long, Integer> map = new HashMap<>();
        int cnt = 0;

        void add(long x) {
            if (x < 1) return;

            cnt++;
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        void delete(long x) {
            if (x < 1) return;

            cnt--;
            if (map.get(x) == 1) {
                map.remove(x);
            } else {
                map.put(x, map.get(x) - 1);
            }
        }
    }
}