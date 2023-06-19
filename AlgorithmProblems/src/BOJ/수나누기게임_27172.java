package BOJ;

import java.io.*;
import java.util.Arrays;

public class 수나누기게임_27172 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int blank = -1000001;

        int[] ans = new int[1000001];
        Arrays.fill(ans, blank);

        for (int num : arr) ans[num] = 0;

        for (int num : arr) {
            for (int i = 2; num * i <= 1000000; i++) {
                if (ans[num * i] > blank) {
                    ans[num]++;
                    ans[num * i]--;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            bw.append(ans[arr[i]] + " ");
        }

        bw.flush();
    }
}