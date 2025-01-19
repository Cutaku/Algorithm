package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 문자해독_1593 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int g = Integer.parseInt(st.nextToken()), s = Integer.parseInt(st.nextToken());

        int[] count = new int['z' + 1];
        int[] word = new int['z' + 1];

        String w = br.readLine();
        String string = br.readLine();

        for (int i = 0; i < g; i++) {
            word[w.charAt(i)]++;
            count[string.charAt(i)]++;
        }

        int ans = check(count, word)? 1 : 0;

        for (int i = g; i < s; i++) {
            count[string.charAt(i - g)]--;
            count[string.charAt(i)]++;

            if (check(count, word)) ans++;
        }

        System.out.println(ans);
    }

    static boolean check(int[] count, int[] word) {

        for (int i = 'A'; i <= 'Z'; i++) {
            if (count[i] != word[i]) return false;
        }

        for (int i = 'a'; i <= 'z'; i++) {
            if (count[i] != word[i]) return false;
        }

        return true;
    }
}