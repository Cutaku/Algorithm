package Programmers;

class 일이사나라의숫자 {
    public String solution(int n) {

        StringBuilder ans = new StringBuilder();

        while (n > 0) {
            int r = n % 3;
            n /= 3;

            if (r == 1) {
                ans.append("1");
            } else if (r == 2) {
                ans.append("2");
            } else {
                ans.append("4");
                n--;
            }
        }

        ans.reverse();

        return ans.toString();
    }
}