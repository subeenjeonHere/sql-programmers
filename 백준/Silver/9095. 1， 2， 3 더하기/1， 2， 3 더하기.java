//package baek_joon.class_3.더하기123;


import java.util.Scanner;

// 정수 n, n을 1,2,3의 합으로 나타내는 방법의 수
public class Main {
    static int n;
    static int tc;
    static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        //테케
        tc = sc.nextInt();
        for (int j = 0; j < tc; j++) {
            n = sc.nextInt();

            if (n == 1) {
                sb.append("1").append("\n");
//                continue;
            }
            if (n == 2) {
                sb.append("2").append("\n");
                // continue;
            }
            if (n == 3) {
                sb.append("4").append("\n");
                //continue;
            }
            if (n > 3) {
                dp = new int[n + 1];

                for (int i = 4; i <= n; i++) {

                    dp[1] = 1;
                    dp[2] = 2;
                    dp[3] = 4;

                    dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
                }
                sb.append(dp[n]).append("\n");
            }

        }

        System.out.print(sb.toString().trim());
    }
}
