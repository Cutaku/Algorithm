package BOJ;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;

public class 삼육진수_1036 {
    static int[] convert;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        convert = new int[100];
        Number[] numbers = new Number[100];

        for (int i = '0'; i <= '9'; i++) {
            convert[i] = i - '0';
            numbers[i] = new Number((char)i);
        }

        for (int i = 'A'; i <= 'Z'; i++) {
            convert[i] = i - 'A' + 10;
            numbers[i] = new Number((char)i);
        }

        for (int i = 0; i < n; i++) {
            char[] num = br.readLine().toCharArray();

            int l = num.length;

            for (int j = 0; j < l; j++) {
                numbers[num[l - 1 - j]].count[j]++;
            }
        }

        for (int i = '0'; i <= '9'; i++) {
            to36(numbers[i].count);
            numbers[i].compare();
        }

        for (int i = 'A'; i <= 'Z'; i++) {
            to36(numbers[i].count);
            numbers[i].compare();
        }

        PriorityQueue<Number> pq = new PriorityQueue<>();

        pq.addAll(Arrays.asList(numbers).subList('0', '9' + 1));
        pq.addAll(Arrays.asList(numbers).subList('A', 'Z' + 1));

        int k = Integer.parseInt(br.readLine());

        int[] count = new int[53];

        while (!pq.isEmpty()) {
            Number number = pq.poll();

            if (k > 0 && number.num != 'Z') {
                number.num = 'Z';
                k--;
            }

            for (int i = 0; i < 53; i++) {
                count[i] += number.count[i] * convert[number.num];
            }
        }

        to36(count);

        boolean start = false;

        for (int i = 52; i >= 0; i--) {
            if (count[i] == 0 && !start) continue;

            start = true;

            if (count[i] < 10) {
                bw.append(String.valueOf(count[i]));
            } else {
                bw.append((char) ('A' + count[i] - 10));
            }
        }

        if (start) bw.flush();
        else System.out.println(0);
    }

    public static void to36(int[] count) {
        for (int i = 0; i < 52; i++) {
            if (count[i] >= 36) {
                count[i + 1] += count[i] / 36;
                count[i] %= 36;
            }
        }
    }

    public static class Number implements Comparable<Number> {

        char num;
        int[] count = new int[53];
        int[] compare = new int[53];

        public Number(char num) {
            this.num = num;
        }

        public void compare() {
            for (int i = 0; i < 53; i++) {
                compare[i] = count[i] * (convert['Z'] - convert[num]);
            }

            to36(compare);
        }

        @Override
        public int compareTo(Number o) {
            for (int i = 52; i >= 0; i--) {
                if (o.compare[i] == this.compare[i]) continue;

                return o.compare[i] - this.compare[i];
            }

            return this.num - o.num;
        }
    }
}