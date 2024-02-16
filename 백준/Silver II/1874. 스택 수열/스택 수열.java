import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

/**
 * start 변수를 언제 초기화해야 하는지
 */

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int start = 0;

        int n = Integer.parseInt(br.readLine());
        for (int k = 0; k < n; k++) {
            int x = Integer.parseInt(br.readLine());

            // start < x라면, start 부터 x 까지 삽입해줘야 함
            // 어디까지 입력 받았는지 알기 위해, start를 x로 초기화 (x까지 입력했기 때문에 5부터 push해주기 위함)
            // 4까지 입력, 6을 push하기 위해 next 5부터 입력되어야 함
            if (start < x) {
                for (int i = start + 1; i <= x; i++) {
                    stack.push(i);
//                    System.out.println("Push: " + i);
                    sb.append("+").append("\n");
                }
                start = x;
            }
            // stack의 peek과, x과 같은 경우 Pop
            if (stack.peek() == x) {
                stack.pop();
                sb.append("-").append("\n");
            } else {
                System.out.println("NO");
                return;
            }
        }
        System.out.println(sb);
    }
}