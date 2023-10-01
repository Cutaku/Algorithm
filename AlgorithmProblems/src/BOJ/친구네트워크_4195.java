package BOJ;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class 친구네트워크_4195 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int f = Integer.parseInt(br.readLine());

            int[] roots = new int[100001];
            for (int i = 0; i <= 100000; i++) roots[i] = i;

            int[] count = new int[100001];

            Map<String, Integer> map = new HashMap<>();

            int m = 1;

            for (int i = 0; i < f; i++) {
                String[] friend = br.readLine().split(" ");
                String name1 = friend[0];
                String name2 = friend[1];

                if (map.containsKey(name1)) {
                    int r1 = findRoot(roots, map.get(name1));

                    if (map.containsKey(name2)) {
                        int r2 = findRoot(roots, map.get(name2));

                        if (r1 != r2) {
                            int c = count[r1] + count[r2];

                            int r = Math.min(r1, r2);

                            count[r] = c;

                            map.put(name1, r);
                            map.put(name2, r);

                            roots[r1] = r;
                            roots[r2] = r;
                        }
                    } else {
                        map.put(name2, r1);
                        count[r1]++;
                    }
                } else {
                    if (map.containsKey(name2)) {
                        int r = findRoot(roots, map.get(name2));

                        count[r]++;
                        map.put(name1, r);
                    } else {
                        count[m] = 2;

                        map.put(name1, m);
                        map.put(name2, m++);
                    }
                }

                int r = findRoot(roots, map.get(name1));

                bw.append(String.valueOf(count[r]));
                bw.append("\n");
            }
        }

        bw.flush();
    }

    public static int findRoot(int[] roots, int r) {

        if (r == roots[r]) return r;
        else return roots[r] = findRoot(roots, roots[r]);
    }
}