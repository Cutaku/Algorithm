package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 알고리즘수업_선택정렬6_23900 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arrA = new int[n];
        int[] arrB = new int[n];
        int[] arrC = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) arrA[i] = arrC[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arrC);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) map.put(arrC[i], i);

        for (int i = 0; i < n; i++) {
            arrA[i] = map.get(arrA[i]);
            arrC[arrA[i]] = i;
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int b = Integer.parseInt(st.nextToken());

            if (map.containsKey(b)) {
                arrB[i] = map.get(b);
            } else {
                System.out.println(0);
                return;
            }
        }

        int idx = n - 1;

        while (idx >= 0 && idx == arrB[idx]) {
            arrA[arrC[idx]] = arrA[idx];
            arrC[arrA[idx]] = arrC[idx--];
        }

        while (idx >= 0) {
            if (arrA[idx] != arrB[idx--]) {
                System.out.println(0);
                return;
            }
        }

        System.out.println(1);
    }
}