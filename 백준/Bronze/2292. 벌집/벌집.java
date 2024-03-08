

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int cnt = 0;
        int num = 1;
        //3의 배수

        // 1 3 6 10
        // cnt 1일 때, 6 * 1
        // cnt 2일 때, 6 * 3
        // cnt 3일 때, 6 * 6
        // cnt 4일 때, 6 * 10
        for (int i = 1; i <= n; i++) {
            if (n == 1) {
                System.out.println("1");
                return;
            }
            cnt += i;
            num = 6 * cnt;
//            System.out.println("NUM:::" + num);
//            System.out.println("Cnt: " + cnt);
//            System.out.println("I: " + i);

            if (n <= num + 1) {
//                System.out.println(n + " : " + num);
//                System.out.println(n + " : " + (num + 1));
                System.out.println(i + 1);
                return;
            }
        }

//        while (n >= num) {
//            if (n <= 7) {
//                System.out.println(cnt + 1);
//                break;
//            }
//            num = 6 * (3 * (cnt - 1));
//            System.out.println("num: " + num);
//            if (n < num + 1) {
//                System.out.println("Num+1 =" + (num + 1));
//                System.out.println(cnt + 1);
//                return;
//            }
//            cnt++;
//            System.out.println("CNT: " + cnt);
//        }


    }
}
