import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int[] s3array;
    static int k;
    static int n;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 0층 1- 14호 사람 채운다
        int[] array = new int[15];
//        for (int i = 0; i < array.length; i++) {
//            array[i] = i + 1;
//        }

        //1층 3호면 0층의 1~3호까지 누적합
        //2층 3호면 1층 1~3호까지 누적합
        //3층 3호면 2층 1~3호까지의 누적합
        /**
         * a/t
         * 3층 3호 사람 수를 구하기 위해 누적합을 0층부터 차례로 구해야 하는지
         * 호근 다른 방법으로 구할 수 있는지 체크
         */

        int tc = sc.nextInt();
        s3array = new int[15];
        for (int i = 1; i <= tc; i++) {

            int k = sc.nextInt();
            int n = sc.nextInt();
            //1층 3호일 때 1, 2, 3
            //3층 3호일 때 123 / 1 123 / 2 123

            int start = 1;

            for (int p = 0; p < array.length; p++) {
                array[p] = p + 1;
            }
            s3array[0] = array[0];

            while (start <= k) {

//                System.out.println("START: " + start);
                for (int x = 1; x <= array.length; x++) {
                    if (x > n) {
                        break;
                    }
                    s3array[x] = s3array[x - 1] + array[x];
                }
                array = s3array;

//                System.out.print("누적합::" + Arrays.toString(s3array));

                //누적합으로 반복하니 sb에 전체 추가됨, 3층 10호일 땐 3층 10호만 count 해야하는데 1,2층까지 같이 count

                start++;
            }
            sb.append(s3array[n - 1]).append("\n");
        }
        System.out.println(sb.toString().trim());

    }
}