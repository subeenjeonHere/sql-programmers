import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            String strings = sc.next();

//            System.out.println("STrings: " + strings);

            //n줄로 출력
            //num만큼 charat을 반복
            //strings의 길이 만큼
            //num만큼


            for (int x = 0; x < strings.length(); x++) {
                for (int j = 0; j < num; j++) {
                    sb.append(strings.charAt(x));
                }
            }
            sb.append("\n");

        }
        System.out.println(sb.toString());
    }
}