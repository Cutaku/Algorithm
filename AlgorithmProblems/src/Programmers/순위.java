package Programmers;

import java.util.*;

class 순위 {
    public int solution(int n, int[][] results) {

        Player[] Players = new Player[n + 1];
        for (int i = 1; i <= n; i++) Players[i] = new Player(i);

        Queue<Integer> w = new LinkedList<>();
        Queue<Integer> l = new LinkedList<>();

        for (int[] result : results) {
            boolean[] checked = new boolean[n + 1];

            w.add(result[0]);
            l.add(result[1]);

            checked[result[0]] = true;
            checked[result[1]] = true;

            Set<Integer> winners = Players[result[0]].lose;
            Set<Integer> losers = Players[result[1]].win;

            while (!w.isEmpty()) {
                Player winner = Players[w.poll()];
                winner.win.addAll(losers);

                for (int p : winner.lose) {
                    if (!checked[p]) {
                        checked[p] = true;
                        w.add(p);
                    }
                }
            }

            while (!l.isEmpty()) {
                Player loser = Players[l.poll()];
                loser.lose.addAll(winners);

                for (int p : loser.win) {
                    if (!checked[p]) {
                        checked[p] = true;
                        l.add(p);
                    }
                }
            }
        }

        int count = 0;

        for (int i = 1; i <= n; i++) {
            if (Players[i].count() == n + 1) count++;
        }

        return count;
    }

    class Player {
        Set<Integer> win = new HashSet<>();
        Set<Integer> lose = new HashSet<>();

        int count() {
            return win.size() + lose.size();
        }

        Player(int i) {
            this.win.add(i);
            this.lose.add(i);
        }
    }
}
