import java.io.*;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine());

        //Declare 스택
        Stack<Integer> stack = new Stack<>();

        /**
         * for문으로 stack에 값 입력
         * 만약, "0"이면 가장 최근에 stack에 입력된 값 pop, 0일 경우, !stack.isEmpty 보장
         * 아니면, push
         */
        for (int i = 0; i < k; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                stack.pop();
            } else {
                stack.push(num);
            }
        }

        /**
         * print: 스택의 모든 원소 합
         */
        int answer = 0;
        for (int element : stack) {
            answer += element;

        }
        System.out.println(answer);
    }
}
