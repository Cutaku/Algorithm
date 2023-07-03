package Programmers;

class 연속된부분수열의합 {
    public int[] solution(int[] sequence, int k) {

        int l = sequence.length;

        int[] sum = new int[l + 1];

        for (int i = 1; i <= l; i++) {
            sum[i] = sum[i - 1] + sequence[i - 1];
        }

        int[] ans = new int[]{0, l - 1};

        int i = 0;
        int j = 1;

        while (j <= l) {
            int d = sum[j] - sum[i];

            if (d < k) {
                if (j == l) break;

                j++;
            } else if (d > k) {
                i++;
            } else {
                if (j - i - 1 < ans[1] - ans[0]) {
                    ans[0] = i;
                    ans[1] = j - 1;
                }

                i++;
                j++;
            }
        }

        return ans;
    }
}