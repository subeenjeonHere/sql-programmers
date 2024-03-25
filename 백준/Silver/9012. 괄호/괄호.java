//package baek_joon.class_2.괄호;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.BatchUpdateException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.SimpleTimeZone;
import java.util.Stack;

/**
 * @Point 스택
 */
public class Main {
    static Stack<Integer> stk;
    static String[] strings;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        //테케 만큼 반복
        for (int i = 0; i < t; i++) {
            String a = br.readLine();

            strings = new String[a.length()];
            strings = a.split("");
            //스택 메소드 호출
            sb.append(stack(strings)).append("\n");
        }
        System.out.print(sb.toString().trim());
    }

    private static String stack(String[] strings) {

        //스택 할당

        stk = new Stack<>();
        //문자열 길이
        int len = strings.length;
        //+- 연산할 변수
        int cnt = 0;

        //첫 번째 문자열 )면 No 리턴
        if (strings[0].equals(")")) {
            return "NO";
        }

        int start = 0;
        while (start < len) {

            String a = strings[start];
            if (stk.isEmpty() && a.equals(")")) {
                return "NO";
            }
            if (a.equals("(")) {
                stk.push(1);
            } else {
                if (stk.peek() == 1) {
                    stk.pop();
                    start++;
                    continue;
                }
                stk.push(-1);
            }
            start++;
        }


        if (stk.size() == 0) {
            return "YES";
        } else {
            return "NO";
        }
    }

}
