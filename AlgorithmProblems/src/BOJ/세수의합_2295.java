package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class 세수의합_2295 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(br.readLine());

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                set.add(arr[i] + arr[j]);
            }
        }

        int max = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (set.contains(Math.abs(arr[i] - arr[j]))) {
                    max = Math.max(max, Math.max(arr[i], arr[j]));
                }
            }
        }

        System.out.println(max);
    }
}