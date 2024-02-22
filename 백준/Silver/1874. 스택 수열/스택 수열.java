import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stk = new Stack<>();

        int start = 0;

        // n개의 stk 원소 처리
        for (int i = 0; i < n; i++) {
            // n개의 x를 입력받기
            int x = Integer.parseInt(br.readLine());
            //peek가 x보다 작다면, x와 같아질 때까지 push
            if (start < x) {
                //peek+1부터
                for (int j = start + 1; j <= x; j++) {
                    stk.push(j);
                    sb.append("+").append("\n");
                }
                // start 초기화
                start = x;
            }
            //target과 같다면 stk에서 pop
            if (stk.peek() == x) {
                stk.pop();
                sb.append("-").append("\n");

            } else {
                System.out.println("NO");
                //불가능한 경우 종료
                return;
            }
        }
        System.out.println(sb);

    }
}


