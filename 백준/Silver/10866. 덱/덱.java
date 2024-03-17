//package baek_joon.class_2.덱;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Deque<Integer> deq = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            String[] s = new String[2];
            StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
            int start = 0;
            while (stk.hasMoreTokens()) {
                s[start] = stk.nextToken();
                start++;
            }
            if (s[0].equals("push_front")) {
                deq.addFirst(Integer.parseInt(s[1]));

            } else if (s[0].equals("push_back")) {
                deq.addLast(Integer.parseInt(s[1]));

            } else if (s[0].equals("pop_front")) {
                if (deq.isEmpty()) {
                    System.out.println("-1");

                } else {
                    int first = deq.pollFirst();
                    System.out.println(first);

                }

            } else if (s[0].equals("pop_back")) {
                if (deq.isEmpty()) {
                    System.out.println("-1");
                } else {
                    int last = deq.pollLast();
                    System.out.println(last);
                }
            } else if (s[0].equals("size")) {
                System.out.println(deq.size());
            } else if (s[0].equals("empty")) {
                if (deq.isEmpty()) {
                    System.out.println("1");
                } else {
                    System.out.println("0");
                }
            } else if (s[0].equals("front")) {
                if (deq.isEmpty()) {
                    System.out.println("-1");
                } else {
                    System.out.println(deq.peekFirst());
                }
            } else if (s[0].equals("back")) {
                if (deq.isEmpty()) {
                    System.out.println("-1");
                } else {
                    System.out.println(deq.peekLast());
                }
            }
        }
    }
}
