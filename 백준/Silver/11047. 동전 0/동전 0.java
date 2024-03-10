import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
        int[] info = new int[2];
        int i = 0;
        while (stk.hasMoreTokens()) {
            info[i] = Integer.parseInt(stk.nextToken());
            i++;
        }
    //    System.out.println(Arrays.toString(info));

        //동전 가치 저장
        int[] coin = new int[info[0]];
        for (int j = 0; j < coin.length; j++) {
            coin[j] = Integer.parseInt(br.readLine());
        }
      //  System.out.println(Arrays.toString(coin));

        //목표 가치
        int k = info[1];
        int remain = 0;
        int count = 0;
        int j = coin.length - 1;

        while (j >= 0) {
    //        System.out.println("Coin: " + coin[j]);

            //K보다 코인 가치가 크면 나눌 수 없으므로 다음 코인 사용 위해 j 하나 감소시키고, 반복문 종료
            //k <= 동전 이라면 나눌 수 있다. 반복문에서 나눠질 수 있는 코인에 도달하게 된다. k를 나눌 수 있는 최대의 동전인 것이다.
            // 그럼 그 동전으로 나눌 수 있는 만큼 나눠준다

            /**
             * @Point
             * -  최대의 동전으로 나누고 남은 가치를 나눌 수 있는 동전이 없을 때
             *  가치에 직전에 나눴던 동전 1개만큼을 다시 더해주고, Count를 하나 빼주고 (즉 1개 무효) 나눌 수 있는 동전이 있는지 체크
             * - 음수가 될 때
             */

            if (coin[j] <= k) {
              //  System.out.println("나눌 수 있음: " + coin[j] + "/ k:  " + k);
                count += k / coin[j];
                remain = k % coin[j];
                k = remain;
                if (k == 0) {
          //          System.out.println("나눠짐");
                    System.out.println(count);
                    return;
                }
            }
            j--;

         //   System.out.println("Coin, remain, Count: " + coin[j] + " " + remain + " " + count);
        }
    }
}
