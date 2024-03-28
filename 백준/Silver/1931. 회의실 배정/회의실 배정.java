//package baek_joon.class_3.회의실배정;

import javax.crypto.Cipher;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @Point 그리디
 * <p>
 * <p>
 * - -
 * 회의 개수 최대
 * 가장 일찍 끝나고 -> 가장 빨리 시작하는
 * 즉 회의와 회의 사이 간격을 최소화
 * 최적선택: 직전 행 종료 시간보다 크고, 진행되지 않은 회의 중 가장 빨리 시작하는 회의
 */
public class Main {

    static ArrayList<ArrayList<Integer>> arrayList;
    static ArrayList<ArrayList<Integer>> resultList;

    public static void main(String[] args) throws IOException {
        //N개 회의 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //회의 개수 입력받기
        int n = Integer.parseInt(br.readLine());

        //자료구조 할당
        arrayList = new ArrayList<ArrayList<Integer>>();
        resultList = new ArrayList<ArrayList<Integer>>();

        //리스트에 행 할당, 회의 시간표 저장
        for (int i = 0; i < n; i++) {
            arrayList.add(new ArrayList<>());
            String[] info = br.readLine().split(" ");
            int st = Integer.parseInt(info[0]);
            arrayList.get(i).add(st);
            for (int j = 0; j < 1; j++) {
                int end = Integer.parseInt(info[1]);
                arrayList.get(i).add(end);
            }
        }

        //전체 회의를 종료 시간 순으로 오름차순 정렬
        //종료시간이 같다면 시작 시간 빠른 것 우선
        //종료시간이 같은 경우를 체크하기 위해 종료시간을 시작 시간 변수에 저장해두고 종료시간 같은 경우가 오면 비교
//        int min = arrayList.get(0).get(1);
//        int temp = 0;
//        int s2 = 0;
//        int e2 = 0;
//        for (int i = 0; i < arrayList.size() - 1; i++) {
//            e2 = arrayList.get(i + 1).get(1); //종료 시간
//            s2 = arrayList.get(i + 1).get(0); //시작 시간
//            //선택된 회의 종료 시간이 최소 종료시간 보다 작다면
//            //해당 행 결과리스트에 저장
//            if (min > e2) {
//                resultList.add(arrayList.get(i + 1));
//            }
//        }
        //가장 첫 번째 종료 회의를 인덱스에 넣어줌
        resultList.add(arrayList.get(0));

        //종료 시간 같은 경우, 시작 시간 빠른 순으로 정렬
        //Comparator 사용해야 함
        Collections.sort(arrayList, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                //종료 시간에 대해 비교
                int endTimeCompare = o1.get(1).compareTo(o2.get(1));
                //종료시간이 같다면, 시작 시간으로 비교
                if (endTimeCompare == 0) {
                    return o1.get(0).compareTo(o2.get(0));
                }
                //종료시간 다르면, 그 결과 반환
                return endTimeCompare;
            }
        });
        //System.out.println(arrayList);

        //종료시간이 같은 경우, 시작 시간이 더 빠른 걸 선택하는 것이 유리함
        // if(i-1) 회의 종료 시간 < i 회의 시작 시간 이라면 카운트 증가
        int count = 0;
        int new_End = arrayList.get(0).get(1);
        for (int i = 1; i < arrayList.size(); i++) {
            //하나의 종료시간이 선택됐으면, 직전 회의 종료 시간도 업데이트 되어야 함.
            int s1 = arrayList.get(i).get(0);
            if (s1 >= new_End) {
                count++;
                new_End = arrayList.get(i).get(1);
            }
        }
        System.out.print(count + 1);

//        for (int i = 1; i < arrayList.size() ; i++) {
//            //항상 선택된 회의의 맨 마지막 기준
//            int len = resultList.size();
//            int e1 = resultList.get(len - 1).get(1);
//
//            for (int j = 1; j < arrayList.size(); j++) {
//
//                int s1 = arrayList.get(j).get(0);
//                if (s1 >= e1) {
//                    count++;
//                    resultList.add(arrayList.get(j));
//                    break;
//                }
//            }
//        }


    }
}

