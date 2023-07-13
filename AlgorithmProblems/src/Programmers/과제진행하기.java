package Programmers;

import java.util.*;

class 과제진행하기 {
    public String[] solution(String[][] plans) {

        int l = plans.length;

        Arrays.sort(plans, (p1, p2) -> toInt(p1[1]) - toInt(p2[1]));

        Stack<Assignment> delayed = new Stack<>();

        String[] ans = new String[l];
        int ind = 0;

        for (int i = 0; i < l; i++) {
            String[] plan = plans[i];

            Assignment toDo = new Assignment(plan[0], plan[1], plan[2]);

            int next = 200000;

            if (i < l - 1) {
                next = toInt(plans[i + 1][1]);
            }

            int now = toDo.start;

            while (now + toDo.left <= next) {
                now += toDo.left;
                ans[ind++] = toDo.subject;
                toDo.left = 0;

                if (!delayed.isEmpty()) {
                    toDo = delayed.pop();
                } else {
                    break;
                }
            }

            if (toDo.left > 0) {
                toDo.left -= next - now;
                delayed.add(toDo);
            }
        }

        return ans;
    }

    class Assignment {

        String subject;
        int start;
        int left;

        Assignment(String subject, String start, String left) {
            this.subject = subject;
            this.start = toInt(start);
            this.left = Integer.parseInt(left);
        }
    }

    int toInt(String time) {

        String[] hm = time.split(":");

        return 60 * Integer.parseInt(hm[0]) + Integer.parseInt(hm[1]);
    }
}