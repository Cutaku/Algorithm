package Programmers;

class 가장긴팰린드롬{
    public int solution(String s){

        int n = s.length();

        int ans = 1;

        boolean[][] isPalindrome = new boolean[n][n];

        for (int i = 0; i < n; i++) isPalindrome[i][i] = true;

        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                isPalindrome[i][i + 1] = true;
                ans = 2;
            }
        }

        for (int d = 2; d < n; d++) {
            for (int i = 0; i + d < n; i++) {
                if (s.charAt(i) == s.charAt(i + d) && isPalindrome[i + 1][i + d - 1]) {
                    isPalindrome[i][i + d] = true;
                    ans = d + 1;
                }
            }
        }

        return ans;
    }
}