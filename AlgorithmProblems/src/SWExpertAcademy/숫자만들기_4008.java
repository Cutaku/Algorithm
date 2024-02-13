package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 숫자만들기_4008 {
    private static int N, MIN, MAX;
    private static int[] nums;
    private static char[] sig, arr;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            MIN = Integer.MAX_VALUE;
            MAX = -100000001;
            N = Integer.parseInt(br.readLine());
            String[] s = br.readLine().split(" ");
            sig = new char[N-1];
            arr = new char[N-1];
            nums = new int[N];
            visited = new boolean[N-1];
            for (int j = 0, k = 0; j < 4; j++) {
                if(Integer.parseInt(s[j]) > 0) {
                    for (int i = 0; i < Integer.parseInt(s[j]); i++) {
                        if(j==0) {
                            sig[k++] = '+';
                        }else if(j==1) {
                            sig[k++] = '-';
                        }else if(j==2) {
                            sig[k++] = '*';
                        }else sig[k++] = '/';
                    }
                }
            }
            s = br.readLine().split(" ");
            for (int j = 0; j < N; j++)
                nums[j] = Integer.parseInt(s[j]);
            recur(1, nums[0]);
            System.out.println("#"+test_case+" "+(MAX-MIN));
        }
    }

    private static void recur(int cnt, int val) {
        if(cnt==N) {
            MAX = Math.max(MAX, val);
            MIN = Math.min(MIN, val);
            return;
        }
        for (int i = 0; i < N-1; i++) {
            if(!visited[i]) {
                visited[i] = true;
                if(sig[i]=='+') {
                    recur(cnt+1, val+nums[cnt]);
                }else if(sig[i]=='-') {
                    recur(cnt+1, val-nums[cnt]);
                }else if(sig[i]=='*') {
                    recur(cnt+1, val*nums[cnt]);
                }else recur(cnt+1, val/nums[cnt]);
                visited[i] = false;
            }
        }
    }
}