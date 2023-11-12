package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class 서로소의개수_1750 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Map<Integer, Integer> count = new HashMap<>();
        count.put(0, 0);

        for (int i = 0; i < n; i++) {
            int s = Integer.parseInt(br.readLine());

            Map<Integer, Integer> temp = new HashMap<>();

            for (int key : count.keySet()) {
                add(temp, key, count.get(key));

                int g = findGDC(s, key);

                add(temp, g, count.get(key));
            }

            add(temp, s, 1);

            count = temp;
        }

        if (count.containsKey(1)) System.out.println(count.get(1));
        else System.out.println(0);
    }

    public static void add(Map<Integer, Integer> map, int a, int b) {

        int d = 10000003;

        if (map.containsKey(a)) {
            map.put(a, (map.get(a) + b) % d);
        } else {
            map.put(a, b % d);
        }
    }

    public static int findGDC(int a, int b) {

        while (b > 0) {
            int c = a;

            a = b;
            b = c % b;
        }

        return a;
    }
}