package Programmers;

class 타켓넘버 {
    static int n;
    static int count;
    static int sum;
    static int[] nums;
    static boolean[] used;

    public int solution(int[] numbers, int target) {

        n = numbers.length;
        count = 0;
        sum = 0;
        nums = numbers;
        used = new boolean[n];

        for (int num : nums) sum += num;

        dfs(0, target);

        return count;
    }

    void dfs(int s, int target) {

        if (sum == target) count++;
        if (sum <= target) return;

        for (int i = s; i < n; i++) {
            if (used[i]) continue;

            sum -= nums[i] * 2;
            used[i] = true;
            dfs(i, target);
            sum += nums[i] * 2;
            used[i] = false;
        }
    }
}