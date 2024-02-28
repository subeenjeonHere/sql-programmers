
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        //n입력 받기, 대문자 변환
        String[] strings = br.readLine().toUpperCase().split("");

        //ascii 65~90
        //Ascii를 idx로 카운팅할 배열 생성
        int[] arr = new int[26];

        //string 배열 전체 순회
        for (int i = 0; i < strings.length; i++) {

            int charToAscii = (int) strings[i].charAt(0);
            sb.append(charToAscii).append(" ");

            //Int ascii 65 ~ 90 사이라면
            if (charToAscii >= 65 && charToAscii <= 90) {
                //idx를 증가
                //동일한 값이라면

                // 65 - 90 아스키코드, arr 배열의 idx를 아스키코드 idx로 만들기
                //A라면 Idx가 0이 되도록, A ascii는 65, B는 66, A를 0번지로 하고싶다면 65 - 65 B를 1번지 66 - 65 >>..
                arr[charToAscii - 'A']++;
            }
        }
//        System.out.println("카운팅: " + Arrays.toString(arr));


        //Max인 문자를 찾아야 함
        //Max값 여러개일 경우, ? 출력, Max값을 찾을 경우, 인덱스에 + 'A'를 더함
        int max = arr[0];
        char answer = '?';
        for (int i = 0; i < arr.length; i++) {

            //배열 순회하며 max 찾으면 max 치환
            //여러개일 경우 어떻게 할 것?
            if (max <= arr[i]) {
                max = arr[i];
                answer = (char) (i + 65);
            }
        }
        int maxValue = 0;
        for (int j = 0; j < arr.length; j++) {
            if (max == arr[j]) {
                maxValue++;
            }
        }
        if (maxValue > 1) {
            System.out.println("?");
        } else {
            System.out.println(answer);
        }
    }

}
