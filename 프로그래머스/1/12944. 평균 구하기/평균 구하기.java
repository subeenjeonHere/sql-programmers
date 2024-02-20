import java.util.*;
class Solution {
    public double solution(int[] arr) {
        double answer = 0;
        
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<arr.length; i++){
            list.add(arr[i]);
        }
        answer = list.stream()
            .mapToDouble(Integer::doubleValue)
            .average()
            .orElse(0.0);
        return answer;
    }
}