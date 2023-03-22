package Programmers;

class 거리두기확인하기 {
    public int[] solution(String[][] places) {
        int[] answer = new int[5];

        for (int i = 0; i < 5; i++) {
            String[] place  = places[i];

            boolean flag = true;

            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    flag = flag && check(j, k, place);
                }
            }

            if (flag) answer[i] = 1;
        }

        return answer;
    }

    boolean check(int i, int j, String[] place) {
        if (place[i].charAt(j) != 'P') return true;

        int[][] dir = {{0,1}, {1,0}, {0,-1}, {-1,0}};

        for (int[] d : dir) {
            int ni = i + d[0];
            int nj = j + d[1];

            if (ni >= 5 || nj >= 5 || ni < 0 || nj < 0 || place[ni].charAt(nj) == 'X') continue;

            if (place[ni].charAt(nj) == 'P') return false;

            for (int[] dd : dir) {
                if (d[0] + dd[0] ==0 && d[1] + dd[1] == 0) continue;

                int nni = ni + dd[0];
                int nnj = nj + dd[1];

                if (nni >= 5 || nnj >= 5 || nni < 0 || nnj < 0) continue;

                if (place[nni].charAt(nnj) == 'P') return false;
            }
        }

        return true;
    }
}