

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Point 중복 고려해야했음
 * 1 2
 * 1 1 이라면 뒤는 0이 와야함
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        HashMap<Long, Long> map = new HashMap<>();
        long val = 0;
        //상근이가 갖고 있는 숫자 카드 N개
        int n = sc.nextInt();

        //N개의 숫자 카드 키로 입력
        //포함하고 있지 않다면, 새로운 키를 생성하고 val값 1
        //이미 키가 있다면, val 값을 ++1하여 갱신
        for (int i = 1; i <= n; i++) {
            long key = sc.nextLong();

            //중복 된 값 갱신하더라도 중간에 val 1로 초기화되면 다시 1로 갱신됨
            if (!map.containsKey(key)) {
                val = 1;
                map.put(key, val);
            } else {
                long newVal = map.get(key);
                newVal += 1;
                map.put(key, newVal);
            }
        }

        //상근이가 몇 개 가지고 있는 숫자 카드인지 구해야 할 M개의 정수
        int m = sc.nextInt();
        //m개의 정수들을 저장할 배열 선언
        //m개의 정수 = 키 값 인 것의 value를 출력해주면 됨
        //키를 포함하고 있다면, 그 키의 밸류를 스트링 빌더에 더하자
        StringBuilder sb = new StringBuilder();
        int start = 0;
        while (start < m) {
            long num = sc.nextInt();
            if (map.containsKey(num)) {
                sb.append(map.get(num)).append(" ");
//                map.put(num, 0L);
            } else {
                sb.append("0").append(" ");
            }
            start++;
        }


        System.out.print(sb.toString().trim());
    }
}

//Map을 쓴 이유
//Map이 생각남
//N개의 숫자 카드 정수를 Key, 갯수를 Value로 하여 카운팅 하려고
//배열 순회하고 같다면 ++ 방법은 시간 복잡도 O (n^2)일 것 같아서
