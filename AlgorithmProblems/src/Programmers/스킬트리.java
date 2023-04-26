package Programmers;

import java.util.*;

class 스킬트리 {
    public int solution(String skill, String[] skill_trees) {

        Map<Character, Character> map = new HashMap<>();

        for (int i = 0; i < skill.length() - 1; i++) {
            map.put(skill.charAt(i), skill.charAt(i + 1));
        }

        int count = 0;

        for (String skill_tree : skill_trees) {
            if (pos(map, skill, skill_tree)) count++;
        }

        return count;
    }

    public boolean pos(Map<Character, Character> map , String skill, String skill_tree) {

        boolean[] p = new boolean['Z' + 1];
        Arrays.fill(p, true);

        for (int i = 1; i < skill.length(); i++) {
            p[skill.charAt(i)] = false;
        }

        for (int i = 0; i < skill_tree.length(); i++) {
            char s = skill_tree.charAt(i);

            if (!p[s]) return false;

            if (map.containsKey(s)) {
                p[map.get(s)] = true;
            }
        }

        return true;
    }
}