import java.util.*;

class Solution {
    public String solution(String my_string) {
        
        String str = my_string;
        String[] arr = new String[str.length()];
        
        for(int i=0; i < str.length(); i++){
            arr[i] = String.valueOf(str.charAt(str.length()-i-1));
        }
    
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<arr.length; i++){
            sb.append(arr[i]);
        }
        return sb.toString();
    }
}