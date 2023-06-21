package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 두배열의합_2143 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        int n = Integer.parseInt(br.readLine());
        int[] arr1 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] sum1 = new int[n + 1];
        for (int i = 1; i <= n; i++) sum1[i] = sum1[i - 1] + arr1[i - 1];


        int m = Integer.parseInt(br.readLine());
        int[] arr2 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] sum2 = new int[m + 1];
        for (int i = 1; i <= m; i++) sum2[i] = sum2[i - 1] + arr2[i - 1];

        List<Integer> lst1 = new ArrayList<>();
        List<Integer> lst2 = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                lst1.add(sum1[j] - sum1[i]);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j <= m; j++) {
                lst2.add(sum2[j] - sum2[i]);
            }
        }

        Collections.sort(lst1);
        Collections.sort(lst2);

        int i = 0;
        int j = lst2.size() - 1;

        long count = 0;

        while (i < lst1.size() && j >= 0) {
            int s1 = lst1.get(i);
            int s2 = lst2.get(j);

            if (s1 + s2 < t) {
                i++;
            } else if (s1 + s2 > t) {
                j--;
            } else {
                long c1 = 0;
                long c2 = 0;

                while (i < lst1.size() && lst1.get(i) == s1) {
                    i++;
                    c1++;
                }

                while (j >= 0 && lst2.get(j) == s2) {
                    j--;
                    c2++;
                }

                count += c1 * c2;
            }
        }

        System.out.println(count);
    }
}