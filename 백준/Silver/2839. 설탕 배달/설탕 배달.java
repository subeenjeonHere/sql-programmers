import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cnt5 = 0;
        int cnt3 = 0;

        cnt5 = n / 5;

        int res = n % 5;

        while (res >= 0) {
            if (res % 3 == 0) {
                cnt3 = res / 3;
                break;
            }
            if (res == n) {
                System.out.println("-1");
                return;
            }
            cnt5--;
            res += 5;
        }
        System.out.println(cnt3 + cnt5);

    }
}