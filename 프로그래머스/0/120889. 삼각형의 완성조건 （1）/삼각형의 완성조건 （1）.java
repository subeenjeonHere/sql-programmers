import java.util.*;
class Solution {
    public int solution(int[] sides) {
        int answer = 0;
        
        ArrayList<Integer> list = new ArrayList<>();
        
        int max=0;
        for(int i=0; i< sides.length; i++){
            list.add((sides[i]));
        }
        
        int maxVal = 0;
        maxVal = Collections.max(list);
        list.remove(list.indexOf(maxVal));
        
        int sum = 0;
        for(int j=0; j<list.size(); j++){
            sum += list.get(j);
        }
        
       return answer = (sum > maxVal) ? 1 : 2;

    }
}