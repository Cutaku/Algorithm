package Programmers;

class 피로도 {
    static int max;
    static boolean[] done;

    public int solution(int k, int[][] dungeons) {

        int n = dungeons.length;
        done = new boolean[n];

        max = 0;

        dfs(dungeons, k);

        return max;
    }

    void dfs(int[][] dungeons, int k) {

        max = Math.max(max, count(done));
        int n = done.length;

        for (int i = 0; i < n; i++) {
            if (!done[i] && k >= dungeons[i][0]){
                done[i] = true;
                dfs(dungeons, k - dungeons[i][1]);
                done[i] = false;
            }
        }
    }

    int count(boolean[] done) {

        int result = 0;
        for (boolean b : done) if (b) result++;
        return result;
    }
}