import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //배열 생성
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        //X 입력받기
        int x = sc.nextInt();

        //ASC 정렬
        Arrays.sort(arr);

        int cnt = 0;
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            if (arr[start] + arr[end] == x) {
  //              System.out.println("Start:" + start + "// End:" + end);

//                System.out.println(arr[start] + " " + arr[end]);
                cnt++;
                end--;
            } else if (arr[start] + arr[end] < x) {


                start++;
            } else if (arr[start] + arr[end] > x) {
//                System.out.println("Start:" + start + "// End:" + end);


                end--;
            }
        }

        System.out.println(cnt);
    }
}