package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 가장긴증가하는부분수열6_17411 {
    static final int d = 1000000007;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Store[] stores = new Store[n + 1];

        int c = 0;

        for (int num : arr) {
            if (c == 0) {
                stores[c++] = new Store(num, 1);
                continue;
            } else if (num <= stores[0].last) {
                stores[0].add(num, 1);
                continue;
            } else if (num > stores[c - 1].last) {
                stores[c] = new Store(num, stores[c++ - 1].countLower(num));
                continue;
            }

            int s = 0;
            int e = c - 1;

            while (e - s > 1) {
                int m = (e + s) / 2;

                if (num <= stores[m].last) e = m;
                else s = m;
            }

            stores[e].add(num, stores[s].countLower(num));
        }

        Store store = stores[c - 1];

        System.out.printf("%d %d", c, store.counts.get(store.size));
    }

    static class Store {
        List<Integer> nums = new ArrayList<>();
        List<Integer> counts = new ArrayList<>();
        int size = 1;
        int last;

        public Store(int num, int count) {
            nums.add(Integer.MAX_VALUE);
            nums.add(num);
            last = num;
            counts.add(0);
            counts.add(count);
        }

        public void add(int num, int count) {
            nums.add(num);
            last = num;
            counts.add((count + counts.get(size++)) % d);
        }

        public int countLower(int num) {
            if (nums.get(1) < num) return counts.get(size);

            int s = 0;
            int e = size;

            while (e - s > 1) {
                int m = (e + s) / 2;

                if (nums.get(m) < num) e = m;
                else s = m;
            }

            return (counts.get(size) - counts.get(s) + d) % d;
        }
    }
}