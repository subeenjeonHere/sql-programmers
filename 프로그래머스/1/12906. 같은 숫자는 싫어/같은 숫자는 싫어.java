import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
    
        
        Stack<Integer> stk = new Stack<>(  );
        //스택에 첫 번째 값 삽입
        stk.push(arr[0]);
        
        for(int i=1; i<arr.length; i++){
            if(!stk.isEmpty() && stk.peek().equals(arr[i])){
                continue;
            } else if(!stk.isEmpty()&&!stk.peek().equals(arr[i])){
                stk.push(arr[i]);
            }
        }    
        
        int[] answer = new int[stk.size()];

        for(int i=answer.length-1; i>=0; i--){
            answer[i] = stk.pop();
        }
    
        return answer;
    }
}