package BOJ;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 암호만들기_1759 {
    static BufferedWriter bw;
    static int l;
    static int c;
    static char[] chars;
    static boolean[] used;
    static List<Character> list;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] lc = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        l = lc[0];
        c = lc[1];

        String[] arr = br.readLine().split(" ");

        chars = new char[c];
        for (int i = 0; i < c; i++) chars[i] = arr[i].charAt(0);

        Arrays.sort(chars);

        used = new boolean[c];

        list = new ArrayList<>();

        dfs(0, 0, 0, 0);

        bw.flush();
    }

    public static void dfs(int d, int s, int cons, int vow) throws IOException {

        if (d == l) {
            if (vow < 1 || cons < 2) return;

            for (int i = 0; i < l; i++) {
                bw.append(list.get(i));
            }

            bw.append("\n");
        }

        for (int i = s; i < c; i++) {
            if (used[i]) continue;

            list.add(chars[i]);

            used[i] = true;

            if (isVowel(chars[i])) dfs(d + 1, i + 1, cons, vow + 1);
            else dfs(d + 1, i + 1, cons + 1, vow);

            list.remove(d);

            used[i] = false;
        }
    }

    public static boolean isVowel(char c) {

        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}