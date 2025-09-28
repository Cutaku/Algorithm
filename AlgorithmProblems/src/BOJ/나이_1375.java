package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 나이_1375 {
    static Map<String, List<String>> older;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new  StringTokenizer(br.readLine());
        st.nextToken();
        int m = Integer.parseInt(st.nextToken());

        older = new HashMap<>();

        for (int i = 0; i < m; i++) {
            st = new  StringTokenizer(br.readLine());

            String old =  st.nextToken();
            String young = st.nextToken();

            if (!older.containsKey(young)) older.put(young, new ArrayList<>());

            older.get(young).add(old);
        }

        int q =  Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < q; i++) {
            st =  new  StringTokenizer(br.readLine());

            String a = st.nextToken();
            String b = st.nextToken();

            if (a.equals(b)) sb.append("gg ");
            else if (isOlder(a, b)) sb.append(a).append(" ");
            else if (isOlder(b, a)) sb.append(b).append(" ");
            else sb.append("gg ");
        }

        System.out.println(sb);
    }

    static boolean isOlder(String a, String b) {

        Queue<String> q = new ArrayDeque<>();
        Set<String> v =  new HashSet<>();

        q.add(b);
        v.add(b);

        while (!q.isEmpty()) {
            String young = q.poll();

            if (young.equals(a)) return true;

            if (!older.containsKey(young)) continue;

            for (String old : older.get(young)) {
                if (!v.add(old)) continue;

                q.add(old);
            }
        }

        return false;
    }
}