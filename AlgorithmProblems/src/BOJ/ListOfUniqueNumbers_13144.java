package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ListOfUniqueNumbers_13144 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int i = 0;
        int j = 0;

        boolean[] used = new boolean[100001];
        used[arr[0]] = true;

        long count = 0;

        while (j < n) {
            if (j < n - 1 && !used[arr[j + 1]]) {
                used[arr[++j]] = true;
            } else if (i == j) {
                count++;
                i++;
                j++;
            } else {
                count += j - i + 1;
                used[arr[i++]] = false;
            }
        }

        System.out.println(count);
    }
}