
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    //Static 변수들 선언
    // 토큰 값들 저장할 배열 생성, 정답 변수, 스택
    public static int answer;
    public static String[] tokens;
    public static Stack<Tower> stack = new Stack<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();


        // 탑의 개수 n 입력
        int n = Integer.parseInt(br.readLine());

        //토큰 값들 저장할 배열 객체 생성
        tokens = new String[n];

        //토큰에 n개 탑 입력
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < tokens.length; i++) {
            tokens[i] = stk.nextToken();
//            System.out.println("토큰: " + tokens[i]);
        }

        // 탑 스택에 push or not
        for (int i = 0; i < tokens.length; i++) {

            //탑 불러오기
            int height = Integer.parseInt(tokens[i]);
//            System.out.println("New 탑: " + height);

            //스택 비어있지않으면
            while (!stack.isEmpty()) {
                /**
                 * 9일 때 5, 9>5이니 9의 idx를 저장하고 5 push
                 * 5일 때 7, 5<7이니 pop을 해주고 나감
                 * 다시 돌아오면 top은 9, 9>7이니 idx를 저장하고 5 push
                 */
                if (stack.peek().height >= height) {
//                    System.out.println("현재 스택의 top이 더 클 때::: " + stack.peek().height);
//                    System.out.println("현재 스택의 top이 더 클 때 탑의 인덱스::: " + stack.peek().idx);
                    //현재 Top이 더 클 때, idx 기록
                    sb.append(stack.peek().idx + 1).append(" ");
                    //stack에 new 탑 push
                    stack.push(new Tower(i, height));
                    break;
                    //다음 탑으로 이동 종료
                }
                // e.i. 7일 때, 5 pop 해주고 top이 다시 9일 때 비교 해야 함
                stack.pop();

            }

            //맨 처음, 스택 비어있다면 0입력, stack에 첫 번째 push
            if (stack.isEmpty()) {
//                System.out.println("스택: " + stack.toString());
//                System.out.println("토큰: " + tokens[i]);

                //6을 push할 것, idx는 0 token 0번지에 6저장
                stack.push(new Tower(i, Integer.parseInt(tokens[i])));
                sb.append("0").append(" ");
            }
        }
        System.out.print(sb.toString());
    }

    // 스택 원소 idx, height 저장
    static class Tower {
        int idx;
        int height;

        public Tower(int idx, int height) {
            this.idx = idx;
            this.height = height;
        }
    }

}
