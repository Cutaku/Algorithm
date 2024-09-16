package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BuildingAField_16522 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[2 * n - 1];

        int sum = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];

            if (i < n - 1) arr[i + n] = arr[i];
        }

        if (sum % 2 == 1) {
            System.out.println('N');
            return;
        }

        sum >>= 1;

        for (int i = 0; i < 2 * n - 2; i++) arr[i + 1] += arr[i];

        for (int i = 0; i < n; i++) {
            int m = findMid(arr, i, i + n, sum);

            if (m == -1) continue;

            int l = i + 1, r = m + 1;

            while (l < m && r < i + n) {
                int s1 = arr[l] - arr[i], s2 = arr[r] - arr[m];

                if (s1 < s2) l++;
                else if (s2 < s1) r++;
                else {
                    System.out.println('Y');
                    return;
                }
            }
        }

        System.out.println('N');
    }

    static int findMid(int[] arr, int s, int e, int sum) {

        int l = s, r = e;

        while (r - l > 1) {
            int m = (l + r) >> 1;

            if (arr[m] - arr[s] > sum) r = m;
            else if (arr[m] - arr[s] < sum) l = m;
            else return m;
        }

        return -1;
    }
}