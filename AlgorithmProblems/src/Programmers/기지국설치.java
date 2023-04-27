package Programmers;

class 기지국설치 {
    public int solution(int n, int[] stations, int w) {

        int width = 2 * w + 1;
        int l = stations.length;

        int[] s = new int[l + 2];
        s[0] =  -1 * w;
        s[l + 1] = n + w + 1;
        for (int i = 0; i < l; i++) s[i + 1] = stations[i];

        int ans = 0;

        for (int i = 0; i < l + 1; i++) {
            double distance = s[i + 1] - s[i] - width;

            if (distance <= 0) continue;

            ans += Math.ceil(distance / width);
        }

        return ans;
    }
}