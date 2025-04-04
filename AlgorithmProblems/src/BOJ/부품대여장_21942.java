package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class 부품대여장_21942 {
    static int[] monthDate = {0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        String[] l = st.nextToken().split("/");
        int f = Integer.parseInt(st.nextToken());

        long d = toMinute("0-1-" + l[0], l[1]);

        Map<String, Long> lent = new HashMap<>();
        Map<String, Long> charge = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            long t = toMinute(st.nextToken(), st.nextToken());
            String part = st.nextToken();
            String name = st.nextToken();

            String key = part + name;

            if (!lent.containsKey(key)) {
                lent.put(key, t);
            } else {
                long diff = t - lent.get(key);

                if (diff > d) {
                    charge.put(name, charge.getOrDefault(name, 0L) + (diff - d) * f);
                }

                lent.remove(key);
            }
        }

        if (charge.isEmpty()) {
            System.out.println(-1);
        } else {
            StringBuilder sb = new StringBuilder();

            for (String key : charge.keySet()) {
                sb.append(key).append(" ").append(charge.get(key)).append("\n");
            }

            System.out.println(sb);
        }
    }

    static long toMinute(String date, String time) {

        StringTokenizer st = new StringTokenizer(date, "-");
        st.nextToken();

        int month = Integer.parseInt(st.nextToken());
        int day = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(time, ":");
        int hour = Integer.parseInt(st.nextToken());
        int minute = Integer.parseInt(st.nextToken());

        day += monthDate[month - 1];
        hour += 24 * day;
        minute += 60 * hour;

        return minute;
    }
}