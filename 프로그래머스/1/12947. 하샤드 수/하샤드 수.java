class Solution {
    public boolean solution(int x) {
        boolean answer = false;
        //String으로 변환하여 x 자릿수별 추출 -> 합 구하고 나눠지면 true
        String s = String.valueOf(x);
        int[] arr = new int[s.length()];
 
        int sum=0;
        
        for(int i=0; i < arr.length; i++){
            sum+= s.charAt(i) -'0';
        }
        
        if(x%sum==0){
            answer = true;
        }
         // 10000이하이므로, 자릿수 알지못함, String 배열 생성후 각 자릿수의 합을 sum에 저장후 division
         
          
        return answer;
    }
}