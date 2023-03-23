package Programmers;

class 문자열압축 {
    public int solution(String s) {

        int result = s.length();

        for (int l = 1; l <= s.length()/2; l++) {
            String sub = s.substring(0, l);

            int i = l;
            int count = 1;
            int len = s.length();

            while (i < s.length()) {

                if (i + l > s.length()) break;

                String temp = s.substring(i, i + l);

                if (sub.equals(temp)) {
                    count++;
                } else {
                    len -= l * (count - 1);
                    if (count > 1) len += ("" + count).length();

                    sub = temp;
                    count = 1;
                }

                i += l;
            }

            if (count > 1) len += ("" + count).length() - (l * (count - 1));

            result = Math.min(result, len);
        }

        return result;
    }
}