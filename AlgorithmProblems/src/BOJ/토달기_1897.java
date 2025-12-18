package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 토달기_1897 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int d = Integer.parseInt(st.nextToken());
        String word = st.nextToken();

        List<String>[] words = new ArrayList[79];
        for (int i = 0; i < 79; i++) words[i] = new ArrayList<>();

        for (int i = 0; i < d; i++) {
            String w = br.readLine();

            if (w.length() < 3) continue;
            
            words[w.length() - 3].add(w);
        }

        Queue<String> q = new ArrayDeque<>();

        q.add(word);

        String last = word;

        while (!q.isEmpty()) {
            last = q.poll();
            int l = last.length();

            for (String w : words[l - 2]) {
                if (check(last, w)) q.add(w);
            }
        }

        System.out.println(last);
    }

    static boolean check(String a, String b) {

        int l = a.length();
        int i = 0, j = 0;

        while (i < l && j - i < 2) {
            if (a.charAt(i) == b.charAt(j)) {
                i++;
            }

            j++;
        }

        return i == l;
    }
}