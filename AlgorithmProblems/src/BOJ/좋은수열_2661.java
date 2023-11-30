package BOJ;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class 좋은수열_2661 {
    static boolean fin;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        fin = false;

        dfs(new ArrayList<>(), Integer.parseInt(br.readLine()));
    }

    public static void dfs(List<Integer> list, int l) throws IOException {

        if (list.size() == l) {
            fin = true;

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            for (int num : list) {
                bw.append(String.valueOf(num));
            }

            bw.flush();

            return;
        }

        for (int i = 1; i <= 3; i++) {
            list.add(i);

            int s = list.size();

            boolean isGood = true;

            for (int j = 1; j <= s / 2; j++) {
                boolean isSame = true;

                for (int k = 1; k <= j; k++) {
                    if (!list.get(s - k).equals(list.get(s - j - k))) {
                        isSame = false;
                        break;
                    }
                }

                if (isSame) {
                    isGood = false;
                    break;
                }
            }

            if (isGood) {
                dfs(list, l);
            }

            list.remove(s - 1);

            if (fin) return;
        }
    }
}