package Programmers;

class 두큐합같게만들기 {
    public int solution(int[] queue1, int[] queue2) {

        int ans1 = twoPoint(queue1, queue2);
        int ans2 = twoPoint(queue2, queue1);

        if (ans1 == -1) return ans2;
        if (ans2 == -1) return ans1;
        else return Math.min(ans1, ans2);
    }

    public int twoPoint(int[] queue1, int[] queue2) {
        int n = queue1.length;
        int m = queue2.length;

        int[] arr = new int[n + m];
        long s = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = queue1[i];
            s += queue1[i];
        }
        for (int i = 0; i < m; i++) {
            arr[n + i] = queue2[i];
        }

        int i = 0;
        int j = n;

        long sum = 0;
        for (int a : arr) sum += a;

        if (sum%2 == 1) return -1;

        int count = 0;
        while (j < n+m && s != sum/2) {
            if (s > sum/2) {
                s -= arr[i];
                i++;
                count++;
            } else {
                s += arr[j];
                j++;
                count++;
            }
        }

        if (s == sum/2) return count;
        else return -1;
    }
}