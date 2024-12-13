package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class K번째수_7469 {
    static Node[] seg;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        seg = new Node[n << 2];

        st = new StringTokenizer(br.readLine());

        init(1, 0, n - 1);


        for (int t = 0; t < m; t++) {
            st = new StringTokenizer(br.readLine());

            int i = Integer.parseInt(st.nextToken()) - 1;
            int j = Integer.parseInt(st.nextToken()) - 1;
            int k = j - i + 1 - Integer.parseInt(st.nextToken());

            int s = -1000000001, e = 1000000000;

            while (e - s > 1) {
                int mid = (s + e) >> 1;

                if (countOverK(1, 0, n - 1, i, j, mid) <= k) e = mid;
                else s = mid;
            }

            sb.append(e).append("\n");
        }

        System.out.println(sb);
    }

    static int countOverK(int idx, int left, int right, int i, int j, int k) {

        if (right < i || j < left) return 0;

        if (i <= left && right <= j) {
            return seg[idx].countOverK(k);
        }

        int mid = (left + right) >> 1;

        return countOverK(idx << 1, left, mid, i, j, k) + countOverK(idx << 1 | 1, mid + 1, right, i, j, k);
    }

    static Node init(int idx, int left, int right) {
        if (left == right) {
            return seg[idx] = new Node(Integer.parseInt(st.nextToken()));
        }

        int mid = (left + right) >> 1;

        return seg[idx] = new Node(init(idx << 1, left, mid), init(idx << 1 | 1, mid + 1, right));
    }

    static class Node {
        int[] nums;

        Node(int n) {
            nums = new int[]{n};
        }

        Node(Node c1, Node c2) {
            nums = new int[c1.nums.length + c2.nums.length];

            int i = 0, j = 0;
            int k = 0;

            while (i < c1.nums.length || j < c2.nums.length) {
                if (i == c1.nums.length) {
                    nums[k++] = c2.nums[j++];
                } else if (j == c2.nums.length) {
                    nums[k++] = c1.nums[i++];
                } else {
                    if (c1.nums[i] < c2.nums[j]) {
                        nums[k++] = c1.nums[i++];
                    } else {
                        nums[k++] = c2.nums[j++];
                    }
                }
            }
        }

        int countOverK(int k) {
            if (nums[0] > k) return nums.length;
            if (nums[nums.length - 1] <= k) return 0;

            int s = 0, e = nums.length - 1;

            while (e - s > 1) {
                int m = (s + e) >> 1;

                if (nums[m] <= k) s = m;
                else e = m;
            }

            return nums.length - e;
        }
    }
}