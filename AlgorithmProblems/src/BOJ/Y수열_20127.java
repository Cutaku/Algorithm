package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Y수열_20127 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        int ans = Math.min(increase(arr), decrease(arr));

        System.out.println(ans == Integer.MAX_VALUE ? -1: ans);
    }

    static int increase(int[] arr){

        int idx = 0;
        boolean flag = arr[0] < arr[arr.length-1];

        for(int i = 1; i < arr.length; i++){
            if (arr[i] < arr[i - 1]) {
                if (flag) {
                    return Integer.MAX_VALUE;
                } else {
                    flag = true;
                    idx = i;
                }
            }
        }

        return flag ? idx : 0;
    }

    static int decrease(int[] arr){

        int idx = 0;
        boolean flag = arr[0] > arr[arr.length-1];

        for(int i = 1; i < arr.length; i++){
            if (arr[i] > arr[i - 1]) {
                if (flag) {
                    return Integer.MAX_VALUE;
                } else {
                    flag = true;
                    idx = i;
                }
            }
        }

        return flag ? idx : 0;
    }
}