//package baek_joon.class_3.잃어버린괄호;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    static String[] nums;
    static int[] res;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //식 입력 받기
        String s = br.readLine();

        // - 를 기준으로 구분해서 배열 저장
        nums = s.split("[-]");
        res = new int[nums.length];

        //각 원소들은 +로 연결되어있거나 or Not
        // +로 연결되어 있는 경우 두 숫자를 더하고 int 배열에 합계 형태로 저장
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            String a = nums[i];
            if (a.contains("+")) {
                String[] ab = a.split("[+]");
                for (String ele : ab) {
                    sum += Integer.parseInt(ele);
                }
                res[i] = sum;
                sum = 0;
            } else {
                res[i] = Integer.parseInt(a);
            }
        }
//        System.out.println(Arrays.toString(res));

        // 첫 번째 원소 부터 빼기 연산
        int result = res[0];
        for (int i = 1; i < res.length; i++) {
            result -= res[i];
        }
        System.out.print(result);


    }
}
// 55 - 90
// 1+2-3+4-5
// 1+2 , 3+4, 5 -> 3 -7 -5