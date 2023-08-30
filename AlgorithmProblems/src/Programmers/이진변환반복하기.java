package Programmers;

class 이진변환반복하기 {
    public int[] solution(String s) {

        int[] ans = new int[2];
        ans[0] = 1;

        int n = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') n++;
            else ans[1]++;
        }

        while (n > 1) {
            ans[0]++;

            int t = 0;

            while (n > 0) {
                if (n % 2 == 1) t++;
                else ans[1]++;

                n /= 2;
            }

            n = t;
        }

        return ans;
    }
}