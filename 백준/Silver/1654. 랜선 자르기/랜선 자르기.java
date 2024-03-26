

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Review 반복 범위
 * <p>
 * 웬만한 테케 통과하는데 몇몇 반례의 +1로 출력됨
 */
public class Main {
    //k랜선 저장 배열
    static int[] arr;
    //k,n
    static int k, n;
    //랜선 개수 체크 카운팅 변수
    static long count;
    //최소, 최대값
    static long min, max;
    //중간값
    static long mid;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //K, N 입력받기
        //갖고있는 랜선 K, 필요한 랜선 N
        String[] kn = br.readLine().split(" ");
        k = Integer.parseInt(kn[0]);
        n = Integer.parseInt(kn[1]);

        //K 줄에 갖고 있는 랜선 길이 입력
        //배열 할당
        arr = new int[k];

        min = 1;
        max = Long.MAX_VALUE;


        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        System.out.print(BS());
    }

    private static long BS() {
        //중간값
        mid = 0;
        while (min <= max) {
            //랜선개수
            count = 0;
            //중간값 찾기
//            mid = (min + max) / 2;
            mid = min + (max - min) / 2;
            // 이렇게 매번 몫 구할 수 없다
            for (int i = 0; i < arr.length; i++) {
                count += arr[i] / mid;
            }
            if (count < n) {
                max = mid - 1;
            } else if (count >= n) {
                min = mid + 1;
            }
        }
//        System.out.println(mid + " " + (min - 1));
        return Math.min(mid, min - 1);
//        return mid;
    }
}
