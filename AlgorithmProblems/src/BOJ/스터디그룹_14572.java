package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 스터디그룹_14572 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken()), d = Integer.parseInt(st.nextToken());

        Student[] students = new Student[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int m = Integer.parseInt(st.nextToken());
            students[i] = new Student(Integer.parseInt(st.nextToken()));

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) students[i].problems.add(Integer.parseInt(st.nextToken()) - 1);
        }

        Arrays.sort(students, Comparator.comparingInt(a -> a.level));

        int s = 0, e = 0;
        int[] cnt = new int[k];

        students[0].add(cnt);
        long ans = 0;

        while (e < n) {
            if (students[e].level - students[s].level <= d) {
                ans = Math.max(ans, efficiency(e - s + 1, cnt));

                if (++e < n) students[e].add(cnt);
            } else {
                students[s++].sub(cnt);
            }
        }

        System.out.println(ans);
    }

    static long efficiency(long c, int[] cnt) {

        int res = 0;
        for (int i : cnt) if (0 < i && i < c) res++;

        return res * c;
    }

    static class Student {

        int level;
        List<Integer> problems = new ArrayList<>();

        public Student(int level) {
            this.level = level;
        }

        void add(int[] cnt) {
            for (int p : problems) cnt[p]++;
        }

        void sub(int[] cnt) {
            for (int p : problems) cnt[p]--;
        }
    }
}