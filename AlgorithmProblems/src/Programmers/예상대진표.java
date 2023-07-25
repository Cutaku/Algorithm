package Programmers;

class 예상대진표
{
    public int solution(int n, int a, int b)
    {

        int ans = 0;

        while (a++ != b++) {
            a /= 2;
            b /= 2;
            ans++;
        }

        return ans;
    }
}