package Programmers;

import java.util.*;

class 신고결과받기 {
    public int[] solution(String[] id_list, String[] report, int k) {

        Map<String, User> map = new HashMap<>();

        for (String id : id_list) {
            map.put(id, new User());
        }

        for (String rep : report) {
            String[] arr = rep.split(" ");
            String reporter = arr[0];
            String reported = arr[1];

            if (map.get(reporter).report.add(reported)) {
                map.get(reported).count++;
            }
        }

        int[] result = new int[id_list.length];

        for (int i = 0; i < id_list.length; i++) {
            User user = map.get(id_list[i]);

            for (String s : user.report) {
                if (map.get(s).count >= k) result[i]++;
            }
        }


        return result;
    }

    class User {
        Set<String> report = new HashSet<>();
        int count = 0;
    }
}