package Programmers;

class 괄호변환 {
    public String solution(String p) {

        if (p.length() == 0) return p;

        char[] arr = p.toCharArray();
        int n = arr.length;

        int count = 1;
        int m = 1;

        for (int i = 1; i < n; i++) {
            if (arr[i] == arr[0]) count++;
            else count--;

            if (count == 0) {
                m = i + 1;
                break;
            }
        }

        String front = "";
        String back = "";

        for (int i = 0; i < m; i++) front += arr[i];
        for (int i = m; i < n; i++) back += arr[i];

        if (arr[0] == '(') return front + solution(back);

        String result = "(";
        result += solution(back) + ')';

        for (int i = 1; i < m - 1; i++) {
            if (arr[i] == '(') result += ')';
            else result += '(';
        }

        return result;
    }
}