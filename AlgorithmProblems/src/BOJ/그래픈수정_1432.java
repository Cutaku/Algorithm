package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.TreeSet;

public class 그래픈수정_1432 {
    static TreeSet<Integer>[] sets;
    static int idx;
    static int[] ans;
    static boolean[] used;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        char[][] aMat = new char[n][];
        for (int i = 0; i < n; i++) aMat[i] = br.readLine().toCharArray();

        sets = new TreeSet[n];
        for (int i = 0; i < n; i++) sets[i] = new TreeSet<>();

        int[] cNum = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (aMat[i][j] == '1') {
                    sets[j].add(i);
                    cNum[j]++;
                }
            }
        }

        Queue<Integer> q = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            if (cNum[i] == 0) q.add(i);
        }

        int count = 0;

        while (!q.isEmpty()) {
            int p = q.poll();
            count++;

            for (int i = 0; i < n; i++) {
                if (aMat[p][i] == '1') {
                    cNum[i]--;
                    sets[i].add(p);
                    sets[i].addAll(sets[p]);

                    if (cNum[i] == 0) q.add(i);
                }
            }
        }

        if (count < n) {
            System.out.println(-1);
            return;
        }

        ans = new int[n];
        used = new boolean[n];

        for (int i = 0; i < n; i++) {
            findSort(i);
        }

        for (int a : ans) {
            System.out.print(a + 1 + " ");
        }
    }

    static void findSort(int i) {

        if (used[i]) return;

        for (int child : sets[i]) {
            findSort(child);
        }

        ans[i] = idx++;
        used[i] = true;
    }
}