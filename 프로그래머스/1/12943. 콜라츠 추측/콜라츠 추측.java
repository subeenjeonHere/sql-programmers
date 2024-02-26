class Solution {
    public int solution(int num) {
        int answer = 0;
        long longNum = (long) num;
        int sum = 0;
        
        while(longNum !=1){
            if(longNum%2==0){
                longNum = isEven(longNum);
                sum++;
            }else{
                longNum = isOdd(longNum);
                sum++;
            }
            if(sum > 500){
                return -1;
            }
            
            
    }
    
         answer = sum;
        return answer;
    }    
    static long isEven(long n ){
        long i = n/2;
        return i;
    }
    static long isOdd(long n ){
        long i = n*3+1;
        return i;
    }
}