
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 알파벳이 등장하는 위치
 * Ascii 활용
 * 사용되는 알파벳이 없다면 -1 , 있다면 문자열 배열의 idx를
 * baekjoon이라면 ascii 인덱스
 * b가 0번째에 있다면, 결과 배열의 b(1) 에 1을 저장
 * for문을 뭘 기준으로 할지
 * 결과 배열을 기준으로 0부터 끝까지 순회한다
 * 아스키코드를 활용한다. a - z 는 97 - 122이다
 * minus 97을 하면 a는 0번째 인덱스에 위치할 수 있다
 * b a e k j o o n 일 때, b(98) - 97 'a'를 하면 1이 된다. 1에 문자열 i 를 저장한다
 * 왜냐면 i번째일 때 b를 만났으므로
 */
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String[] array = new String[s.length()];
        for (int i = 0; i < s.length(); i++) {
            array[i] = String.valueOf(s.charAt(i));
        }

        int[] result = new int[26];

        for (int j = 0; j < array.length; j++) {
            int c = array[j].charAt(0);
            if (result[c - 97] != 0) {
                continue;
            }
            result[c - 97] = j;
        }
        for (int x = 0; x < result.length; x++) {

            //String 의 0번째 위치에 있는 값이 0인데, 이 때 -1도 대입되는 현상
            if (result[x] == 0) {
                result[x] = -1;
            }
        }
        int zero = array[0].charAt(0) - 97;
        result[zero] = 0;
        
        StringBuilder sb = new StringBuilder();
        for (int ele : result) {
            sb.append(ele).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}
