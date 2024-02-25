import java.util.*;
class Solution {
    public Stack<Integer> solution(int[] arr) {
        int[] answer = {};
        int min= arr[0];
        
        for(int i=0; i<arr.length; i++){
            if(min>arr[i]){
                min = arr[i];
            }
        }
       
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0; i<arr.length; i++){
            if(min == arr[i]){
                continue;
            }


            stack.push(arr[i]);
        }

      
        return stack;
    }
}