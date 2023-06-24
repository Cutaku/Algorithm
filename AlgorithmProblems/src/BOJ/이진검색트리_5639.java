package BOJ;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 이진검색트리_5639 {
    static List<Integer> list;
    static Stack<Integer> stack;
    static boolean[] used;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        list = new ArrayList<>();
        stack = new Stack<>();

        while (true) {
            try {
                list.add(Integer.parseInt(br.readLine()));
            } catch (Exception e) {
                break;
            }
        }

        used = new boolean[list.size()];

        traverse(0);

        while (!stack.isEmpty()) bw.append(stack.pop() + "\n");

        bw.flush();
    }

    public static void traverse(int i) {

        if (i >= list.size() || used[i]) return;

        used[i] = true;
        stack.add(list.get(i));

        int j = i + 1;

        while (j < list.size() && list.get(j) < list.get(i)) j++;

        traverse(j);
        traverse(i + 1);
    }
}